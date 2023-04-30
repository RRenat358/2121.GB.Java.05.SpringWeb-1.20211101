package ru.rrenat358.lifecycle;

import ru.rrenat358.PrepareDataApp;
import ru.rrenat358.crud.SimpleItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class LifecycleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/lifecycle/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        try {
            AliveBean aliveBean = new AliveBean("Bean Jack");

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("contains: " + session.contains(aliveBean));

            session.persist(aliveBean);
            System.out.println("[persist] contains: " + session.contains(aliveBean) + "\nCheck database table and press any button...");
            scanner.next();

//            session.save(aliveBean); // return T
//            System.out.println("[save] contains: " + session.contains(aliveBean) + "\nCheck database table and press any button...");
//            scanner.next();

            System.out.println(aliveBean);

//            session.remove(aliveBean);

            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
