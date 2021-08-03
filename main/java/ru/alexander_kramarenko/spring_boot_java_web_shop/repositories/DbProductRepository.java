package ru.alexander_kramarenko.spring_boot_java_web_shop.repositories;

import org.springframework.stereotype.Component;
import ru.alexander_kramarenko.spring_boot_java_web_shop.model.Product;

import java.util.List;

@Component
public class DbProductRepository  implements ProductRepository  {


    @Override
    public Product findById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Product findByTitle(String title) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Product> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save(Product product) {
        throw new UnsupportedOperationException();
    }



}
