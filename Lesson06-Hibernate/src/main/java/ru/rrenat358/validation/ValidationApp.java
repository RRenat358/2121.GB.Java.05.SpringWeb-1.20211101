package ru.rrenat358.validation;

import ru.rrenat358.PrepareDataApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationApp {
    public static void main(String[] args) throws Exception {
        PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/validation/hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            ValidationBean validationBean = new ValidationBean();
            validationBean.setEmail("hello_world@gmail.com");
            validationBean.setPriority(40);
            validationBean.setPostalCode("123456");
            session.save(validationBean);
            session.getTransaction().commit();
            System.out.println(validationBean);
//            Thread.sleep(5000);

            session = factory.getCurrentSession();
            session.beginTransaction();
            ValidationBean updatedBean = session.get(ValidationBean.class, 2L);
            updatedBean.setPriority(updatedBean.getPriority() + 1);
            session.save(updatedBean);
            session.getTransaction().commit();
            System.out.println(updatedBean);
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }

        ValidationBean invalidBean = new ValidationBean();
        invalidBean.setEmail("abcd@gmail.com");
        invalidBean.setPriority(5);
        invalidBean.setPostalCode("222222");

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<ValidationBean>> violations = validator.validate(invalidBean, FullRule.class);
        for (ConstraintViolation<ValidationBean> cv : violations) {
            System.out.println(cv);
        }
    }
}
