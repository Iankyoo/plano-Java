package com.Iankyo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
