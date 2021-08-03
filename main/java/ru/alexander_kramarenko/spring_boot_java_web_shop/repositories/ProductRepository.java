package ru.alexander_kramarenko.spring_boot_java_web_shop.repositories;

import org.springframework.stereotype.Component;
import ru.alexander_kramarenko.spring_boot_java_web_shop.model.Product;

import java.util.List;

@Component
public interface ProductRepository {

    Product findById(Long id);

    Product findByTitle(String title);

    List<Product> findAll();

    void save(Product product);

}
