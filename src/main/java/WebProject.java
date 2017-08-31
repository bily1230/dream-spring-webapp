import com.dream.spring.controller.HelloWord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.portlet.multipart.CommonsPortletMultipartResolver;

import java.io.IOException;

/**
 * Created by ning on 2017/8/21.
 */
@Configuration
public class WebProject {
    @Bean
    public MultipartResolver multipartResolver() throws IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setUploadTempDir(new FileSystemResource("/tem/upload"));
        multipartResolver.setMaxUploadSize(2097150);
        multipartResolver.setMaxInMemorySize(0);
        return multipartResolver;

    }

}
