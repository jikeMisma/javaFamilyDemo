# Spring Boot  整合Dubb

## 1.服务模块说明
**一.用户微服务模块**
boot-user-service
功能：根据用户id查询用户信息
http://localhost:8989/user-service/user/0002


**二.会议微服务模块**
boot-meeting-service
功能：根据会议编号（pcode）查询会议信息
http://localhost:8990/meeting-service/meeting/1111

**三.微服务最佳化实践**
boot-interface-api
分报：公共的模型、异常、接口都放在此处

**六.创建支付的微服务**
boot-pay-sevice
功能：根据用户id查询账户余额信息
http://localhost:8991/pay-service/pay/account/0002


**四.服务于服务之间的调用**
根据会议编号id查询会议信息（直接得到用户的所有信息）

服务提供者：用户的微服务
服务的消费者：会议服务
4.1 将服务的提供者注册到注册中心去
4.2 服务的消费者到注册中心中区消费服务

