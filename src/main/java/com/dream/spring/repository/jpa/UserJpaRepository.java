package com.dream.spring.repository.jpa;

import com.dream.spring.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * Created by ning on 2017/9/17.
 */

@Transactional
@Repository
public class UserJpaRepository {
	
	
    @PersistenceContext
    private EntityManager entityManagerFactory;
    
    
    public void addUser(User user){
        entityManagerFactory.persist(user);
    }
}
