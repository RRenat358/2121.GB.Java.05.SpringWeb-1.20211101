package ru.rrenat358.HWSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HWCartMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ru.rrenat358.HWJavaConfig");


        System.out.println("------------------------------");
//        Object productRepository = context.getBean("ProductRepository");
//        System.out.println(productRepository);

        Object cart = context.getBean("ProductRepository");
        System.out.println(cart.toString());







/*

        System.out.println("------------------------------");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);


        System.out.println("------------------------------");
        Object first = context.getBean("first");
        System.out.println(first);

        Object second = context.getBean("secondStringBean");
        System.out.println(second);


        System.out.println("------------------------------");
        String primaryBean = context.getBean(String.class);
        System.out.println(primaryBean);


        System.out.println("------------------------------");
//        String stringBean = context.getBean(String.class);
//        System.out.println(stringBean); // Exception == NoSuchBeanDefinitionException


        System.out.println("------------------------------");
//        context.close();

*/

    }
}