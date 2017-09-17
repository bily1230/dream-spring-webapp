package com.dream.spring.repository.jpa;

import com.dream.spring.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ning on 2017/9/17.
 */
@Repository
@Transactional
public class UserJpaRepository {

    @PersistenceContext
    private EntityManager entityManagerFactory;

    public void addUser(User user){
        entityManagerFactory.persist(user);
    }
}
