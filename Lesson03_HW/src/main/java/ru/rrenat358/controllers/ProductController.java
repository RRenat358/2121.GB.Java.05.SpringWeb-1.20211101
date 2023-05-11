package ru.rrenat358.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.rrenat358.repository.ProductRepository;


@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    private String findAll(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping("/product/{id}")
    private String findById(Model model, @PathVariable Long id) {
        model.addAttribute("product",productRepository.findById(id));
        return "product-info";
    }


}
