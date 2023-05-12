package ru.rrenat358;


import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductDaoImpl implements ProductDao {

    private final SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }


    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();


            session.getTransaction().commit();
            return null;
        }
    }


    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();

            Product product = session.get(Product.class, id);

            session.getTransaction().commit();
            return product;
        }
    }


    @Override
    public Product findByName(String name) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();


            session.getTransaction().commit();
            return null;
        }
    }


    @Override
    public void save(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();


            session.getTransaction().commit();
        }
    }


    @Override
    public void updateNameById(Long id, String newName) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();


            session.getTransaction().commit();
        }
    }


    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();


            session.getTransaction().commit();
        }
    }


    @Override
    public void testCaching() {

        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();

            session.get(Product.class, 1L);
            session.get(Product.class, 2L);

            session.getTransaction().commit();
        }
    }



}
