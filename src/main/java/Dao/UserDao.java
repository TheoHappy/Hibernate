package Dao;

import Entity.User;
import utils.HibernateSessionFactoryUtil;

import javax.persistence.EntityManager;
/**
 * This is UserDao class
 * @author Theo
 * @version  1.1
 * @since 1.0
 * */

/** He only knows how to work with data<br>
 * <strong>DAO (data access object)</strong> is one of the most common design patterns, Data Access. Its meaning is simple - to create a layer in the application that is responsible only for accessing data, and for nothing else. Get data from the database, update data, delete data - and that's it.
 * */
public class UserDao {

    EntityManager entityManager = HibernateSessionFactoryUtil.getSessionFactory().createEntityManager();

    /**
     * addUser method {@link User} - It is used to add users to the database
     * @param user - receives as a parameter a user that it will add
     * */
    public void addUser(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
    /**
     * getUser method - It is used to get users to the database
     * @param id - receives as a parameter id
     * @return user after chosen id
     * */
    public User getUser(Long id){
        entityManager.getTransaction().begin();
        User user = entityManager.createQuery("from User where  id=:id",User.class)
                .setParameter("id",id)
                .getSingleResult();
        entityManager.getTransaction().commit();
        return user;
    }
    /**
     * delUser method - It is used to del users to the database
     * @param id - receives as a parameter id
     * */
    public void delUser(Long id){
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from User where id=:id")
                .setParameter("id",id)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

}
