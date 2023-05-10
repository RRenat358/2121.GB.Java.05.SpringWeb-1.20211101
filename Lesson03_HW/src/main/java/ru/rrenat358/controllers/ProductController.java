package ru.rrenat358.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.rrenat358.repository.ProductRepository;


@Controller
public class ProductController {

    private ProductRepository productRepository;

    @GetMapping("/product/{id}")
    private void findById(Model model, @PathVariable Long id) {
        model.addAttribute(productRepository.findById(id));
    }


}
