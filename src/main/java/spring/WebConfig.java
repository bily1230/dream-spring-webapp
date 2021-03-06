package spring;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.*;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.http.converter.HttpMessageConverter;

import com.dream.spring.manager.Manager;
import com.dream.spring.mq.RabbitConfiguration;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;


/**
 * Created by ning on 2017/8/20.
 */
//@Configuration注解表明这个类是一个配置类
@Configuration
@EnableWebMvc
@Import({WebProject.class, AspectConfig.class})
//应用xml装配的bean
@ComponentScan("com.dream.spring")

public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public Manager manager(){
		return new Manager();
	}
	
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
                .indentOutput(true)
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd"))
                .modulesToInstall(new ParameterNamesModule());
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }


}

