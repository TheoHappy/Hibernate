package Dao;

import Entity.User;
import utils.HibernateSessionFactoryUtil;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;

public class UserDao {

    EntityManager entityManager = HibernateSessionFactoryUtil.getSessionFactory().createEntityManager();
    public void addUser(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public User getUser(Long id){
        entityManager.getTransaction().begin();
        User user = entityManager.createQuery("from User where  id=:id",User.class)
                .setParameter("id",id)
                .getSingleResult();
        entityManager.getTransaction().commit();
        return user;
    }

    public void delUser(Long id){
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from User where id=:id")
                .setParameter("id",id)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

}
