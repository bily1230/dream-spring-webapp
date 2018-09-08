package spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ning on 2018/7/2.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages ={"com.dream.spring.manager", "com.dream.spring.aspect"},excludeFilters =
        {@ComponentScan.Filter(type= FilterType.ANNOTATION,value= EnableWebMvc.class)})
public class JunitConfig {
}
