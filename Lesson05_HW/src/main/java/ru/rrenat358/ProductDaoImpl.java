package ru.rrenat358;


import org.hibernate.Session;
import org.springframework.stereotype.Component;


@Component
public class ProductDaoImpl implements ProductDao {

    private final SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
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



}
