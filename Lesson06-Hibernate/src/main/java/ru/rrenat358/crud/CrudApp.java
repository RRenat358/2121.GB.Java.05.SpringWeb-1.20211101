package ru.rrenat358.crud;

import ru.rrenat358.PrepareDataApp;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

public class CrudApp {
    private static SessionFactory factory;

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("configs/crud/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        try {
            init();
//            readAndPrintExample();
//            createExample();
            doubleReadExample();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    public static void autoRollback() {
        Transaction transaction = null;
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(new SimpleItem("A", 100));
//            transaction.commit();
            int z = 10 / 0;
            System.out.println(transaction.isActive());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(transaction.isActive());
    }

    public static void showManyItems() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            List<SimpleItem> items = session.createQuery("from SimpleItem").getResultList();
            session.createQuery("delete from SimpleItem s where s.id = :id")
                    .setParameter("id", 1)
                    .executeUpdate();
            System.out.println(items + "\n");

            SimpleItem si1 = session.createQuery("select s from SimpleItem s where s.id = 3", SimpleItem.class).getSingleResult();
            System.out.println(si1 + "\n");

            List<SimpleItem> cheapItems = session.createQuery("select s from SimpleItem s where s.price < 80").getResultList();
            System.out.println(cheapItems + "\n");

            session.getTransaction().commit();
        }
    }

    public static void createExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem dragonStatue = new SimpleItem("Dragon Statue", 100);
            System.out.println(dragonStatue);
            session.save(dragonStatue);
            System.out.println(dragonStatue);
            session.getTransaction().commit();
            System.out.println(dragonStatue);
        }
    }

    public static void rollbackExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem dragonStatue = new SimpleItem("Dragon Statue", 100);
            System.out.println(dragonStatue);
            session.save(dragonStatue);
            System.out.println(dragonStatue);
            session.getTransaction().rollback();
            System.out.println(dragonStatue);
        }
    }

    public static void readAndPrintExample() {
//        try (Session session = factory.openSession()) {
//            SimpleItem simpleItem = session.get(SimpleItem.class, 3L);
//            System.out.println(session.getTransaction().isActive());
//        }

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem simpleItem = session.get(SimpleItem.class, 3L);
            System.out.println(simpleItem);
            session.getTransaction().commit();
        }
    }

    public static void doubleReadExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem simpleItem = session.find(SimpleItem.class, 1L);
            SimpleItem simpleItem2 = session.find(SimpleItem.class, 1L);
            SimpleItem simpleItem3 = session.find(SimpleItem.class, 1L);
            SimpleItem simpleItem4 = session.find(SimpleItem.class, 1L);
            SimpleItem simpleItem5 = session.find(SimpleItem.class, 1L);
            System.out.println(simpleItem);
            session.getTransaction().commit();
        }
    }

    public static void updateExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem simpleItem = session.get(SimpleItem.class, 1L);
            simpleItem.setPrice(1000);
            session.getTransaction().commit();
        }
    }

    public static void deleteExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem simpleItem = session.get(SimpleItem.class, 1L);
            session.delete(simpleItem);
            session.getTransaction().commit();
        }
    }

    public static void fillData() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            for (int i = 0; i < 10000; i++) {
                SimpleItem simpleItem = new SimpleItem(Long.valueOf(i), "Item " + i, 10 * i);
                session.save(simpleItem);
            }
            session.getTransaction().commit();
        }
    }

    public static void testId() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem s = session.get(SimpleItem.class, 1L);
            s.setId(2L);
            session.getTransaction().commit();
        }
    }

    public static void shutdown() {
        factory.close();
    }
}

/*
     <T> T get(Class<T> entityType, Serializable id); # Session
	 * Return the persistent instance of the given entity class with the given identifier,
	 * or null if there is no such persistent instance. (If the instance is already associated
	 * with the session, return that instance. This method never returns an uninitialized instance.)
	 *
	 * @param entityType The entity type
	 * @param id an identifier
	 *
	 * @return a persistent instance or null

     public <T> T find(Class<T> entityClass, Object primaryKey); # EntityManager
     * Find by primary key.
     * Search for an entity of the specified class and primary key.
     * If the entity instance is contained in the persistence context,
     * it is returned from there.
     * @param entityClass  entity class
     * @param primaryKey  primary key
     * @return the found entity instance or null if the entity does
     *         not exist
     * @throws IllegalArgumentException if the first argument does
     *         not denote an entity type or the second argument is
     *         is not a valid type for that entity's primary key or
     *         is null
 */