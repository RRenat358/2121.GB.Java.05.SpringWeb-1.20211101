package ru.rrenat358.javaConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.rrenat358.spring.OrderNameService;
import ru.rrenat358.spring.OrderService;

@Configuration
public class JavaConfig {

    //==================================================
    @Bean
    public OrderService orderService(OrderNameService orderNameService) {
        return new OrderService(orderNameService);
    }

    @Bean
    public OrderNameService orderNameService() {
        return new OrderNameService();
    }

    //==================================================
    @Bean("first")
    public String firstStringBean() {
        return "I am string firstStringBean";
    }

    @Bean//("second")
    public String secondStringBean() {
        return "I am string secondStringBean";
    }

    //==================================================
    @Bean
    public String primaryStringBean() {
        return "I am string primaryStringBean";
    }

    @Bean
    @Primary
    public String primary2StringBean() {
        return "I am string primary2StringBean";
    }

    //==================================================


}
