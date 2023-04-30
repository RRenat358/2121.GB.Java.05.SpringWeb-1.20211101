package ru.rrenat358.one_to_many_and_back;

import ru.rrenat358.PrepareDataApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToManyAndBackApp {
    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/one_to_many_and_back/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            University university = session.get(University.class, 1L);
//            System.out.println(university.getStudents().get(1).getName());
             System.out.println(university);
            session.getTransaction().commit();
//            System.out.println(university);



//            session.beginTransaction();
//            University universityFromNamedQuery = session
//                    .createNamedQuery("withStudents", University.class)
//                    .setParameter("id", 1L)
//                    .getSingleResult();
//            Student s = session.get(Student.class, 1L);
//            session.getTransaction().commit();
//            System.out.println(s.getUniversity().getTitle());
////            System.out.println(universityFromNamedQuery);
////            System.out.println(universityFromNamedQuery.getStudents());

        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
