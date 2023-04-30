package ru.rrenat358.dao;

import ru.rrenat358.PrepareDataApp;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DaoApp {
    private static SessionFactory factory;

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("configs/dao/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        try {
            init();
            ProductDao productDao = new ProductDao(factory);
            Product p = productDao.findById(1L);
        } finally {
            close();
        }
    }

    public static void close() {
        factory.close();
    }
}
