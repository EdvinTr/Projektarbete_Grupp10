package com.zanatech.zanatech.controllers;

import com.zanatech.zanatech.models.Products;
import com.zanatech.zanatech.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;



    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Products> listProducts = service.listAll(keyword);
        Products products = new Products();
        model.addAttribute("products", products);
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("products") Products products){
        service.save(products);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id){
        service.delete(id);
        return "redirect:/";
    }
}
