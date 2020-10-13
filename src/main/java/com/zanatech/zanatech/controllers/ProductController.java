package com.zanatech.zanatech.controllers;

import com.zanatech.zanatech.models.Products;
import com.zanatech.zanatech.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;
    private Object Product;


    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Products> listProducts = service.listAll();
        Products products = new Products();
        model.addAttribute("products", products);
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("products") Products products){
        service.save(products);
        return "redirect:/zanatech";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id){
        service.delete(id);
        return "redirect:/zanatech";
    }
}
