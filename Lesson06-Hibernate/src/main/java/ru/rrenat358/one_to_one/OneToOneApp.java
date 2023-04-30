package ru.rrenat358.one_to_one;

import ru.rrenat358.PrepareDataApp;
import ru.rrenat358.crud.SimpleItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneApp {
    public static void main(String[] args) throws Exception {
        PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/one_to_one/hibernate.cfg.xml")
                .buildSessionFactory();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1L);
//            System.out.println(employee);
//            System.out.println(employee.getDetails());

            EmployeeDetails employeeDetails = session.get(EmployeeDetails.class, 2L);
            System.out.println(employeeDetails);
            System.out.println(employeeDetails.getEmployee());
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
