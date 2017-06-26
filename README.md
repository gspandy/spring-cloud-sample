# spring-cloud-sample
## 简介
本示例构建了一个完整的用户管理应用程序，包括以下功能：
* 用户登录
* 用户列表
* 添加新用户
* 更改已有用户
* 删除用户
* 设置用户权限
* 用户操作日志

这虽然只是一个非常小型的应用，但我们为了演示spring cloud的各种特性依然**“故意”**构建了一个庞大的复杂架构，包括：
* 使用consul作为分布式协调基础服务并运用spring-cloud-consul进行服务注册与发现、分布式配置
* 使用mysql存储用户数据并运用mybatis映射数据库
* 使用redis存储用户登录凭据并运用redisTemplate进行数据存取
* 使用mongodb存储用户操作日志并运用mongoTemplate进行数据存取
* 使用rabbitmq存储用户操作消息并用spring-cloud-stream进行消息处理
* 使用feignclient作为服务客户端实现服务调用、负载均衡、服务熔断
* 配置hystrix-dashboard监控服务的熔断状态
* 运用sleuth跟踪服务调用链路
* 使用vuejs来渲染UI

如您所见，为了在您的笔记本电脑上运行这款**“简单”**的应用，您需要安装大量的基础软件，并且还需要启动多个spring-boot应用，因此如果您的电脑不是一台**“超级”**电脑，建议尽量使用已有的基础架构（例如局域网内的其他mysql、redis、mongodb、rabbitmq）。
