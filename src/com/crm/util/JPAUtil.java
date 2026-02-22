package com.crm.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    // Create EntityManagerFactory only once
    private static final EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("JPA-PU");

    // Method to get EntityManager
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    // Method to close factory (call on application exit)
    public static void closeFactory() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}