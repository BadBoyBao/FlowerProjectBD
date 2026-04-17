# 鲜花销售系统

## 项目简介

**赛博鲜花销售系统** - 一个基于 Spring Boot + Vue 的多商户鲜花电商平台，支持多店铺入驻、商品管理、订单处理等核心功能。

## 技术架构

### 后端技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 3.5.7 | 应用框架 |
| MyBatis | 3.0+ | ORM框架 |
| Lombok | 1.18+ | 简化代码 |
| Hutool | 5.8+ | 工具类库 |
| Knife4j | 4.4+ | API文档 |
| MinIO | 8.5+ | 对象存储 |
| JWT | 0.12+ | 认证授权 |
| Redis | 7.0+ | 缓存 |

### 前端技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Vue | 3.5.22 | 前端框架 |
| Element Plus | 2.11.9 | UI组件库 |
| Ant Design Vue | 4.2.6 | UI组件库 |
| Pinia | 3.0.3 | 状态管理 |
| Vue Router | 4.6.3 | 路由管理 |
| Vite | 7.1.11 | 构建工具 |

### 数据库

- MySQL 8.0.41

## 项目结构

```
flower-project/
├── flower-parent/          # 父工程依赖管理
├── flower-common/          # 通用模块
│   ├── Common/             # 通用类(Result, PageResult等)
│   ├── Config/             # 配置类(DocConfig, RedisConfiguration等)
│   ├── Utils/              # 工具类(JwtUtils, OrderNoUtils)
│   ├── aop/                # AOP切面(LoggingAspect)
│   ├── context/            # 上下文(BaseContext)
│   ├── exception/          # 全局异常处理
│   └── interceptor/        # JWT认证拦截器
├── flower-pojo/            # 实体模块
│   ├── entity/             # 数据库实体
│   ├── DTO/                # 数据传输对象
│   └── VO/                 # 视图对象
├── flower-service-management/  # 业务逻辑模块
│   ├── Controller/         # 控制层
│   ├── Service/            # 服务层接口
│   ├── Service/Impl/       # 服务层实现
│   └── mapper/             # 数据访问层
└── web/                    # 启动模块
    ├── FlowerApplication.java
    └── application.yml
```

## 功能模块

### 用户端功能

- [x] 用户注册/登录
- [x] 商品浏览与搜索
- [x] 购物车管理
- [x] 商品收藏
- [x] 订单创建与支付
- [x] 订单状态追踪
- [x] 商品评价
- [x] 收货地址管理

### 店铺管理端功能

- [x] 鲜花商品管理（增删改查）
- [x] 商品分类管理
- [x] 库存管理
- [x] 订单管理（接单/拒单/发货）
- [x] 店铺信息管理
- [x] 工作台数据统计

### 超级管理端功能

- [x] 店铺管理（创建/封禁）
- [x] 店主管理
- [x] 用户管理
- [x] 系统日志查看

## 核心特性

- **JWT认证**: 无状态认证，支持Token过期刷新
- **RBAC权限**: 三级权限（超级管理员、店铺管理员、普通用户）
- **全局异常处理**: 统一的错误响应格式
- **文件存储**: 集成MinIO对象存储
- **RESTful API**: 标准化接口设计

## 快速开始

### 环境要求

- JDK 21+
- Maven 3.6+
- MySQL 8.0+
- Redis 7.0+

### 数据库配置

1. 创建数据库 `bak`
2. 导入数据库脚本 `_localhost-2026_01_03_05_32_03-dump.sql`

### 启动服务

```bash
# 进入项目目录
cd flower-project

# 编译项目
mvn clean package -DskipTests

# 启动服务
java -jar web/target/web-1.0-SNAPSHOT.jar
```

### 前端启动

```bash
# 进入前端目录
cd flower-project-Vue

# 安装依赖
npm install

# 启动开发服务器
npm run dev
```

## 访问地址

- 后端API: http://localhost:8080
- API文档: http://localhost:8080/doc.html
- 前端页面: http://localhost:5173

## 默认测试账号

| 用户名 | 密码 | 角色 | 说明 |
|--------|------|------|------|
| admin | 123456 | SUPER_ADMIN | 超级管理员 |
| owner1 | 123456 | SHOP_OWNER | 店铺1店主 |
| owner2 | 123456 | SHOP_OWNER | 店铺2店主 |
| thexpxp123 | 123456 | USER | 普通用户 |

## 项目状态

- ✅ 用户认证模块
- ✅ 商品管理模块
- ✅ 订单管理模块
- ✅ 购物车模块
- ✅ 店铺管理模块
- ✅ 评论系统模块

## License

MIT License