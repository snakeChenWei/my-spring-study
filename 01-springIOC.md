# what is IOC
```
控制反转（Inversion of Control，缩写为IoC），是面向对象编程中的一种设计原则，可以用来减低计算机代码之间的耦合度。其中最常见的方式叫做依赖注入（Dependency Injection，简称DI），还有一种方式叫“依赖查找”（Dependency Lookup）
```
## Dependency Injection
依赖注入

关于什么是依赖

关于注入和查找以及拖拽

# 为什么要使用spring IOC
spring体系结构----IOC的位置  自己看官网

```
在日常程序开发过程当中，我们推荐面向抽象编程，面向抽象编程会产生类的依赖，当然如果你够强大可以自己写一个管理的容器，但是既然spring以及实现了，并且spring如此优秀，我们仅仅需要学习spring框架便可。
当我们有了一个管理对象的容器之后，类的产生过程也交给了容器，至于我们自己的app则可以不需要去关系这些对象的产生了。
```
# spring实现IOC的思路和方法
```
spring实现IOC的思路是提供一些配置信息用来描述类之间的依赖关系，然后由容器去解析这些配置信息，继而维护好对象之间的依赖关系，前提是对象之间的依赖关系必须在类中定义好，比如A.class中有一个B.class的属性，那么我们可以理解为A依赖了B。既然我们在类中已经定义了他们之间的依赖关系那么为什么还需要在配置文件中去描述和定义呢？
spring实现IOC的思路大致可以拆分成3点
```
1. 应用程序中提供类，提供依赖关系（属性或者构造方法）
2. 把需要交给容器管理的对象通过配置信息告诉容器（xml、annotation，javaconfig）
3. 把各个类之间的依赖关系通过配置信息告诉容器
```
配置这些信息的方法有三种分别是xml，annotation和javaconfig
维护的过程称为自动注入，自动注入的方法有两种构造方法和setter
自动注入的值可以是对象，数组，map，list和常量比如字符串整形等
```
# spring编程的风格
```
schemal-based-------xml
annotation-based-----annotation
java-based----java Configuration
```
# 注入的两种方法
```
spring注入详细配置（字符串、数组等）参考文档：
https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-factory-properties-detailed
```
## Constructor-based Dependency Injection
```
构造方法注入参考文档：
https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-constructor-injection
```
![图片](https://images-cdn.shimo.im/No88OKjKqfQIA1rz/image.png!thumbnail)


## Setter-based Dependency Injection
```
setter参考文档：
https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-setter-injection
```
![图片](https://images-cdn.shimo.im/WClSBbHC63UiHqpU/image.png!thumbnail)

# 自动装配
上面说过，IOC的注入有两个地方需要提供依赖关系，一是类的定义中，二是在spring的配置中需要去描述。自动装配则把第二个取消了，即我们仅仅需要在类中提供依赖，继而把对象交给容器管理即可完成注入。

在实际开发中，描述类之间的依赖关系通常是大篇幅的，如果使用自动装配则省去了很多配置，并且如果对象的依赖发生更新我们可以不需要去更新配置，但是也带来了一定的缺点

自动装配的优点参考文档：

[https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-factory-autowire](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-factory-autowire)

缺点参考文档：

[https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-autowired-exceptions](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-autowired-exceptions)

作为我来讲，我觉得以上缺点都不是缺点

## 自动装配的方法
```
no
byName
byType
constructor
自动装配的方式参考文档：
https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-factory-autowire
```
![图片](https://images-cdn.shimo.im/qyZgYw9KH7Iap0vt/image.png!thumbnail)

# spring懒加载
官网已经解释的非常清楚了：

```
https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-factory-lazy-init
```
```
值得提醒的是，如果你想为所有的对都实现懒加载可以使用官网的配置
```
# ![图片](https://images-cdn.shimo.im/AL7NwUqEre0woKxB/image.png!thumbnail)
# springbean的作用域
```
文档参考：
https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-factory-scopes
```
![图片](https://images-cdn.shimo.im/z7bJcesJ7cMJeMvM/image.png!thumbnail)

xml定义方式

```
<bean id="accountService" class="com.something.DefaultAccountService" scope="singleton"/>
```
annotation的定义方式



## Singleton Beans with Prototype-bean Dependencies
```
意思是在Singleton 当中引用了一个Prototype的bean的时候引发的问题
官网引导我们参考https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-factory-method-injection
```
# spring声明周期和回调
```
参考文档：
https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-factory-lifecycle
1、Methods annotated with @PostConstruct
2、afterPropertiesSet() as defined by the InitializingBean callback interface
3、A custom configured init() method
```







