package ru.rrenat358.locking;

import ru.rrenat358.PrepareDataApp;
import ru.rrenat358.many_to_many.Book;
import ru.rrenat358.many_to_many.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class LockingApp {
    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();
        onlyVersioningTest();
//        optimisticVersioningThreadingTest();
    }

    public static void onlyVersioningTest() {
        SessionFactory factory = new Configuration()
                .configure("configs/locking/hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            LockingItem item = new LockingItem(20);
            System.out.println(item);
            session.save(item);
            System.out.println(item);
            item.setValue(item.getValue() + 10);
            System.out.println(item);
            session.save(item);
            System.out.println(item);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            item = session.get(LockingItem.class, 1L);
            item.setValue(10000);
            System.out.println(item);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            item = session.get(LockingItem.class, 1L);
            System.out.println(item);
            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }

    public static void optimisticVersioningThreadingTest() {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        SessionFactory factory = new Configuration()
                .configure("configs/locking/hibernate.cfg.xml")
                .buildSessionFactory();

        {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(new LockingItem(5));
            session.getTransaction().commit();
        }

        try {
            new Thread(() -> {
                System.out.println("Thread #1 started");
                Session session = factory.getCurrentSession();
                session.beginTransaction();

                LockingItem item = session.get(LockingItem.class, 1L);
                item.setValue(item.getValue() + 10);
                uncheckableSleep(1000);
                session.getTransaction().commit();
                System.out.println("Thread #1 committed");
                if (session != null) {
                    session.close();
                }
                countDownLatch.countDown();
            }).start();

            new Thread(() -> {
                System.out.println("Thread #2 started");
                Session session = factory.getCurrentSession();
                session.beginTransaction();
                LockingItem item = session.get(LockingItem.class, 1L);
                item.setValue(200);
                uncheckableSleep(3000);
                try {
                    session.getTransaction().commit();
                    System.out.println("Thread #2 committed");
                } catch (OptimisticLockException e) {
                    session.getTransaction().rollback();
                    System.out.println("Something going wrong: " + e.getMessage());
                    System.out.println("Thread #2 rolled back");
                }
                if (session != null) {
                    session.close();
                }
                countDownLatch.countDown();
            }).start();

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("END");
        } finally {
            factory.close();
        }
    }

    public static void queryOptimisticLockHandle() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<LockingItem> items = session.createQuery("SELECT i FROM LockingItem i WHERE i.id < :id;", LockingItem.class)
                    .setLockMode(LockModeType.OPTIMISTIC)
                    .setParameter("id", 2L)
                    .getResultList();
            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }

    public static void queryPessimisticLockHandle() {
        SessionFactory factory = new Configuration()
                .configure("configs/locking/hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            int totalValue = 0;
            List<LockingItem> lockingItems = session.createQuery("SELECT i FROM LockingItem i WHERE i.id < :id;", LockingItem.class)
                    .setLockMode(LockModeType.PESSIMISTIC_READ) // PESSIMISTIC_READ = FOR SHARE; PESSIMISTIC_WRITE = FOR UPDATE;
                    .setHint("javax.persistence.lock.timeout", 5000)
                    .setParameter("id", 5L)
                    .getResultList();
            for (LockingItem i : lockingItems) {
                totalValue += i.getValue();
            }
            session.getTransaction().commit();
            System.out.println("Total Value: " + totalValue);
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }

    public static void uncheckableSleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
