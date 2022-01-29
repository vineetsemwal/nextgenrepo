package com.mycompany.empms;

import com.mycompany.empms.frontend.FrontEndClient;
import com.mycompany.empms.util.JpaUtil;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        FrontEndClient frontEnd = context.getBean(FrontEndClient.class);
        frontEnd.render();

        JpaUtil jpaUtil = context.getBean(JpaUtil.class);
        EntityManager em = jpaUtil.getEntityManager();
        if (em != null) {
            em.close();
        }
        EntityManagerFactory emf = jpaUtil.getEntityManagerFactory();
        if (emf != null) {
            emf.close();
        }
        context.close();


    }
}
