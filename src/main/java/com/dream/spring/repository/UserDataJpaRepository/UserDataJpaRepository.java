package com.dream.spring.repository.UserDataJpaRepository;

import com.dream.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ning on 2017/9/17.
 */
public interface UserDataJpaRepository extends JpaRepository<User,Long>{
    User findByName(String name);
}
