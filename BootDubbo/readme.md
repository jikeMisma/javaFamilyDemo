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

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210126160031308.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)

配置容错后，在进行调用，没有启动的服务提供者的对象返回为空，但是服务不报错。


服务提供者在线，服务容错未配置前：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210126160216484.png#pic_center)



服务提供者不在线，服务容错配置后：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210126160237376.png#pic_center)

**屏蔽**
当某个服务启动屏蔽时，此时消费者调用该服务均会返回空对象，首先我们需要确保消费者与提供者均已经启动，然后在消费者中对提供者进行屏蔽。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210126160255407.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)



## 3.负载均衡

在集群负载均衡时，Dubbo 提供了多种均衡策略，缺省为 random 随机调用。

常见的负载均衡策略：

1. 随机 Random LoadBalance
2. 轮询 RoundRobin LoadBalance
3. 最少活跃调用数 LeastActive LoadBalance




