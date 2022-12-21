package com.redabens.skillstree.dao;

import com.redabens.skillstree.config.EntityManagerConfig;
import com.redabens.skillstree.dao.interfaces.BaseDAO;
import com.redabens.skillstree.util.SoutError;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//@SuppressWarnings({"unchecked", "unused"})
//@Repository
public class BaseDAOImpl<T> implements BaseDAO<T> {


    final private Class<T> clazz;

    public BaseDAOImpl(Class<T> clazz)
    {
        this.clazz = clazz;
    }

    @Override
    public boolean save(T obj) {
        EntityManager em = EntityManagerConfig.getEntityManager();
        try {
            em.getTransaction().begin(); // begin transaction
            em.persist(obj); // add the entity object to the persistent context, so any further changes are tracked.
            em.getTransaction().commit(); // commit transaction
            return true;
        }catch (Exception e)
        {
            em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            return false;
        }finally {
            em.close(); // close entityManager
        }
    }

    @Override
    public boolean update(T obj) {
        EntityManager em = EntityManagerConfig.getEntityManager();
        try {
            em.getTransaction().begin(); // begin transaction
            em.merge(obj); // The main intention of the merge method is to update a persistent entity instance with new field values from a detached entity instance.
            em.getTransaction().commit(); // commit transaction
            return true;
        }catch (Exception e)
        {
            em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            return false;
        }finally {
            em.close(); // close entityManager
        }
    }

    @Override
    public T findById(int id) {
        EntityManager em = EntityManagerConfig.getEntityManager();
        try {
            em.getTransaction().begin(); // begin transaction
            T obj = em.find(clazz, id); // T find(Class<T> entityClass, Object primaryKey) – Returns entity for the given primary key.
            em.getTransaction().commit(); // commit transaction
            return obj;
        }catch (Exception e)
        {
            em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            return null;
        }finally {
            em.close(); // close entityManager
        }
    }

    @Override
    public boolean delete(int id) {
        EntityManager em = EntityManagerConfig.getEntityManager();
        try {
            em.getTransaction().begin(); // begin transaction
            T obj = findById(id);
            if(obj != null)
            {
                T a = em.merge(obj);
                em.remove(a); // The remove() to delete the particular record.
            }
            em.getTransaction().commit(); // commit transaction
            return true;
        }catch (Exception e)
        {
            em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            return false;
        }finally {
            em.close(); // close entityManager
        }
    }

    @Override
    public List<T> getAll() {
        EntityManager em = EntityManagerConfig.getEntityManager();
        try {
            em.getTransaction().begin(); // begin transaction
            Query query = em.createQuery("select t from "+ clazz.getSimpleName() +" t");
            List<T> list = query.getResultList();

            em.getTransaction().commit(); // commit transaction
            return list;
        }catch (Exception e)
        {
            em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            return null;
        }finally {
            em.close(); // close entityManager
        }
    }

    @Override
    public List<T> getAllWhere(String field, Object value) {
        EntityManager em = EntityManagerConfig.getEntityManager();
        try {
            //em.getTransaction().begin(); // begin transaction
            Query query = em.createQuery("select t from "+clazz.getSimpleName()+" t where "+ field + "= :value");
            query.setParameter("value", value);

            List<T> list = query.getResultList(); // get All records where "condition" ==> ( 'field | String' = 'value | object' )

          //  em.getTransaction().commit(); // commit transaction
            return list;
        }catch (Exception e)
        {
          //  em.getTransaction().rollback(); // rollback transaction
            SoutError.print("yellow", e.getMessage());
            return null;
        }finally {
            em.close(); // close entityManager
        }
    }

//    @Override
//    public List<T> customQuery(String jpql, Map<String, Object> params) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("skillstree");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        try{
//            entityManager.getTransaction().begin(); // begin transaction
//            TypedQuery<T> query = entityManager.createQuery(jpql,clazz);
//
//            final int[] index = {params.size()};
//            params.forEach((key, value)->{
//                query.setParameter(index[0],value);
//                index[0] -=1;
//            });
//            List<T> list = query.getResultList();
//            entityManager.getTransaction().commit(); // commit transaction
//            return list;
//        }catch (Exception e){
//            System.out.println("db stack trace: start" );
//            entityManager.getTransaction().rollback(); // rollback transaction
//            SoutError.print("yellow", e.getMessage());
//            System.out.println("db stack trace: end" );
//            return null;
//        }finally {
//            entityManager.close(); // close entityManager
//        }
//    }
    //    @Override
    //    public Object customNativeQuery(String sql, HashMap<String, Object> map) {
//            EntityManager em = EntityManagerConfig.getEntityManager();
    //        em.getTransaction().begin(); // begin transaction
    //        try {
    //            Query query = em.createNativeQuery(sql);
    //            // select firstName, lastName from Manager where id_manager = ? or id_manager = ?
    //
    //            em.getTransaction().commit(); // commit transaction
    //            return true;
    //        }catch (Exception e)
    //        {
    //            em.getTransaction().rollback(); // rollback transaction
    //            SoutError.print("yellow", e.getMessage());
    //            return null;
    //        }finally {
    //            em.close(); // close entityManager
    //            EntityManagerConfig.getEntityManagerFactory().close(); // close entityManagerFactory
    //        }
    //    }
}