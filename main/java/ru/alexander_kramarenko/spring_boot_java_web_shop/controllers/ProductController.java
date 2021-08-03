package ru.alexander_kramarenko.spring_boot_java_web_shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alexander_kramarenko.spring_boot_java_web_shop.model.Product;
import ru.alexander_kramarenko.spring_boot_java_web_shop.services.ProductService;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/show_all")
    public String showProductsPage(Model model){
        model.addAttribute("products", productService.findAll());

        return "products";
    }

    @GetMapping("/show/{id}")
    public String showStudentsPage(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.findById(id));
        return "product_info";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create_product";
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/show_all";
    }


}
