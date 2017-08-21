# dream-spring-webap


##1.装配Bean
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
        
        


