package ru.rrenat358;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.rrenat358.spring.Box;

public class Main {
    public static void main(String[] args) {

        // IoC -- Inversion Of Control -- инверсия контроля
        // DI  -- Dependency Injection -- внедрение зависимостей


        // BeanFactory
        // configuration (xml) --> bean definition --> bean factory --> bean --> application context



        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ru.rrenat358.spring");

//        ConfigurableApplicationContext context =
//        new AnnotationConfigApplicationContext("ru.rrenat358.javaConfig");


//        OrderService orderService = context.getBean(OrderService.class);

//        OrderNameService orderNameService = context.getBean(OrderNameService.class);

//        OrderService orderService = new OrderService();
/*

        System.out.println("--------------------------------");
        Order order = orderService.createNewOrder();
        System.out.println(order);

//        orderNameService.initName(order);
//        System.out.println(order);


        System.out.println("--------------------------------");
        System.out.println(orderService.createNewOrder());
        System.out.println(orderService.createNewOrder());
        System.out.println(orderService.createNewOrder());

*/


        System.out.println("------------------------------");
        System.out.println(context.getBean(Box.class).getId());
        System.out.println(context.getBean(Box.class).getId());
        System.out.println(context.getBean(Box.class).getId());

        System.out.println("------------------------------");
        System.out.println(new Box().getId());
        System.out.println(new Box().getId());
        System.out.println(new Box().getId());


//        String stringBean = context.getBean(String.class);
//        System.out.println(stringBean);

        System.out.println("------------------------------");
        context.close();


    }
}