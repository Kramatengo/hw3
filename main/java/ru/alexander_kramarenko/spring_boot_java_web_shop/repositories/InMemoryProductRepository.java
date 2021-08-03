package ru.alexander_kramarenko.spring_boot_java_web_shop.repositories;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.alexander_kramarenko.spring_boot_java_web_shop.model.Product;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

@Component
@Primary
public class InMemoryProductRepository  implements ProductRepository  {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Milk", 85),
                new Product(2L, "Bread", 25),
                new Product(3L, "Cheese", 250),
                new Product(4L, "Butter", 450),
                new Product(5L, "Mayonnaise", 300)
        ));
    }

    public Product findById(Long id) {
        return products.stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }

    public Product findByTitle(String title){

            return products.stream().filter(i -> Objects.equals(i.getTitle().substring(0, 2), title.substring(0, 2))).findFirst().get();
    }

    public List<Product> findAll() {
        return products;
    }

    public void save(Product product) {
        Long newId = products.stream().mapToLong(Product::getId).max().getAsLong() + 1;
        product.setId(newId);
        products.add(product);
    }
}
