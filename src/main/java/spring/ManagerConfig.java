package spring;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ning on 2017/8/27.
 */

@Configuration
@ComponentScan(basePackages ={"com.dream.spring.manager"},excludeFilters =
        {@ComponentScan.Filter(type= FilterType.ANNOTATION,value= EnableWebMvc.class)})
public class ManagerConfig {

}

