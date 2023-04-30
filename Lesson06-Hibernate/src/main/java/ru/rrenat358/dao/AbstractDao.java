package ru.rrenat358.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

public class AbstractDao<T, ID extends Serializable> {
    protected SessionFactory sessionFactory;
    protected Class<T> typeClass;
    protected Class<ID> idClass;

    public AbstractDao(SessionFactory sessionFactory, Class<T> typeClass, Class<ID> idClass) {
        this.sessionFactory = sessionFactory;
        this.typeClass = typeClass;
        this.idClass = idClass;
    }

    public T findById(ID id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            T result = session.get(typeClass, id);
            session.getTransaction().commit();
            return result;
        }
    }

    public List<T> findAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<T> result = (List<T>)session.get("from " + typeClass.getSimpleName(), List.class);
            session.getTransaction().commit();
            return result;
        }
    }

    public T saveOrUpdate(T obj) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(obj);
            session.getTransaction().commit();
            return obj;
        }
    }

    public void delete(T obj) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
        }
    }
}
