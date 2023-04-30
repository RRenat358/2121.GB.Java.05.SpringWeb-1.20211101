package ru.rrenat358.linked_objects;

import ru.rrenat358.PrepareDataApp;
import ru.rrenat358.one_to_many_and_back.Student;
import ru.rrenat358.one_to_many_and_back.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Scanner;

public class LinkedObjectsApp {
    public static void main(String[] args) throws IOException {
        PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/linked_objects/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            BottomlessBox box = session.get(BottomlessBox.class, 1L);
            session.remove(box);

            session.getTransaction().commit();
//            System.out.println(box2);
//            System.out.println(
//                    "Достали коробку с БД. Посмотрите на таблицу things в БД.\n" +
//                            "Нажмите кнопку для продолжения..."
//            );
//            System.in.read();
//
//            System.out.println("=========================");
////            for (int i = 0; i < box.getThings().size(); i++) {
////                box.getThings().get(i).setBox(null);
////            }
//            box.getThings().clear();
//            System.out.println(box);
//
//            System.out.println(
//                    "Очистили коробку в программе, и в распечатке это видно.\n" +
//                            "В таблице things связи все еще видны. Это потому что при работе с объектами, запросы в базу пока не отправляются.\n" +
//                            "Нажмите кнопку для продолжения..."
//            );
//            System.in.read();
//
//            System.out.println("=========================");
//            session.flush();
//            System.out.println(
//                    "А теперь мы вытолкнули изменения из контекста постоянства, и попробуйте найти в таблице вещей ссылки на коробку id = 1\n" +
//                    "Нажмите кнопку для завершения..."
//            );
//            System.in.read();
//            session.getTransaction().commit();

            // Как видите, для работы с объектами в базе, нет необходимости выполнять какие-то запросы
            // просто работаем с объектами в нашем приложении
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
