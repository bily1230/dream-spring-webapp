package spring;

import com.dream.spring.aspect.AspectTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 *  Aop 测试
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

    @Bean
    public AspectTest managerAspect() {
        return new AspectTest();
    }

}
