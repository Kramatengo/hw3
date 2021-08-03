package ru.alexander_kramarenko.spring_boot_java_web_shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// http://localhost:8186/app
@Controller
public class MainController {
    @GetMapping
    public String showIndexPage() {

        return "index";
    }

}
