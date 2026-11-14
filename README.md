# 坤的个人牧场
一个日式像素风的个人主页 + 小牧场网站。
## 预览

- ![预览图 1]<img width="1086" height="549" alt="{4BF03597-CDD3-454B-A162-A86A704AD09D}" src="https://github.com/user-attachments/assets/f1b10cf5-acb5-40fc-a012-c44c43a6883d" />

- ![预览图 2]<img width="578" height="517" alt="{E1C3F54A-B221-4799-94BF-69ECF5082037}" src="https://github.com/user-attachments/assets/fdcc88f0-3319-4cf5-9ac8-ec7d16a54f5c" />


---

## 项目简介

这是一个**单页个人网站**，以「坤的个人牧场」为主题，整体采用日式像素牧场风格。项目包含：

- **关于我**：个人简介、技能标签、亮点展示
- **擅长领域**：后端 / 前端 / AIGC / 测试等技能分组
- **成果**：竞赛奖项、奖学金、毕业设计等
- **小游戏**：贪吃蛇、跳障碍（小猪跑酷）
- **页面音乐**：支持清晨 / 黄昏 / 星空三首 BGM
- **小牧场**：养猪、喂食、变胖、死亡、添加 / 减少猪只
- **页面宠物**：村民 / 苦力怕 / 猪等宠物，支持点击跳跃、随机对话、爆炸

前端采用原生 HTML / CSS / JavaScript 单文件实现，后端使用 Java Spring Boot 提供 REST API。

## 项目亮点

1. **像素风 UI**：统一的奶油色 + 绿色描边 + 圆角标签，搭配像素图标，整体风格清新可爱
2. **多模块交互**：页面音乐、桌面宠物、牧场模拟、小游戏集成在一个页面，模块之间互不干扰
3. **前后端联动**：牧场状态、宠物选择、游戏分数通过 Spring Boot API 同步，支持持久化
4. **容错降级**：后端不可用时，前端自动降级到本地存储 / 本地文案，页面照常可用
5. **单文件前端**：`index.html` 包含全部页面与逻辑，无需构建工具，方便部署与二次开发
6. **一键打包**：前端资源已打入 Spring Boot JAR，只需运行一个文件即可启动完整网站

## 技术栈

- **前端**：HTML5、CSS3、原生 JavaScript、Canvas
- **后端**：Java 17+、Spring Boot 3.x
- **资源**：WebP 图片、MP3 音效、Web Audio API

## 运行方式

### 仅前端预览

直接打开 `index.html`，或启动任意静态服务器：

```bash
# 例如使用 Python
python -m http.server 8080
```

访问 `http://localhost:8080/index.html`

### 前后端完整运行

```bash
java -jar ranch-backend-1.0.0.jar
```

访问 `http://localhost:8081/`

### 重新打包

```bash
cd backend
mvn clean package
```

生成的 JAR 位于 `backend/target/ranch-backend-1.0.0.jar`。

## 目录结构

```
Myweb/
├── index.html              # 前端页面（单文件）
├── assets/                 # 图片、音效等资源
├── backend/                # Spring Boot 后端源码
├── ranch-backend-1.0.0.jar # 打包好的可执行 JAR
└── .screenshots/           # 预览截图
```

## 后续可扩展方向

- 接入真实数据库持久化牧场状态
- 添加更多小游戏与宠物类型
- 支持用户登录与多牧场管理
- 适配移动端触控操作

---
