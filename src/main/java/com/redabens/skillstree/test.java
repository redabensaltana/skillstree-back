package com.redabens.skillstree;

import com.redabens.skillstree.config.EntityManagerConfig;
import com.redabens.skillstree.entity.Student;
import jakarta.persistence.EntityManager;

public class test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setPromo("2020");
        student.setFirstname("Reda");
        student.setLastname("Bens");
        student.setEmail("bens@gmail.com");
        student.setPassword("bens@gmail.com");
        EntityManager em = EntityManagerConfig.getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();

    }
}

