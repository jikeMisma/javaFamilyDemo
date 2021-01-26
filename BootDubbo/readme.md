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

## 2.容错与屏蔽
**容错**
顾名思义就是当服务提供者出现异常时，消费者是否能够正常处理。
![d936f7315f9b8dfddf2d39d74d35e01f.png](en-resource://database/7401:0)

配置容错后，在进行调用，没有启动的服务提供者的对象返回为空，但是服务不报错。


服务提供者在线，服务容错未配置前：
![a0e57b6e8c3c78903f2172e586139c62.png](en-resource://database/7405:0)


服务提供者不在线，服务容错配置后：
![acfff2f0a3b89c2dd95c319674d9dbda.png](en-resource://database/7403:0)

**屏蔽**
当某个服务启动屏蔽时，此时消费者调用该服务均会返回空对象，首先我们需要确保消费者与提供者均已经启动，然后在消费者中对提供者进行屏蔽。
![28cf687a0c435bf6dd892c5a2daa7160.png](en-resource://database/7407:0)


## 3.负载均衡

在集群负载均衡时，Dubbo 提供了多种均衡策略，缺省为 random 随机调用。

常见的负载均衡策略：

1. 随机 Random LoadBalance
2. 轮询 RoundRobin LoadBalance
3. 最少活跃调用数 LeastActive LoadBalance



