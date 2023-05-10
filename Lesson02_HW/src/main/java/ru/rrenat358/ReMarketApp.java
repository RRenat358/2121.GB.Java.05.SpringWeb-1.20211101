package ru.rrenat358;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ReMarketApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        BasketService basketService = context.getBean(BasketService.class);

        System.out.println("\n--- addToBasket --------------");
        addToBasket(basketService);

        System.out.println("\n--- showBasket----------------");
        basketService.showBasket();

        System.out.println("\n--- removeFromBasket ---------");
        removeFromBasket(basketService);

        System.out.println("\n--- showBasket----------------");
        basketService.showBasket();

        System.out.println("\n------------------------------");


        context.close();
    }

    private static void addToBasket(BasketService basketService) {
        for (int i = 0; i < 3 ; i++) {
            Scanner scanner = new Scanner(System.in);
            Long id = scanner.nextLong();
            basketService.addById(id);
        }
    }


    private static void removeFromBasket(BasketService basketService) {
            Scanner scanner = new Scanner(System.in);
            Long id = scanner.nextLong();
            basketService.removeById(id);
    }


}
