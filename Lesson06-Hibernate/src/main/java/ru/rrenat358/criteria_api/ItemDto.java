package ru.rrenat358.criteria_api;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemDto implements Serializable {
    private static final long serialVersionUID = -5178262488854776390L;

    private String title;

    private BigDecimal price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ItemDto() {
    }

    public ItemDto(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ItemDto [title = %s, price = %s]", title, price);
    }
}
