package com.dream.spring.repository.jpa;

import com.dream.spring.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ning on 2017/9/17.
 */

@Repository
public class UserJpaRepository {
	
	
    @PersistenceContext
    private EntityManager entityManagerFactory;
    
    @Transactional
    public void addUser(User user){
        entityManagerFactory.persist(user);
    }
}
