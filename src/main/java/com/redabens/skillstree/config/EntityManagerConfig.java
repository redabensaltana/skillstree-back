package com.redabens.skillstree.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerConfig {
    private static EntityManager entityManager = null;
    static {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("skillstree");
        entityManager = entityManagerFactory.createEntityManager();
    }
    public static EntityManager getEntityManager(){
        return entityManager;
    }
}