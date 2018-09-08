package spring;
import javax.naming.NamingException;
import javax.sql.DataSource;

<<<<<<< HEAD
import org.springframework.context.annotation.*;
=======
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
>>>>>>> c1494374afe010e42d98605a323349d510623daa
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

<<<<<<< HEAD
=======

>>>>>>> c1494374afe010e42d98605a323349d510623daa
/**
 * Created by ning on 2017/8/27.
 */

@Configuration
<<<<<<< HEAD
@Import({AspectConfig.class,RabbitConfiguration.class})
@ComponentScan(basePackages ={"com.dream.spring.manager"},excludeFilters =
=======
@Import({AspectConfig.class,RabbitConfiguration.class,JpaConfiguration.class})
@ComponentScan(basePackages ={"com.dream.spring"},excludeFilters =
>>>>>>> c1494374afe010e42d98605a323349d510623daa
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

