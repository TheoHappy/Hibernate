package utils;

import Entity.User;
import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * This is HibernateSessionFactoryUtil
 * He has only one task - to create a session factory for our application to work with the database
 * @author Theo
 * @version  1.1
 * @since 1.0
 */
public class HibernateSessionFactoryUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
            try {
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml").build();
                Metadata metadata = new MetadataSources(serviceRegistry)
                        .getMetadataBuilder().build();
                return metadata.getSessionFactoryBuilder().build();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSessionFactory(){
        getSessionFactory().close();
    }
}
