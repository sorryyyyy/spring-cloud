# spring-cloud
springcloud基础学习工程
### **springCloud从面试题开始**

以下问题将逐渐在课程中解答：

#### 什么是微服务？

#### 微服务之间是如何独立通讯的？

#### springCloud和Dubbo有哪些区别？

#### springBoot和springCloud，请你谈谈对他们的理解？

#### 什么是服务熔断？什么是服务降级

#### 微服务的优缺点分别是什么？说下你在项目开发中碰到的坑？

#### 你所知道的微服务技术栈有哪些？请列举一二？

#### Eureka和zooKeeper都可以提供服务注册与发现功能，请说说两者的异同点？

### **微服务概述**

**微服务是什么？**

*In short, the microservice architectural style is an approach to developing a single application as a suite of small services, each running in its own process and communicating with lightweight mechanisms, often an HTTP resource API. These services are built around business capabilities and independently deployable by fully automated deployment machinery. There is a bare minimum of centralized management of these services, which may be written in different programming languages and use different data storage technologies.*

通常而言，微服务架构是一种架构模式或者说是一种架构风格，它**提倡将单一应用程序划分成一组小的服务**，每个服务运行在其独立的**进程**中，服务之间互相协调、互相配合，为用户提供最终价值。服务之间采用轻量级的通信机制互相沟通（通常是是基于HTTP的RESTful API）。每个服务都围绕着具体业务进行构建，并且能够被独立地部署到生产环境、类生产环境等。另外，应尽量避免统一的、集中式的服务管理机制，对具体的一个服务而言，应根据业务上下文，选择合适的语言、工具对其进行构建，可以有一个非常轻量级的集中式管理来协调这些服 务，可以使用不同的语言来编写服务，也可以使用不同的数据存储。

从技术角度看微服务化的核心就是将传统的一站式应用，根据业务拆分成一个一个的服务，彻底地去耦合，每一个微服务提供单个业务功能的服务，一个服务做一件事，从技术角度看就是一种小而独立的处理过程，类似进程概念，能够自行单独启动或销毁，拥有自己独立的数据库。

Martin Fowler关于微服务研究的论文《Microservices》

地址链接：https://martinfowler.com/articles/microservices.html#CharacteristicsOfAMicroserviceArchitecture

###微服务技术栈

| 微服务条目          |                           落地技术                           |
| :------------------ | :----------------------------------------------------------: |
| 服务开发            |                Springboot、Spring、SpringMVC                 |
| 服务配置与管理      |                      Arcgaius、Diamond                       |
| 服务注册与发现      |                 Eureka、Consul、Zookeeper等                  |
| 服务调用            |                       Rest、RPC、gRPC                        |
| 服务熔断器          |                       Hystrix、Envoy等                       |
| 负载均衡            |                       Ribbon、Nginx等                        |
| 服务接口调用        |                           Feign等                            |
| 消息队列            |                 Kafka、RabbitMQ、ActiveMQ等                  |
| 服务配置中心管理    |                  SpringCloudConfig、Chef等                   |
| 服务路由（API网关） |                            zuul等                            |
| 服务监控            |            Zabbix、Nagios、Metrics、Sepectator等             |
| 全链路追踪          |                   Zipkin、Brave、Dapper等                    |
| 服务部署            |               Docker、OpenStack、Kubernetes等                |
| 数据流操作开发包    | Spring Cloud Stream(封装与Redis、Rabbit、Kafka等发送接收消息) |
| 事件消息总线        |                       Spring Cloud Bus                       |



### SpringCloud入门概述

SpringCloud是一些技术的综合应用

SpringCloud，基于SpringBoot提供了一套微服务解决方案，包括服务注册与发现，配置中心，全链路监控，服务网关，负载均衡，熔断器等组件，除了基于NetFlix的开源组件做高度抽象封装之外，还有一些选型中立的开源组件。

SpringCloud=分布式微服务架构下的一站式解决方案，是各个微服务架构落地技术的几何体，是微服务全家桶

**SpringCloud和SpringBoot是什么关系？**

*SpringBoot专注于快速方便的开发单个个体微服务。*

*SpringCloud是关注全局的微服务协同整理治理框架，它将SpringBoot开发的一个个单体微服务整合并管理起来，为各个微服务之间提供，配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等集成服务*

*SpringBoot可以离开SpringCloud独立使用开发项目，但是SpringCloud离不开SpringBoot，属于依赖的关系。*

*SpringBoot专注于快速、方便的开发单个微服务个体，SpringCloud关注全局的服务治理框架。*

**SpringCloud与Dubbo的区别？**

*最大区别：SpringCloud抛弃了Dubbo的RPC通信，采用的是基于HTTP的REST方式*

*严格来说，这两种方式各有优劣。虽然一定程度上来说，后者牺牲了服务调用性能，但也避免了提到的原生RPC带来的问题。而且REST相比RPC更为灵活，服务的提供方和调用方的依赖只依靠一纸契约，不存在代码级别的强依赖，这在强调快速演化的微服务环境下，显得更加合适。*

### RestTemplate

RestTemplate提供了多种便捷访问远程Http服务的方法

是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集

使用restTemplate访问restful接口非常的简单,url,requestMap，ResponseBean.class这三个参数分别代表REST请求地址、请求参数、Http响应转换被转换成的对象类型

### Eureka

Eureka是Netflix的一个子模块，也是核心模块之一。Eureka是一个基于REST的服务，以实现云端中间层服务发现和故障转移。服务注册与发现对于微服务架构来说是非常重要的，有了服务发现与注册，只需要使用服务的标识符，就可以访问到服务，而不需要修改服务调用的配置文件了。

Eureka采用了C-S的设计架构。Eureka Server作为服务注册功能的服务器，它就是服务注册中心。

而系统中的其他微服务，使用Eureka的客户端连接到Eureka Server并维持心跳连接.这样系统的维护人员就可以通过Eureka Server来监控系统中各个微服务是否正常运行。SpringCloud的一些其他模块（比如zuul）就可以通过Eureka Server来发现系统中的其他微服务，并执行相关的逻辑。

#### 自我保护机制

默认情况下，如果EurekaServer在一定时间内没有接收到某个微服务实例的心跳，EurekaServer将会注销该实例(默认90秒)。但是当网络分区故障发生时，微服务与EurekaServer之间无法正常通信，以上行为可能变得非常危险——因为微服务本身其实是健康的，此时本不应该注销这个微服务。Eureka通过"自我保护机制"来解决这个为题——当EurekaServer节点在短时间内丢失过多客户端（可能发生了网络分区故障），那么这个节点就会进入自我保护模式。一旦进入该模式，EruekaServer就会保护服务注册表中的信息，不在删除服务注册表中的数据（也就是不会注销任何微服务）。当网络恢复后，该EurekaServer节点会自动退出自我保护模式。

**在自我保护模式中，EurekaServer会保护注册表中的信息，不再注销任何服务实例。当它收到的心跳数重新恢复到阈值以上时，该EurekaServer节点就会自动退出自我保护模式，它的设计哲学就是宁可保留错误的服务注册信息，也不盲目注销任何可能健康的服务实例。一句话讲解：好死不如赖活着**

eureka遵循AP原则

传统的ACID:

| atomicity       | **原子性** |
| --------------- | ---------- |
| **Consistency** | **一致性** |
| **Isolation**   | **独立性** |
| **Durability**  | **持久性** |



CAP:

| **Consistency**         | **强一致性**   |
| ----------------------- | -------------- |
| **Availablity**         | **可用性**     |
| **Partition tilerance** | **分区容错性** |

**任何一个分布式系统最多只能满足CAP三个特性中的两个，而且分区容错性是必须要实现的**

*Eureka遵循AP理论：*

弱一致性

各个节点平等，不存在主存，只要有一台就能保证服务可用，但是可能不是最新的 网络稳定，当前新注册的服务才会同步到其他节点

 *Zookeeper遵循CP理论：*

问题：当master节点由于网络故障，与其他节点失去联系，剩余节点重新进行leader选举。问题在于，选举leader的时间太长，且选举期间zk集群不可用，导致注册服务瘫痪。




