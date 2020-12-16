package ru.geekbrains.spring.boot.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.boot.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepositories {
    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Молоко", 45));
        products.add(new Product(2L, "Печенье", 86));
        products.add(new Product(3L, "Сыр", 365));
        products.add(new Product(4L, "Хлеб", 38));
    }

    public Product getProductById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new RuntimeException("Товара с таким id не существует");
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
