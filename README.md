# 本项目为 模拟唯品会网站

基于微服务架构的分布式购物电商商城
预计完成
// 后台管理系统：管理商品、订单、类目、商品规格属性、用户、权限、系统统计、系统日志以及前台内容等功能
 前台系统：用户可以在前台系统中进行注册、登录、浏览商品、首页、下单等操作
 会员系统：用户可以在该系统中查询已下的订单、管理订单、我的优惠券等信息
 订单系统：提供下单、查询订单、修改订单状态、定时处理订单
 搜索系统：提供商品的搜索功能

前后端分离：

## 前端项目技术：

...

## 后端所用技术
SpringBoot
MyBatis
Dubbo
ZooKeeper
MySQL
// Mycat：数据库分库分表中间件
Redis：缓存
// Elasticsearch：基于Lucene分布式搜索引擎
// ActiveMQ：消息队列
Druid：阿里高性能数据库连接池
// Shiro：安全框架
Swagger2：Api文档生成
// Docker
Nginx
Tomcat
Maven


第三方SDK
七牛云文件存储服务
极验Test-button人机验证码

第三方插件
hotjar：一体化分析和反馈
#搜狐畅言评论插件

第三方平台
eolinker 用作接口文档管理平台
石墨文档：敏捷开发排期

其它开发工具
//Jenkins：持续集成
//JRebel：开发热部署

谷歌JAVA开发规约插件-IDEA之google style配置
文件说明
dependency 文件夹提供部分依赖与sql文件
vip.sql：数据库建库文件


generatorConfig.xml 文件夹为 Mybatis Generator 逆向生成工具，且已配置好maven插件


后端项目分层

用户服务
订单服务
产品服务

```
├── framework-sso           - 用户服务
│   ├── sso-api             - 用户服务API
│   ├── sso-service         - 用户服务实现类
│   ├── sso-manager         - 用户服务控制层
├── framework-common        - 公共项目包
├── framework-order         - 订单服务
│   ├── order-api           - 订单服务API
│   ├── order-service       - 订单服务实现类
├── framework-product       - 产品服务
│   ├── product-api         - 产品服务API
│   ├── product-service     - 产品服务实现类
```

TODO

1、日志改为
sfl4j + logback 模式

2、短信服务
供应商

3、配置Swagger2 生成默认接口文档

