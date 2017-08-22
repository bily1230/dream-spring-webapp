# dream-spring-webap

##1.问题
###1.关于配置路径问题

 * classpath

        配置的路径问题，classes目录存放src目录Java文件编译之后的class文件，xml、properties等资源配置文件
        通过classpath 引用classes目录中的文件
```XML
<param-value>classpath:applicationContext-*.xml</param-value> 
```
        classpath：只会到你的class路径中查找找文件;
        classpath*：不仅包含class路径，还包括jar文件中(class路径)进行查找。
 * WEB-INF

        WEB-INF/ 是资源目录, 客户端不能直接访问
        classs端配置资源文件时需要引用全路径
        @ImportResource("file:src/main/webapp/WEB-INF/applicationContext.xml")

##2.装配Bean
* 自动化装配

        java中 @ComponentScan注解，能够启动组件扫描
        也可在XML配置
        <context:component-scan base-package="com.dream.spring"></context:component-scan>
        扫描会寻找带有@Component注解的类，并为其创建bean。
        @Component会将类名的第一个字母变为小写，作为Bean的id，也可以通过@Component("**")设置bean的id
        
* Java显示装配

        Java装配通过@Configuration注解表明一个类是配置类，
        然后创建一个返回所需类型实例的方法，给方法添加@Bean注解
        就声明一个bean

```Java
//@Configuration注解表明这个类是一个配置类
@Configuration
//Java配置的扫描器
@ComponentScan(basePackages = {"com.dream.spring.controller"})
//应用别的配置类
@Import(WebProject.class)
//应用xml装配的bean
@ImportResource("classpath:applicationContext.xml")
public class WebConfig {
    //@Bean或者@Bean("beanId")
    @Bean(name = "hello")
    public HelloWord helloWord(){
      return new HelloWord();
    }
}
```
        
* XML显示装配

        可以在XML 引用java配置类
        <bean class="WebConfig"></bean> 
            

        
        


