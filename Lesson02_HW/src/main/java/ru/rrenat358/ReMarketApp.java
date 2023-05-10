package ru.rrenat358;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ReMarketApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        BasketService basketService = context.getBean(BasketService.class);

        addBasket(basketService);
        basketService.showBasket();


        context.close();
    }

    private static void addBasket(BasketService basketService) {
        for (int i = 0; i < 3 ; i++) {
            Scanner scanner = new Scanner(System.in);
            Long id = scanner.nextLong();
            basketService.addById(id);
        }

    }



}
