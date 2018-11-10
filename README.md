# 本项目为 模拟唯品会网站

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
│   ├── sso-api             - 用户服务接口API
│   ├── sso-service         - 用户服务实现类
├── framework-common        - 公共项目包
├── framework-order         - 订单服务
│   ├── order-api           - 订单服务API
│   ├── order-service       - 订单服务实现类
├── framework-product       - 产品服务
│   ├── product-api         - 产品服务API
│   ├── product-service     - 产品服务实现类
```
