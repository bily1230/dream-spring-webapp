# dream-spring-webap

## 1.问题
### 1.关于配置路径问题

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

## 2.装配Bean
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
        
        
### 7.Spring MVC 高级技术

#### 7.1跨重定向请求传递数据

        对于重定向，模型并不能用来传递数据。但是我们也有一些其他方案，能够从发起重
        定向的方法传递数据给处理重定向方法中：
* 使用URL模板以路径变量和/或查询参数的形式传递参数
* 通过flash属性发送数据

```Java
     @Controller
     @RequestMapping("/helloWord")
     public class HelloWord {
         @RequestMapping(value="/{age}/readWord" ,method = RequestMethod.POST)
         public String readWord(@PathVariable("age") String age, @RequestParam("name")String name,
                                RedirectAttributes model){
             User user = new User();
             user.setName(name);
             user.setAge(age);
             System.out.println("中国梦！作为中国人---"+name+"--"+age);
             model.addAttribute("name",name);
             model.addAttribute("age",age);
             model.addFlashAttribute(user);
             return "redirect:/redirectHello/sayName/{name}";
         }
     }
        
        @Controller
        @RequestMapping("/redirectHello")
        public class RedirectHello {
            @RequestMapping("/sayName/{name}")
            public void sayName(@PathVariable("name")String name, @RequestParam("age")String age,Model model, User user){
        
                if(model.containsAttribute("user")){
        
                    System.out.println("redirect******:"+user.getName());
                    System.out.println("redirect******:"+user.getAge());
                }
                System.out.println("redirect:"+name);
                System.out.println("redirect:"+age);
            }
        }
```
*  flash 
 
  在重定向执行之前，所有的flash属性都会复制到会话中。在重定向后，存在会话中的
  flash属性会被取出，并从会话转移到模型之中。


   
            

        
        


