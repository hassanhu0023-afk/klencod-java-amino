<!DOCTYPE html>
<html lang="ar" dir="rtl">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>أمينو ستوديو - مجتمعات ومدونات</title>
  <style>
    :root {
      --bg-main: #12101c;
      --bg-card: rgba(28, 24, 43, 0.92);
      --bg-card-soft: rgba(42, 36, 64, 0.85);
      --accent: #7c4dff;
      --accent-2: #ff4081;
      --text-main: #ffffff;
      --text-muted: #b8b2cc;
      --border: rgba(255, 255, 255, 0.12);
      --profile-bg: linear-gradient(135deg, #5e35b1, #d81b60);
    }

    * {
      box-sizing: border-box;
      font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
      margin: 0;
      min-height: 100vh;
      color: var(--text-main);
      background: var(--bg-main);
      background-size: cover;
      background-position: center;
      background-attachment: fixed;
      transition: background 0.3s ease;
    }

    /* شريط علوي بأسلوب أمينو */
    .topbar {
      position: sticky;
      top: 0;
      z-index: 20;
      background: rgba(18, 16, 28, 0.9);
      backdrop-filter: blur(10px);
      border-bottom: 1px solid var(--border);
      padding: 12px 14px;
      display: flex;
      align-items: center;
      justify-content: space-between;
      gap: 8px;
    }

    .brand {
      font-weight: 800;
      font-size: 17px;
      letter-spacing: 0.3px;
      display: flex;
      align-items: center;
      gap: 8px;
    }

    .pill-badge {
      background: linear-gradient(45deg, var(--accent), var(--accent-2));
      padding: 3px 9px;
      border-radius: 999px;
      font-size: 11px;
      font-weight: bold;
    }

    /* شريط التبويبات */
    .nav-tabs {
      display: flex;
      background: rgba(22, 19, 34, 0.95);
      border-bottom: 1px solid var(--border);
      position: sticky;
      top: 53px;
      z-index: 19;
    }

    .nav-btn {
      flex: 1;
      background: none;
      border: none;
      color: var(--text-muted);
      padding: 12px 6px;
      font-size: 13px;
      font-weight: 700;
      cursor: pointer;
      border-bottom: 3px solid transparent;
      transition: 0.2s;
    }

    .nav-btn.active {
      color: #fff;
      border-bottom-color: var(--accent-2);
      background: rgba(124, 77, 255, 0.12);
    }

    .app-wrap {
      max-width: 680px;
      margin: 0 auto;
      padding: 14px 14px 85px;
    }

    .section { display: none; }
    .section.active { display: block; }

    /* البطاقات وأماكن المدونات */
    .card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 14px;
      padding: 14px;
      margin-bottom: 14px;
      box-shadow: 0 8px 24px rgba(0, 0, 0, 0.28);
    }

    .card-header {
      display: flex;
      align-items: center;
      justify-content: space-between;
      gap: 10px;
      margin-bottom: 10px;
    }

    .author-row {
      display: flex;
      align-items: center;
      gap: 10px;
      flex-wrap: wrap;
    }

    .avatar {
      width: 40px;
      height: 40px;
      border-radius: 50%;
      background: linear-gradient(135deg, var(--accent), var(--accent-2));
      display: flex;
      align-items: center;
      justify-content: center;
      font-weight: 800;
      font-size: 16px;
      flex-shrink: 0;
    }

    .author-name {
      font-weight: 700;
      font-size: 14px;
    }

    /* الألقاب Titles */
    .titles-wrap {
      display: flex;
      flex-wrap: wrap;
      gap: 5px;
      margin-top: 4px;
    }

    .title-tag {
      font-size: 11px;
      font-weight: 700;
      padding: 2px 8px;
      border-radius: 6px;
      color: #fff;
      background: var(--accent);
      display: inline-block;
    }

    .title-tag.leader { background: #e53935; }
    .title-tag.curator { background: #00897b; }
    .title-tag.vip { background: #fb8c00; }
    .title-tag.writer { background: #8e24aa; }

    /* قسم المميز Featured مثل أمينو */
    .featured-box {
      background: linear-gradient(135deg, rgba(124, 77, 255, 0.22), rgba(255, 64, 129, 0.16));
      border: 1px solid rgba(255, 64, 129, 0.45);
      border-radius: 14px;
      padding: 12px;
      margin-bottom: 14px;
    }

    .featured-label {
      font-size: 12px;
      font-weight: 800;
      color: #ff80ab;
      margin-bottom: 8px;
      display: block;
    }

    /* حقول الإدخال والأزرار */
    input, textarea, select {
      width: 100%;
      background: var(--bg-card-soft);
      border: 1px solid var(--border);
      color: #fff;
      padding: 10px 12px;
      border-radius: 10px;
      margin-bottom: 10px;
      font-size: 14px;
    }

    textarea { resize: vertical; min-height: 85px; }

    .btn {
      border: none;
      border-radius: 10px;
      padding: 10px 14px;
      font-weight: 700;
      font-size: 13px;
      cursor: pointer;
      color: #fff;
      background: var(--accent);
      transition: transform 0.12s, opacity 0.2s;
    }

    .btn:active { transform: scale(0.97); }
    .btn-primary { background: linear-gradient(45deg, var(--accent), var(--accent-2)); width: 100%; }
    .btn-soft { background: var(--bg-card-soft); border: 1px solid var(--border); }
    .btn-danger { background: #c62828; }

    /* أزرار التفاعل داخل المدونات */
    .action-bar {
      display: flex;
      flex-wrap: wrap;
      gap: 8px;
      margin-top: 12px;
      padding-top: 10px;
      border-top: 1px solid var(--border);
    }

    .action-btn {
      background: var(--bg-card-soft);
      border: 1px solid var(--border);
      color: #fff;
      padding: 6px 11px;
      border-radius: 8px;
      font-size: 12px;
      font-weight: 700;
      cursor: pointer;
    }

    .action-btn.liked {
      background: rgba(255, 64, 129, 0.25);
      border-color: var(--accent-2);
      color: #ff80ab;
    }

    /* التعليقات */
    .comments-box {
      margin-top: 10px;
      background: rgba(12, 10, 20, 0.55);
      border-radius: 10px;
      padding: 10px;
    }

    .comment-item {
      font-size: 13px;
      padding: 6px 0;
      border-bottom: 1px dashed rgba(255, 255, 255, 0.08);
    }

    .comment-item:last-child { border-bottom: none; }

    /* بانر الملف الشخصي وخلفيته */
    .profile-banner {
      border-radius: 14px;
      overflow: hidden;
      border: 1px solid var(--border);
      margin-bottom: 14px;
      background: var(--profile-bg);
      background-size: cover;
      background-position: center;
    }

    .profile-overlay {
      background: rgba(12, 10, 20, 0.65);
      padding: 18px 14px;
    }

    .stats-grid {
      display: grid;
      grid-template-columns: repeat(3, 1fr);
      gap: 8px;
      margin-top: 12px;
      text-align: center;
    }

    .stat-box {
      background: rgba(255, 255, 255, 0.08);
      border-radius: 10px;
      padding: 8px;
    }

    .stat-num { font-size: 17px; font-weight: 800; display: block; }
    .stat-lbl { font-size: 11px; color: var(--text-muted); }

    /* شبكة اختيار الخلفيات */
    .bg-grid {
      display: grid;
      grid-template-columns: repeat(2, 1fr);
      gap: 8px;
      margin-bottom: 10px;
    }

    .bg-swatch {
      padding: 12px;
      border-radius: 10px;
      border: 2px solid transparent;
      cursor: pointer;
      font-weight: 700;
      font-size: 12px;
      text-align: center;
      color: #fff;
      text-shadow: 0 1px 3px rgba(0, 0, 0, 0.8);
    }

    .bg-swatch.selected { border-color: #fff; }

    /* الدردشة */
    .chat-stream {
      height: 320px;
      overflow-y: auto;
      background: rgba(12, 10, 20, 0.65);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 10px;
      margin-bottom: 10px;
    }

    .msg-bubble {
      background: var(--bg-card-soft);
      border: 1px solid var(--border);
      border-radius: 10px;
      padding: 8px 10px;
      margin-bottom: 8px;
    }

    .msg-top {
      display: flex;
      align-items: center;
      gap: 6px;
      flex-wrap: wrap;
      margin-bottom: 4px;
      font-size: 12px;
    }

    .row-flex {
      display: flex;
      gap: 8px;
      align-items: center;
    }

    .row-flex > * { margin-bottom: 0; }

    /* زر عائم سريع لكتابة مدونة */
    .fab {
      position: fixed;
      bottom: 18px;
      left: 18px;
      z-index: 25;
      background: linear-gradient(45deg, var(--accent), var(--accent-2));
      color: #fff;
      border: none;
      border-radius: 999px;
      padding: 13px 18px;
      font-weight: 800;
      font-size: 13px;
      box-shadow: 0 8px 20px rgba(124, 77, 255, 0.45);
      cursor: pointer;
    }

    .toast {
      position: fixed;
      bottom: 75px;
      left: 50%;
      transform: translateX(-50%);
      background: #231f36;
      border: 1px solid var(--accent);
      color: #fff;
      padding: 8px 16px;
      border-radius: 999px;
      font-size: 13px;
      z-index: 40;
      display: none;
    }
  </style>
</head>
<body>

  <div class="topbar">
    <div class="brand">
      <span>أمينو ستوديو</span>
      <span class="pill-badge" id="levelBadge">Lv.1</span>
    </div>
    <button class="action-btn" onclick="openTab('backgrounds')">🎨 الخلفيات</button>
  </div>

  <div class="nav-tabs">
    <button class="nav-btn active" id="tab-blogs" onclick="openTab('blogs')">📝 المدونات</button>
    <button class="nav-btn" id="tab-chat" onclick="openTab('chat')">💬 الدردشة</button>
    <button class="nav-btn" id="tab-titles" onclick="openTab('titles')">🏅 الألقاب</button>
    <button class="nav-btn" id="tab-profile" onclick="openTab('profile')">👤 الملف</button>
  </div>

  <div class="app-wrap">

    <!-- 1. قسم المدونات وأماكن النشر -->
    <section id="blogs" class="section active">
      <div class="card" id="createBlogCard">
        <h3 style="margin: 0 0 10px;">مكان كتابة مدونة جديدة</h3>
        <div class="row-flex" style="margin-bottom: 10px;">
          <select id="blogCategory">
            <option value="مدونة عامة">مدونة عامة</option>
            <option value="أنمي ورسم">أنمي ورسم</option>
            <option value="برمجة وتقنية">برمجة وتقنية</option>
            <option value="ألعاب وقصص">ألعاب وقصص</option>
          </select>
          <select id="blogFeaturedOption">
            <option value="0">نشر عادي</option>
            <option value="1">تثبيت في المميز (Featured)</option>
          </select>
        </div>
        <input type="text" id="blogTitle" placeholder="عنوان المدونة..." />
        <textarea id="blogBody" placeholder="اكتب تفاصيل مدونتك هنا بأسلوب أمينو..."></textarea>
        <input type="text" id="blogCover" placeholder="رابط صورة للمدونة (اختياري)..." />
        <button class="btn btn-primary" onclick="publishBlog()">نشر المدونة الآن</button>
      </div>

      <div id="featuredContainer"></div>

      <div class="card" style="padding: 10px 12px;">
        <select id="filterCategory" style="margin-bottom: 0;" onchange="renderBlogs()">
          <option value="ALL">كل الأقسام والمدونات</option>
          <option value="مدونة عامة">مدونة عامة</option>
          <option value="أنمي ورسم">أنمي ورسم</option>
          <option value="برمجة وتقنية">برمجة وتقنية</option>
          <option value="ألعاب وقصص">ألعاب وقصص</option>
        </select>
      </div>

      <div id="blogsList"></div>
    </section>

    <!-- 2. قسم الدردشة -->
    <section id="chat" class="section">
      <div class="card">
        <h3 style="margin: 0 0 10px;">غرفة الدردشة العامة</h3>
        <div class="chat-stream" id="chatStream"></div>
        <div class="row-flex">
          <input type="text" id="chatText" placeholder="اكتب رسالتك..." onkeydown="if(event.key==='Enter') sendChat()" />
          <button class="btn" onclick="sendChat()">إرسال</button>
        </div>
      </div>
    </section>

    <!-- 3. قسم الألقاب -->
    <section id="titles" class="section">
      <div class="card">
        <h3 style="margin: 0 0 8px;">إدارة الألقاب (Titles)</h3>
        <p style="color: var(--text-muted); font-size: 13px; margin-top: 0;">
          الألقاب تظهر تحت اسمك في ملفك الشخصي وبجانب اسمك في المدونات والدردشة.
        </p>

        <label style="font-size: 13px; display: block; margin-bottom: 6px;">اختر لقباً جاهزاً أو اكتب لقبك الخاص:</label>
        <div class="row-flex" style="margin-bottom: 10px;">
          <input type="text" id="customTitleInput" placeholder="مثال: مصمم محترف أو قائد الفريق" />
          <select id="titleStyleSelect" style="max-width: 145px;">
            <option value="leader">أحمر (قائد)</option>
            <option value="curator">أخضر (منسق)</option>
            <option value="vip">برتقالي (VIP)</option>
            <option value="writer">بنفسجي (كاتب)</option>
          </select>
        </div>
        <button class="btn btn-primary" onclick="addTitle()">+ إضافة اللقب إلى حسابي</button>
      </div>

      <div class="card">
        <h4 style="margin: 0 0 10px;">ألقابي الحالية</h4>
        <div id="myTitlesList" class="titles-wrap"></div>
      </div>
    </section>

    <!-- 4. قسم الخلفيات -->
    <section id="backgrounds" class="section">
      <div class="card">
        <h3 style="margin: 0 0 8px;">تخصيص خلفيات التطبيق والملف</h3>
        <p style="color: var(--text-muted); font-size: 13px; margin-top: 0;">
          اختر خلفية جاهزة للتطبيق أو ضع رابط صورة مخصصة للخلفية العامة أو خلفية الملف الشخصي.
        </p>

        <div class="bg-grid" id="bgSwatches"></div>

        <label style="font-size: 13px; display: block; margin-bottom: 4px;">رابط صورة لخلفية التطبيق بالكامل (اختياري):</label>
        <input type="text" id="customAppBgUrl" placeholder="https://example.com/app-bg.jpg" />
        <button class="btn btn-soft" style="width: 100%; margin-bottom: 14px;" onclick="applyCustomAppBg()">تطبيق رابط خلفية التطبيق</button>

        <label style="font-size: 13px; display: block; margin-bottom: 4px;">رابط صورة لخلفية الملف الشخصي (اختياري):</label>
        <input type="text" id="customProfileBgUrl" placeholder="https://example.com/profile-bg.jpg" />
        <button class="btn btn-primary" onclick="applyCustomProfileBg()">حفظ خلفية الملف الشخصي</button>
      </div>
    </section>

    <!-- 5. قسم الملف الشخصي -->
    <section id="profile" class="section">
      <div class="profile-banner" id="profileBanner">
        <div class="profile-overlay">
          <div class="author-row">
            <div class="avatar" id="profileAvatar">م</div>
            <div>
              <div class="author-name" id="profileNameDisplay" style="font-size: 18px;">عضو_أمينو</div>
              <div id="profileBioDisplay" style="font-size: 12px; color: var(--text-muted);">عاشق للمجتمعات والمدونات الإبداعية</div>
            </div>
          </div>

          <div id="profileTitlesDisplay" class="titles-wrap" style="margin-top: 10px;"></div>

          <div class="stats-grid">
            <div class="stat-box">
              <span class="stat-num" id="statRep">15</span>
              <span class="stat-lbl">السمعة (Rep)</span>
            </div>
            <div class="stat-box">
              <span class="stat-num" id="statBlogs">0</span>
              <span class="stat-lbl">المدونات</span>
            </div>
            <div class="stat-box">
              <span class="stat-num" id="statTitles">0</span>
              <span class="stat-lbl">الألقاب</span>
            </div>
          </div>
        </div>
      </div>

      <div class="card">
        <h3 style="margin: 0 0 10px;">تعديل بيانات الملف</h3>
        <input type="text" id="editName" placeholder="الاسم المستعار" />
        <input type="text" id="editBio" placeholder="النبذة التعريفية (Bio)" />
        <button class="btn btn-primary" onclick="saveProfile()">حفظ التعديلات</button>
      </div>
    </section>

  </div>

  <button class="fab" onclick="quickNewBlog()">+ مدونة جديدة</button>
  <div class="toast" id="toast"></div>

  <script>
    const STORAGE_KEY = "amino_studio_v1";

    const PRESET_BGS = [
      { id: "dark_violet", name: "بنفسجي أمينو", css: "radial-gradient(circle at top, #2c1b4e, #12101c 70%)" },
      { id: "midnight_blue", name: "ليلي أزرق", css: "radial-gradient(circle at top, #132c54, #0b101b 70%)" },
      { id: "crimson_night", name: "كرزي داكن", css: "radial-gradient(circle at top, #4a152b, #140c12 70%)" },
      { id: "emerald_space", name: "زمردي عميق", css: "radial-gradient(circle at top, #123b34, #0b1412 70%)" }
    ];

    const defaultState = {
      user: {
        name: "عضو_أمينو",
        bio: "أشارك المدونات والأفكار في المجتمع",
        rep: 15,
        titles: [
          { text: "عضو مؤسس", style: "leader" },
          { text: "كاتب مميز", style: "writer" }
        ]
      },
      appearance: {
        presetId: "dark_violet",
        customAppBg: "",
        customProfileBg: ""
      },
      blogs: [
        {
          id: "b1",
          author: "قائد_المجتمع",
          authorTitles: [{ text: "قائد أعلى", style: "leader" }, { text: "VIP", style: "vip" }],
          category: "مدونة عامة",
          title: "أهلاً بك في نظام المدونات والألقاب",
          body: "هنا يمكنك نشر المدونات، تثبيتها في المميز، إضافة ألقاب ملونة، وتغيير خلفيات التطبيق والملف الشخصي بكل سهولة.",
          cover: "",
          featured: true,
          likes: 3,
          liked: false,
          saved: false,
          comments: ["مدونة رائعة جداً، بداية موفقة!"]
        }
      ],
      messages: [
        {
          sender: "قائد_المجتمع",
          titles: [{ text: "قائد أعلى", style: "leader" }],
          text: "مرحباً بالجميع في الدردشة العامة!"
        }
      ]
    };

    let state = loadState();

    function loadState() {
      try {
        const raw = localStorage.getItem(STORAGE_KEY);
        if (!raw) return structuredClone(defaultState);
        const parsed = JSON.parse(raw);
        return {
          ...structuredClone(defaultState),
          ...parsed,
          user: { ...defaultState.user, ...(parsed.user || {}) },
          appearance: { ...defaultState.appearance, ...(parsed.appearance || {}) }
        };
      } catch {
        return structuredClone(defaultState);
      }
    }

    function saveState() {
      localStorage.setItem(STORAGE_KEY, JSON.stringify(state));
    }

    function showToast(msg) {
      const el = document.getElementById("toast");
      el.textContent = msg;
      el.style.display = "block";
      clearTimeout(window.__toastTimer);
      window.__toastTimer = setTimeout(() => { el.style.display = "none"; }, 2200);
    }

    function addRep(points) {
      state.user.rep = Math.max(0, state.user.rep + points);
      saveState();
      renderProfileAndStats();
    }

    function openTab(tabName) {
      document.querySelectorAll(".section").forEach(s => s.classList.remove("active"));
      document.querySelectorAll(".nav-btn").forEach(b => b.classList.remove("active"));

      const targetSec = document.getElementById(tabName);
      if (targetSec) targetSec.classList.add("active");

      const targetTab = document.getElementById("tab-" + tabName);
      if (targetTab) targetTab.classList.add("active");

      window.scrollTo({ top: 0, behavior: "smooth" });
    }

    function quickNewBlog() {
      openTab("blogs");
      document.getElementById("blogTitle").focus();
      showToast("اكتب عنوان ومحتوى مدونتك");
    }

    function renderTitlesHtml(titlesArr) {
      if (!titlesArr || !titlesArr.length) return "";
      return titlesArr
        .map(t => `<span class="title-tag ${escapeAttr(t.style || "writer")}">${escapeHtml(t.text)}</span>`)
        .join("");
    }

    function applyAppearance() {
      const preset = PRESET_BGS.find(p => p.id === state.appearance.presetId) || PRESET_BGS[0];
      if (state.appearance.customAppBg) {
        document.body.style.backgroundImage = `url("${escapeAttr(state.appearance.customAppBg)}")`;
        document.body.style.backgroundColor = "#12101c";
      } else {
        document.body.style.backgroundImage = "none";
        document.body.style.background = preset.css;
      }

      const banner = document.getElementById("profileBanner");
      if (state.appearance.customProfileBg) {
        banner.style.backgroundImage = `url("${escapeAttr(state.appearance.customProfileBg)}")`;
      } else {
        banner.style.backgroundImage = "linear-gradient(135deg, #5e35b1, #d81b60)";
      }

      const grid = document.getElementById("bgSwatches");
      grid.innerHTML = PRESET_BGS.map(bg => {
        const active = !state.appearance.customAppBg && state.appearance.presetId === bg.id ? "selected" : "";
        return `<div class="bg-swatch ${active}" style="background:${bg.css}" onclick="selectPresetBg('${bg.id}')">${bg.name}</div>`;
      }).join("");

      document.getElementById("customAppBgUrl").value = state.appearance.customAppBg || "";
      document.getElementById("customProfileBgUrl").value = state.appearance.customProfileBg || "";
    }

    function selectPresetBg(id) {
      state.appearance.presetId = id;
      state.appearance.customAppBg = "";
      saveState();
      applyAppearance();
      showToast("تم تغيير خلفية التطبيق");
    }

    function applyCustomAppBg() {
      const url = document.getElementById("customAppBgUrl").value.trim();
      state.appearance.customAppBg = url;
      saveState();
      applyAppearance();
      showToast(url ? "تم تطبيق خلفية الصورة" : "تمت إزالة الخلفية المخصصة");
    }

    function applyCustomProfileBg() {
      const url = document.getElementById("customProfileBgUrl").value.trim();
      state.appearance.customProfileBg = url;
      saveState();
      applyAppearance();
      showToast("تم تحديث خلفية الملف الشخصي");
    }

    function publishBlog() {
      const title = document.getElementById("blogTitle").value.trim();
      const body = document.getElementById("blogBody").value.trim();
      const category = document.getElementById("blogCategory").value;
      const featured = document.getElementById("blogFeaturedOption").value === "1";
      const cover = document.getElementById("blogCover").value.trim();

      if (!title || !body) {
        showToast("يرجى إدخال العنوان والمحتوى");
        return;
      }

      state.blogs.unshift({
        id: "b_" + Date.now(),
        author: state.user.name,
        authorTitles: structuredClone(state.user.titles),
        category,
        title,
        body,
        cover,
        featured,
        likes: 0,
        liked: false,
        saved: false,
        comments: []
      });

      document.getElementById("blogTitle").value = "";
      document.getElementById("blogBody").value = "";
      document.getElementById("blogCover").value = "";

      addRep(5);
      saveState();
      renderBlogs();
      showToast("تم نشر المدونة (+5 سمعة)");
    }

    function toggleLike(id) {
      const b = state.blogs.find(x => x.id === id);
      if (!b) return;
      b.liked = !b.liked;
      b.likes += b.liked ? 1 : -1;
      saveState();
      renderBlogs();
    }

    function toggleSave(id) {
      const b = state.blogs.find(x => x.id === id);
      if (!b) return;
      b.saved = !b.saved;
      saveState();
      renderBlogs();
      showToast(b.saved ? "تم حفظ المدونة" : "تمت إزالة الحفظ");
    }

    function toggleFeature(id) {
      const b = state.blogs.find(x => x.id === id);
      if (!b) return;
      b.featured = !b.featured;
      saveState();
      renderBlogs();
      showToast(b.featured ? "تم تثبيت المدونة في المميز" : "تم إلغاء التثبيت");
    }

    function deleteBlog(id) {
      state.blogs = state.blogs.filter(x => x.id !== id);
      saveState();
      renderBlogs();
      showToast("تم حذف المدونة");
    }

    function addComment(id) {
      const input = document.getElementById("cmt-" + id);
      if (!input) return;
      const text = input.value.trim();
      if (!text) return;

      const b = state.blogs.find(x => x.id === id);
      if (!b) return;
      b.comments.push(`${state.user.name}: ${text}`);
      input.value = "";
      addRep(2);
      saveState();
      renderBlogs();
      showToast("تمت إضافة تعليق (+2 سمعة)");
    }

    function copyBlogLink(title) {
      if (navigator.clipboard) {
        navigator.clipboard.writeText(`مدونة: ${title}`).catch(() => {});
      }
      showToast("تم نسخ رابط المدونة");
    }

    function renderBlogCardHtml(b) {
      const coverHtml = b.cover
        ? `<img src="${escapeAttr(b.cover)}" alt="صورة المدونة" style="width:100%;max-height:240px;object-fit:cover;border-radius:10px;margin-top:8px;" />`
        : "";

      const commentsHtml = b.comments.length
        ? `<div class="comments-box">${b.comments.map(c => `<div class="comment-item">${escapeHtml(c)}</div>`).join("")}</div>`
        : "";

      return `
        <article class="card">
          <div class="card-header">
            <div class="author-row">
              <div class="avatar">${escapeHtml((b.author || "م").charAt(0))}</div>
              <div>
                <div class="author-name">${escapeHtml(b.author)} <span style="font-size:11px;color:var(--text-muted);">• ${escapeHtml(b.category)}</span></div>
                <div class="titles-wrap">${renderTitlesHtml(b.authorTitles)}</div>
              </div>
            </div>
            <button class="action-btn btn-danger" onclick="deleteBlog('${b.id}')">حذف</button>
          </div>

          <h3 style="margin:6px 0;">${escapeHtml(b.title)}</h3>
          <p style="margin:0;line-height:1.65;color:#ece9f7;white-space:pre-line;">${escapeHtml(b.body)}</p>
          ${coverHtml}

          <div class="action-bar">
            <button class="action-btn ${b.liked ? "liked" : ""}" onclick="toggleLike('${b.id}')">❤️ إعجاب (${b.likes})</button>
            <button class="action-btn" onclick="toggleFeature('${b.id}')">${b.featured ? "⭐ مميز" : "☆ تمييز"}</button>
            <button class="action-btn" onclick="toggleSave('${b.id}')">${b.saved ? "🔖 محفوظ" : "📑 حفظ"}</button>
            <button class="action-btn" onclick="copyBlogLink('${escapeAttr(b.title)}')">🔗 مشاركة</button>
          </div>

          ${commentsHtml}

          <div class="row-flex" style="margin-top:10px;">
            <input type="text" id="cmt-${b.id}" placeholder="اكتب تعليقاً..." />
            <button class="btn" onclick="addComment('${b.id}')">تعليق</button>
          </div>
        </article>
      `;
    }

    function renderBlogs() {
      const filter = document.getElementById("filterCategory").value;
      const featuredBlogs = state.blogs.filter(b => b.featured);
      const featContainer = document.getElementById("featuredContainer");

      if (featuredBlogs.length) {
        featContainer.innerHTML = `
          <div class="featured-box">
            <span class="featured-label">⭐ المدونات المميزة (Featured)</span>
            ${featuredBlogs.map(b => renderBlogCardHtml(b)).join("")}
          </div>
        `;
      } else {
        featContainer.innerHTML = "";
      }

      const list = state.blogs.filter(b => filter === "ALL" || b.category === filter);
      document.getElementById("blogsList").innerHTML = list.length
        ? list.map(b => renderBlogCardHtml(b)).join("")
        : `<div class="card"><p style="color:var(--text-muted);margin:0;">لا توجد مدونات في هذا القسم بعد.</p></div>`;
    }

    function sendChat() {
      const input = document.getElementById("chatText");
      const text = input.value.trim();
      if (!text) return;

      state.messages.push({
        sender: state.user.name,
        titles: structuredClone(state.user.titles),
        text
      });
      input.value = "";
      addRep(1);
      saveState();
      renderChat();
    }

    function renderChat() {
      const box = document.getElementById("chatStream");
      box.innerHTML = state.messages.map(m => `
        <div class="msg-bubble">
          <div class="msg-top">
            <strong>${escapeHtml(m.sender)}</strong>
            ${renderTitlesHtml(m.titles)}
          </div>
          <div style="font-size:14px;">${escapeHtml(m.text)}</div>
        </div>
      `).join("");
      box.scrollTop = box.scrollHeight;
    }

    function addTitle() {
      const input = document.getElementById("customTitleInput");
      const style = document.getElementById("titleStyleSelect").value;
      const text = input.value.trim();
      if (!text) {
        showToast("اكتب اسم اللقب أولاً");
        return;
      }

      state.user.titles.push({ text, style });
      input.value = "";
      addRep(3);
      saveState();
      renderTitlesTab();
      renderProfileAndStats();
      showToast("تمت إضافة اللقب (+3 سمعة)");
    }

    function removeTitle(index) {
      state.user.titles.splice(index, 1);
      saveState();
      renderTitlesTab();
      renderProfileAndStats();
      showToast("تمت إزالة اللقب");
    }

    function renderTitlesTab() {
      const container = document.getElementById("myTitlesList");
      if (!state.user.titles.length) {
        container.innerHTML = `<span style="color:var(--text-muted);font-size:13px;">لا توجد ألقاب حالياً.</span>`;
        return;
      }
      container.innerHTML = state.user.titles
        .map((t, idx) => `
          <span class="title-tag ${escapeAttr(t.style)}" style="padding:5px 10px;font-size:12px;">
            ${escapeHtml(t.text)}
            <span style="cursor:pointer;margin-right:6px;" onclick="removeTitle(${idx})">✕</span>
          </span>
        `).join("");
    }

    function saveProfile() {
      const name = document.getElementById("editName").value.trim();
      const bio = document.getElementById("editBio").value.trim();
      if (name) state.user.name = name;
      state.user.bio = bio;
      saveState();
      renderProfileAndStats();
      showToast("تم حفظ بيانات الملف الشخصي");
    }

    function renderProfileAndStats() {
      const level = Math.floor(state.user.rep / 20) + 1;
      document.getElementById("levelBadge").textContent = `Lv.${level}`;
      document.getElementById("profileNameDisplay").textContent = state.user.name;
      document.getElementById("profileBioDisplay").textContent = state.user.bio || "";
      document.getElementById("profileAvatar").textContent = state.user.name.charAt(0) || "م";
      document.getElementById("profileTitlesDisplay").innerHTML = renderTitlesHtml(state.user.titles);

      document.getElementById("statRep").textContent = state.user.rep;
      document.getElementById("statBlogs").textContent = state.blogs.length;
      document.getElementById("statTitles").textContent = state.user.titles.length;

      document.getElementById("editName").value = state.user.name;
      document.getElementById("editBio").value = state.user.bio || "";
    }

    function escapeHtml(str) {
      return String(str ?? "")
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;");
    }

    function escapeAttr(str) {
      return String(str ?? "").replace(/"/g, "&quot;").replace(/'/g, "&#39;");
    }

    applyAppearance();
    renderBlogs();
    renderChat();
    renderTitlesTab();
    renderProfileAndStats();
  </script>
</body>
</html>
