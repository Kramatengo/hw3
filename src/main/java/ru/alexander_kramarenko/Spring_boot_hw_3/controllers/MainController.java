package ru.alexander_kramarenko.Spring_boot_hw_3.controllers;

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
