package ru.geekbrains.spring.boot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.boot.model.Product;
import ru.geekbrains.spring.boot.services.ProductService;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public String showAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "all_products";
    }

    @PostMapping("/add_product")
    public String addProducts(@ModelAttribute Product product, @RequestParam(required = false) Long id, @RequestParam(required = false) String title, @RequestParam(required = false) Integer coast) {
        if ((id == null) || (title.equals("")) || (coast == null)) {
            return "redirect:/products/";
        }
        productService.addProduct(product);
        return "redirect:/products/";
    }
}




