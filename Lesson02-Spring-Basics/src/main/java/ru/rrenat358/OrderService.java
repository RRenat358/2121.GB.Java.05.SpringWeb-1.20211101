package ru.rrenat358;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class OrderService {
    private ProductService productService;
    private FileOutputStream fileOut;

    public OrderService(ProductService productService, FileOutputStream fileOut) {
        this.productService = productService;
        this.fileOut = fileOut;
    }

    public void createOrderFromProduct(Long productId) {
        System.out.println("Заказ создан:");
        System.out.println(productService.getTitleById(productId));
        try {
            fileOut.write("READY".getBytes());
            fileOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}