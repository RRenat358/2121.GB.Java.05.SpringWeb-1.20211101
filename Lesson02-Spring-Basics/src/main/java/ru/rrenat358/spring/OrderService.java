package ru.rrenat358.spring;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@RequiredArgsConstructor
public class OrderService {

//    public static OrderService instance = new OrderService();

//    private OrderService() {
//    }


    //field-injection
//    @Autowired
//    private OrderNameService orderNameService;


    private final OrderNameService orderNameService;
    //constructor-injection
    @Autowired //не обязательно, но рекомендовано (не обязательно с версии 5.*)
    public OrderService(OrderNameService orderNameSequence) {
        this.orderNameService = orderNameSequence;
    }


    //setter-injection
//    @Autowired
//    public void setOrderNameService(OrderNameService orderNameService) {
//        this.orderNameService = orderNameService;
//    }


    @PostConstruct
    public void init() {
        System.out.println("Ещё один бин класса OrderService");
    }

    @PreDestroy
    public void destroyBean() {
        System.out.println("Закрываем бин");
    }



    public Order createNewOrder() {
        Order order = new Order();
//        order.setName("Заказ ещё и # "); //for manual Bean
        orderNameService.initName(order);
        return order;

    }

}
