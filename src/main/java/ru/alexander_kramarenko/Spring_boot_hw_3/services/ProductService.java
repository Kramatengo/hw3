package ru.alexander_kramarenko.Spring_boot_hw_3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.alexander_kramarenko.Spring_boot_hw_3.model.Product;
import ru.alexander_kramarenko.Spring_boot_hw_3.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(@Qualifier(value = "inMemoryProductRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public int getSumPrice() {
        return productRepository.findAll().stream().mapToInt(Product::getPrice).sum();
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    public Product findByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }


}
