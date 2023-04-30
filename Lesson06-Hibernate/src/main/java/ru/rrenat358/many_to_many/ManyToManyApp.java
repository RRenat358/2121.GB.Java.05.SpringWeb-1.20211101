package ru.rrenat358.many_to_many;

import ru.rrenat358.PrepareDataApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ManyToManyApp {
    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/many_to_many/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        System.out.println("----------------------------");
        try {
            session = factory.getCurrentSession();

//            session.beginTransaction();
//            Book book = session.get(Book.class, 1L);
//            System.out.println(book);
//            System.out.println(book.getReaders());
//            session.getTransaction().commit();

            session.beginTransaction();
            Book book = session.createQuery("SELECT b FROM Book b WHERE b.readers.size = (select MAX(b2.readers.size) from Book b2)", Book.class).getSingleResult();
            System.out.println(book);
            session.getTransaction().commit();

//            session.beginTransaction();
//            Reader reader = session.get(Reader.class, 1L);
//            System.out.println(reader);
//            System.out.println("Books: ");
//            for (Book b : reader.getBooks()) {
//                System.out.println(b.getTitle());
//            }
//            session.getTransaction().commit();

//            session.beginTransaction();
//            List<Reader> readers = session.createQuery("from Reader").getResultList();
//            List<Book> books = session.createQuery("from Book").getResultList();
//            readers.get(1).getBooks().add(books.get(5));
//            readers.get(1).getBooks().add(books.get(6));
//            session.getTransaction().commit();

//            session.beginTransaction();
//            List<Reader> readers = session.createQuery("SELECT r FROM Reader r ORDER BY size(r.books) DESC").getResultList();
//            System.out.println(readers);
//            session.getTransaction().commit();
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            List<Book> allBooks = session.createQuery("SELECT b FROM Book b").getResultList();
//            Reader r = session.get(Reader.class, 2L);
//            allBooks.stream().forEach(b -> {
//                if(b.getId() > 4 && b.getId() < 8) {
//                    r.getBooks().add(b);
//                }
//            });
//            r.getBooks().clear();
//            session.getTransaction().commit();
//            System.out.println(1);
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Reader reader1 = session.get(Reader.class, 1L);
//            reader1.getBooks().removeIf(b -> b.getId() % 2 != 0);
//
//            session.createQuery("DELETE FROM Book b WHERE b.id = 1").executeUpdate();
//
//
//
//            session.getTransaction().commit();
//            System.out.println(2);
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            System.out.println(session.createQuery("SELECT b.title FROM Book b WHERE b.id = 1", String.class).getSingleResult());
//            session.getTransaction().commit();
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            List<Book> books = session.createQuery("FROM Book").getResultList();
//            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
