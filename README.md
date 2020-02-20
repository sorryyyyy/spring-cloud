# spring-cloud
springcloud基础学习工程

- feat：提交新功能
- fix：修复了bug
- docs：只修改了文档
- style：调整代码格式，未修改代码逻辑（比如修改空格、格式化、缺少分号等）
- refactor：代码重构，既没修复bug也没有添加新功能
- perf：性能优化，提高性能的代码更改
- test：添加或修改代码测试
- chore：对构建流程或辅助工具和依赖库（如文档生成等）的更改

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

### Ribbon

Spring Cloud Ribbon是基于Netflix Ribbon 实现的一套客户端  负载均衡的工具。

简单的说，Ribbon是Netflix发布的开源项目，主要功能是**提供客户端的软件负载均衡算法**，将NetFlix的中间层服务连接在一起。Ribbon科幻段组件提供一系列完善的配置项如连接超时,重试等.简单地说,就是在配置文件中列出Load Balance（简称LB）后面的机器，Ribbon会自动的帮助你基于某种规则（如简单轮转，随机连接等）去连接这些机器。我们也很容易使用Ribbon实现自定义的负载均衡算法。

#### Ribbon核心组件IRule

**IRule**：根据特定算法中从服务列表中选取一个要访问的服务

Ribbon采用的负载均衡算法：

- RoundRobinRule  轮询：默认

- RandomRule  随机

- AvailabilityFilteringRule 

  会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务、还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问

- WeightedResponseTimeRule

  根据平均响应时间计算所有服务的权重，响应时间越快的服务权重越大，选中的概率越高。刚启动时如果统计信息不足，则上有RoundRobinRule策略，等统计信息足够，会切换到WeightedResponseTimeRule

- RetryRule

  先按RoundRobinRule轮询算法获取服务，如果失败则在指定时间内进行重试

- BestAvailableRule

  会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务

- ZoneAvoidanceRule

  默认规则，复合判断Server所在区域的性能和Server的可用性选择服务
  
  ### Feign
  
  Feign是一个声明式WebService客户端。使用Feign能让编写WebService客户端更加简单，它的使用方法是定义一个接口，然后在上面添加注解，同事也支持JAX-RS标准的注解。Feign也支持可插拔的编码器和解码器。Spring Cloud对Feign进行了封装，使其支持了Spring MVC标准注解和HttpMessageConverters。Feign可以与Erueka和Ribbon组合使用以支持负载均衡。
  
  **Feign是一个声明式的Web服务客户端，使得编写Web服务客户端变得非常容易，*只需要创建一个接口，然后在上面添加注解即可*。**
  
  面向接口编程，比如webservice接口
  
  
  
  - 微服务名称获得调用地址
  
  - 通过接口+注解，获得调用服务
  
    统一面向接口的编程套路---feign
  
    前面再使用Ribbon+RestTemplate时，利用RestTemplate对http请求的封装处理，形成一套模板化的调用方法，但是在实际的开发中，由于对服务依赖的调用可能不止一处，往往一个接会被多处调用，所以通常会针对每个微服务自行封装一些客户端类来包装这些依赖服务的调用。所以，Feign在此基础上做了一些封装，由他来帮助我么定义和实现依赖服务接口的定义。在Feign的实现下，我们只需要创建一个接口并使用注解的方式来配置它（以前是Dao接口上面标注Mapper注解，现在是一个微服务接口上面标注一个Feign注解即可），即可完成对为服务提供方便的接口绑定，简化了使用Spring Cloud Ribbon时，自动封装服务调用客户端的开发量。

### Hystrix断路器

分布式系统面临的问题：复杂分布式体系结构中的应用程序有数十个依赖关系，每个依赖关系在某些时候将不可避免地失败

Hystrix是一个用于处理分布式系统的延迟和容错的开源库,在分布式系统里,许多依赖不可避免的会调用失败,比如超时、异常等，Hystrix能保证在一个依赖出问题的情况下，不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性。

”断路器“本身是一种开关装置，当某个服务单元发生故障之后，通过断路器的故障监控，向调用方返回一个符合预期的可处理的备选响应（FallBack），而不是长时间的等待或者抛出调用方无法处理的异常，这样就保证了服务调用方的线程不会被长时间、不必要地占用，从而避免了故障在分布式系统中的蔓延，乃至雪崩。

- 服务熔断

  熔断机制是应对雪崩效应的一种微服务链路保护机制。当扇出链路的某个微服务不可用或者响应时间太长时，会进行服务的降级，进而熔断该节点微服务的调用，快速返回”错误“的响应信息。当检测到该节点微服务调用响应正常后恢复调用链路。在SpringCloud框架里熔断机制通过Hystrix实现。Hystrix会监控微服务间的调用状况，当失败的调用到一定的阈值，缺省是5秒内20次调用失败就会启用熔断机制。熔断机制的额注解是@HystrixCommand
