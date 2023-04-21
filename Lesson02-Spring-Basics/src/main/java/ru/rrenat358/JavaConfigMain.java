package ru.rrenat358;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.rrenat358.javaConfig.StringContainer;
import ru.rrenat358.spring.Box;

import java.util.Arrays;

public class JavaConfigMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ru.rrenat358.javaConfig");


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
//        StringContainer bean = context.getBean(StringContainer.class);



        System.out.println("------------------------------");
//        context.close();


    }
}