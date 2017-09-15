package spring;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;

import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by ning on 2017/8/21.
 */
@Configuration
public class WebProject {
    /*@Bean
    public MultipartResolver multipartResolver() throws IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setUploadTempDir(new FileSystemResource("/tem/upload"));
        multipartResolver.setMaxUploadSize(2097150);
        multipartResolver.setMaxInMemorySize(0);
        return multipartResolver;

    }*/

}
