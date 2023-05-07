package ru.rrenat358;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Box {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @PostConstruct
    public void init() {
        color = "Red";
    }

    public Box() {
    }

    public Box(String color) {
        this.color = color;
    }
}
