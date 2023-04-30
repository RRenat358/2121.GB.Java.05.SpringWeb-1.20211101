package ru.rrenat358.criteria_api;

import ru.rrenat358.PrepareDataApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CriteriaApiMain {
    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/criteria_api/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        CriteriaBuilder criteriaBuilder = null;
        CriteriaQuery<Item> criteriaQuery = null;
        Root<Item> root = null;
        Query<Item> query = null;
        List<Item> results = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            // CriteriaBuilder - построитель выражений, частей запросов, выражений, предикатов и т.д.
            criteriaBuilder = session.getCriteriaBuilder(); // запрос CriteriaBuilder у сессии
            criteriaQuery = criteriaBuilder.createQuery(Item.class); // построитель запроса, <T> - тип возвращаемых объектов
            root = criteriaQuery.from(Item.class); // from - поиск осуществляется среди Item
            criteriaQuery.select(root);
            query = session.createQuery(criteriaQuery);
            results = query.getResultList();
            session.getTransaction().commit();
            System.out.println("All results:\n" + results);
            System.out.println("=====================================================================");


            session = factory.getCurrentSession();
            session.beginTransaction();
            criteriaBuilder = session.getCriteriaBuilder();
            criteriaQuery = criteriaBuilder.createQuery(Item.class);
            root = criteriaQuery.from(Item.class);

            BigDecimal minPrice = new BigDecimal(50.0);
            String startsWith = null;

            List<Predicate> predicates = new ArrayList<>();
            if (minPrice != null) {
                predicates.add(criteriaBuilder.greaterThan(root.get("price"), minPrice));
            }
            if (startsWith != null) {
                predicates.add(criteriaBuilder.like(root.get("title"), startsWith + "%"));
            }
            // todo Добавить поиск по объектам
            criteriaQuery.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
            query = session.createQuery(criteriaQuery);
            results = query.getResultList();
            session.getTransaction().commit();
            System.out.println("Filtered results:\n" + results);
            System.out.println("=====================================================================");


            session = factory.getCurrentSession();
            session.beginTransaction();
            criteriaBuilder = session.getCriteriaBuilder();
            criteriaQuery = criteriaBuilder.createQuery(Item.class);
            root = criteriaQuery.from(Item.class);

            Predicate priceGreaterThan = criteriaBuilder.greaterThan(root.get("price"), new BigDecimal(200.0));
            Predicate titleStartsWithB = criteriaBuilder.like(root.get("title"), "b%");
            criteriaQuery.select(root).where(
                    criteriaBuilder.or(priceGreaterThan, titleStartsWithB)
            ).orderBy(criteriaBuilder.desc(root.get("price")));

            query = session.createQuery(criteriaQuery);
            results = query.getResultList();
            session.getTransaction().commit();
            System.out.println("Filtered results v2:\n" + results);
            System.out.println("=====================================================================");

            session = factory.getCurrentSession();
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<ItemDto> criteria = builder.createQuery(ItemDto.class);
            root = criteria.from(Item.class);

            Path<String> titlePath = root.get("title");
            Path<BigDecimal> pricePath = root.get("price");

            criteria.select(builder.construct(ItemDto.class, titlePath, pricePath));
            criteria.where(builder.greaterThan(root.get("price"), new BigDecimal(80.0)));

            List<ItemDto> dtos = session.createQuery(criteria).getResultList();
            session.getTransaction().commit();
            System.out.println("Dtos: \n" + dtos);
            System.out.println("=====================================================================");


            /*
                CriteriaQuery<Double> c = cb.createQuery(Double.class);
                Root<Account> a = c.from(Account.class);
                c.select(cb.avg(a.get("balance")));
                >>> select avg(a.balance) from Account a;

                CriteriaQuery<Account> c = cb.createQuery(Account.class);
                Root<Account> account = c.from(Account.class);
                Path<Integer> balance = account.get("balance");
                c.where(cb.and(cb.greaterThan(balance, 100), cb.lessThan(balance, 200)));
                >>> select a from Account a where a.balance > 100 and a.balance < 200

                CriteriaQuery<Account> c = cb.createQuery(Account.class);
                Root<Account> account = c.from(Account.class);
                Path<Person> owner = account.get("owner");
                Path<String> name = owner.get("name");
                c.where(cb.in(name).value("X").value("Y").value("Z"));
                >>> select a from Account a where a.owner.name in ('X','Y','Z')
             */

        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}