# 坤的个人牧场

日式像素风个人主页 + 小牧场网站。

## 预览

- ![预览图 1]<img width="678" height="665" alt="{7CF10CBF-9090-4E1D-939C-5F3EE0BFDB1C}" src="https://github.com/user-attachments/assets/e210ae82-2ce5-495c-96e3-3a05e3e6da22" />

- ![预览图 2]<img width="915" height="510" alt="{5DCD3882-34A2-477C-92A3-AC165F6292FC}" src="https://github.com/user-attachments/assets/a386a219-47c1-48a4-a0a2-76f0125b404d" />


---

## 项目简介

一个单页个人网站，包含关于我、擅长领域、成果、小游戏、页面音乐、小牧场、页面宠物 7 大模块。前端采用原生 HTML/CSS/JS，后端使用 Java Spring Boot。

## 页面亮点

1. **像素风 UI**：奶油色 + 绿色描边，统一视觉风格
2. **多模块集成**：音乐、宠物、牧场、小游戏在同一页面互不干扰
3. **前后端联动**：牧场状态、宠物选择、游戏分数通过 REST API 持久化
4. **容错降级**：后端不可用时自动降级到本地存储，页面照常运行
5. **单文件前端**：`index.html` 包含全部逻辑，无需构建工具
6. **一键打包**：前端资源打入 JAR，单文件部署

## 前后端分工

### 前端 `index.html` + `assets/`
- 页面渲染与交互（模块切换、弹窗、动画）
- 实时游戏循环（贪吃蛇、跳障碍）
- 牧场/宠物的实时动画（走动、吃东西、变胖）
- 音效播放（Web Audio API）

### 后端 `backend/` (Spring Boot)
- 牧场状态管理（猪的增删、小麦消耗）
- 宠物选择与对话气泡文案
- 游戏最高分存储
- 提供 REST API 供前端调用

## 没有后端会怎样？

前端有容错降级机制，**页面能正常打开**，但：
- 牧场状态、游戏分数**刷新后重置**
- 宠物选择**不记忆**，默认显示村民
- 对话气泡使用本地文案而非后端文案

**想体验完整功能请启动后端**。

## 运行方式

### 完整运行（推荐）

需要 Java 17+：

```bash
java -jar ranch-backend-1.0.0.jar
```

访问 `http://localhost:8081/`

### 仅前端预览

```bash
python -m http.server 8080
```

访问 `http://localhost:8080/index.html`（后端功能降级）

### 重新打包

```bash
cd backend
mvn clean package
```

## 目录结构

```
Myweb/
├── index.html              # 前端单文件
├── assets/                 # 图片、音效
├── backend/                # Spring Boot 后端
├── ranch-backend-1.0.0.jar # 可执行 JAR
└── .screenshots/           # 预览截图
```
