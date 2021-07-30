package ru.alexander_kramarenko.Spring_boot_hw_3.repositories;

import org.springframework.stereotype.Component;
import ru.alexander_kramarenko.Spring_boot_hw_3.model.Product;

import java.util.List;

@Component
public interface ProductRepository {

    Product findById(Long id);

    Product findByTitle(String title);

    List<Product> findAll();

    void save(Product product);

}
