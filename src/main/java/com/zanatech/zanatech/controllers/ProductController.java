package com.zanatech.zanatech.controllers;

import com.zanatech.zanatech.models.Products;
import com.zanatech.zanatech.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;
    private Object Product;

    @RequestMapping("/ZanaTech")
    public String viewHomePage(Model model) {
        List<Products> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        return "index";
    }
}
