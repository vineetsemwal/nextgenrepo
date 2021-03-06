package com.mycompany.empms.util;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Component
public class JpaUtil {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;

    public EntityManager getOrCreateEntityManager() {
        if (em != null) {
            return em;
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("empms");
        em = emf.createEntityManager();
        return em;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}
