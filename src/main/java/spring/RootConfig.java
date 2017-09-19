package spring;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ning on 2017/8/27.
 */
@Configurable
@Import({JpaConfiguration.class})
@EnableTransactionManagement 
@ComponentScan(basePackages ={"com.dream.spring"},excludeFilters =
        {@ComponentScan.Filter(type= FilterType.ANNOTATION,value= EnableWebMvc.class)})
public class RootConfig {
		
	@Bean
	public JndiObjectFactoryBean dataSource() throws NamingException{

		JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
		factory.setJndiName("jdbc/MySQL");
		factory.setResourceRef(true);
		factory.setProxyInterface(javax.sql.DataSource.class);
		factory.afterPropertiesSet();
		return factory;
		
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


	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adapter;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
																		   JpaVendorAdapter jpaVendorAdapter){
		LocalContainerEntityManagerFactoryBean emfb=
				new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setPackagesToScan("com.dream.spring.domain");
		return emfb;
	}

	@Bean
	public BeanPostProcessor persistenceTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public DataSourceTransactionManager txManager(DataSource dataSource){
		
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource);
		return txManager;
	}
	
	/*@Bean
	public  AnnotationTransactionAspect annotationTransactionAspect(DataSourceTransactionManager txManager){
		AnnotationTransactionAspect.aspectOf().setTransactionManager(txManager);
	}*/
	
}

