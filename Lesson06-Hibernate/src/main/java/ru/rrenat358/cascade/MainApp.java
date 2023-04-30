package ru.rrenat358.cascade;

import ru.rrenat358.PrepareDataApp;
import ru.rrenat358.crud.SimpleItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/cascade/hibernate.cfg.xml")
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            Order order = session.get(Order.class, 1L);
            order.getProducts().get(0).setPrice(1000);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
