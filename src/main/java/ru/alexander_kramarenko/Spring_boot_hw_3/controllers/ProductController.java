package ru.alexander_kramarenko.Spring_boot_hw_3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alexander_kramarenko.Spring_boot_hw_3.model.Product;
import ru.alexander_kramarenko.Spring_boot_hw_3.services.ProductService;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:8186/app/show_all
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
    public String saveProduct(@RequestParam Long id, @RequestParam String title, @RequestParam int price) {
        Product product = new Product(id, title, price);
        productService.save(product);
        return "redirect:/show_all";
    }


}
