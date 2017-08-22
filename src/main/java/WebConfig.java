import com.dream.spring.controller.HelloWord;
import org.springframework.context.annotation.*;

/**
 * Created by ning on 2017/8/20.
 */
//@Configuration注解表明这个类是一个配置类
@Configuration
//Java配置的扫描器
//应用别的配置类
//@ComponentScan("com.dream.spring")
//应用xml装配的bean
@ImportResource("file:src/main/webapp/WEB-INF/applicationContext.xml")

public class WebConfig {
    //@Bean或者@Bean("beanId")
    @Bean(name = "hello")
    public HelloWord helloWord(){
      return new HelloWord("pppp");
    }
}

