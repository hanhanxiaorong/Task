Tracer：基于Spring Boot、OAuth2.0开发基于Vue前后分离的开发平台，支持帐号、SSO登录方式
=======
##项目简介
      Tracer，项目名称取自暴雪旗下游戏《守望先锋》中的角色猎空，另外一层意思为：描图者，我们希望它能够成为我们在开发项目的过程中成为我们手中的画笔，基于Tracer用户可以更快、更可靠、易读、更完善的开发独立项目
    其次，我们也想通过Tracer来检验我们开发小组的技术。
     主要定位于后台管理系统学习交流，已内置后台管理系统的基础功能和高效的代码生成工具， 包括：系统权限组件、数据权限组件、数据字典组件、核心工具组件、视图操作组件、工作流组件、代码生成等。 前端界面风格采用了VUE作为动静分离的基础。 采用分层设计、双重验证、提交数据安全编码、密码加密、访问验证、数据权限验证。使用Maven做项目管理，提高项目的易开发性、扩展性。
    在Tracer中包含：文件处理，音频处理，即时通讯，流程处理，硬件处理，API管控。以及后续逐渐完善的spring cloud 微服务组件

##项目技术
      Tracer，使用Spring boot、mybatis、mybatis plus、Spring security、spring security oauth2、Redis、Jwttoken、vue、avue等，
    后续随着项目的不断发展，会扩展以及应用更多。
 ##项目功能
 - 注册登录：账号密码模式、短信验证码模式、社交账号模式、口令模式
 - 单点登录：基于Srping security oAuth 提供单点登录接口，对外开放，方便其他系统登录
 - 用户管理：系统中主要操作者管理，可以增删改查。
 - 机构管理：配置系统组织机构，树结构展现，可随意调整上下级。
 - 菜单管理：配置系统菜单，操作权限，按钮权限标识等。
 - 角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
 - 字典管理：对系统中经常使用的一些较为固定的数据进行维护，如：男女、是否等。
 - 操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
 - 数据权限: 使用mybatis Plus对原查询做增强，业务代码不用控制，即可实现。
 - 消息中心：短信、邮件
 - 代码生成：后端代码的生成，前端代码目前未实现
 - 缓存管理：基于Redis 
 ### 模块
 ``` lua
tracer
 ├── tracer-starter-common -- 系统公共模块 
 ├── tracer-starter-auth -- 授权服务提供
 ├── tracer-starter-cache -- 系统缓存模块
 ├── tracer-starter-admin -- 业务后台系统
 ```
 ###安全考虑
 - 开发语言：系统采用Java 语言开发，具有卓越的通用性、高效性、平台移植性和安全性。
 - 分层设计：（数据库层，数据访问层，业务逻辑层，展示层）层次清楚，低耦合，各层必须通过接口才能接入并进行参数校验（如：在展示层不可直接操作数据库），保证数据操作的安全。
 - 双重验证：用户表单提交双验证：包括服务器端验证及客户端验证，防止用户通过浏览器恶意修改（如不可写文本域、隐藏变量篡改、上传非法文件等），跳过客户端验证操作数据库。
 - 安全编码：用户表单提交所有数据，在服务器端都进行安全编码，防止用户提交非法脚本及SQL注入获取敏感数据等，确保数据安全。
 - 密码加密：登录用户密码进行SHA1散列加密，此加密方法是不可逆的。保证密文泄露后的安全问题。
 - 强制访问：系统对所有管理端链接都进行用户身份权限验证，防止用户直接填写url进行访问。
