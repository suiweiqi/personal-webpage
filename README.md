# 个人主页

> 🌐 **[suiweiqi.github.io/personal-webpage](https://suiweiqi.github.io/personal-webpage/)**

基于 Spring Boot + Thymeleaf 的个人主页，同时支持通过 GitHub Pages 部署静态版本。

---

## 🛠 技术栈

| 技术 | 说明 |
|------|------|
| Java 21 + Spring Boot 3.3.5 | 后端框架 |
| Thymeleaf | 模板引擎 |
| Maven | 项目构建 |
| HTML5 + CSS3 | 页面结构 & 样式 |
| GitHub Pages | 静态托管 |

---

## 🚀 本地运行

```bash
# 1. 确保已安装 JDK 21 和 Maven 3.9+

# 2. 进入项目目录
cd swq

# 3. 启动
mvn spring-boot:run

# 4. 浏览器访问
# http://localhost:8080
```

> Windows 用户也可双击 `start.bat` 一键启动（含公网隧道）

---

## 📂 项目结构

```
swq/
├── docs/                          # GitHub Pages 静态文件
│   ├── index.html                 # 静态主页
│   ├── css/style.css              # 样式
│   └── images/avatar.jpg          # 头像
├── src/main/
│   ├── java/com/personal/webpage/
│   │   ├── PersonalWebpageApplication.java  # 启动类
│   │   └── controller/HomeController.java   # 控制器
│   └── resources/
│       ├── application.properties           # 配置
│       ├── static/css/style.css             # 样式
│       └── templates/index.html             # Thymeleaf 模板
├── pom.xml                        # Maven 配置
├── start.bat                      # 一键启动脚本
└── README.md
```

---

## 🌍 部署到 GitHub Pages

修改 `docs/` 目录下的文件，提交推送即可自动部署：

```bash
git add -A
git commit -m "更新内容"
git push
```

等待 1-2 分钟，刷新 [suiweiqi.github.io/personal-webpage](https://suiweiqi.github.io/personal-webpage/) 即可看到更新。

---

## 📝 License

MIT
