package spring;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
		
	    @Pointcut("execution(* com.xyz.someapp..service.*.*(..))")
	    public void businessService() {}
}
