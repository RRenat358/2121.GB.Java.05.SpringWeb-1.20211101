package ru.rrenat358.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class OrderDao extends AbstractDao<Order, Long> {
    public OrderDao(SessionFactory sessionFactory) {
        super(sessionFactory, Order.class, Long.class);
    }

    public List<Order> findByUserId(Long userId) {
        // ...
        return null;
    }
    // OrderDao orderDao = new OrderDao(...);
    // AbstractDao<Order, Long> orderDao = new AbstractDao<>(...);
}
