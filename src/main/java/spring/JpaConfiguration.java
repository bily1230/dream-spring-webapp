package spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by ning on 2017/9/17.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.dream.spring.repository.UserDataJpaRepository")
public class JpaConfiguration {
}
