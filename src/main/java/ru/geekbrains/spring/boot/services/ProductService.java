package ru.geekbrains.spring.boot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.boot.model.Product;
import ru.geekbrains.spring.boot.repositories.ProductRepositories;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepositories productRepositories;

    public Product getProductById(Long id) {
        return productRepositories.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return productRepositories.getAllProducts();
    }

    public void addProduct(Product product) {
        productRepositories.addProduct(product);
    }
}
