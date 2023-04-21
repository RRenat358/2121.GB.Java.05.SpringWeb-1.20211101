package ru.rrenat358.javaConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StringContainer {

    @Autowired
    @Qualifier("first") //определяем какой бин
    private String bean;
//    private String first;

//    public StringContainer(@Qualifier("first") String bean) {
//        this.bean = bean;
//    }

    @PostConstruct // сразу после постройки бина и до исполнения следующий методов в приложении
    public void init() {
        System.out.println("injected == " + bean);
//        System.out.println("injected == " + first);
    }

//    @PreDestroy // перед закрытием бинов


}
