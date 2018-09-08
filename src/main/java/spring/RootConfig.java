package spring;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ning on 2017/8/27.
 */

@Configuration
@Import({AspectConfig.class,RabbitConfiguration.class})
@ComponentScan(basePackages ={"com.dream.spring.manager"},excludeFilters =
        {@ComponentScan.Filter(type= FilterType.ANNOTATION,value= EnableWebMvc.class)})
public class RootConfig {
		
	@Bean
	public DataSource dataSource() throws NamingException{

		JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
		factory.setJndiName("jdbc/MySQL");
		factory.setResourceRef(true);
		factory.setProxyInterface(javax.sql.DataSource.class);
		factory.afterPropertiesSet();
		return (DataSource)factory.getObject();
		
		/*Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		return (DataSource)envContext.lookup("jdbc/MySQL");*/
		
		/*BasicDataSource basicDataSource  = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:Mysql://127.0.0.1:3306/dream");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root");
		basicDataSource.setInitialSize(5);
		basicDataSource.setMinIdle(5);
		return basicDataSource;*/
	
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}



}

