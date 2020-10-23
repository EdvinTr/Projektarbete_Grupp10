package com.zanatech.zanatech.controllers;

import com.zanatech.zanatech.models.Product;
import com.zanatech.zanatech.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;
    private int orderByCounter = 0;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Product> listProducts = service.listAll(keyword);
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") Product product, @RequestParam Map<String, String> params) {
        product.setName(params.get("editName"));
        product.setPrice(Double.valueOf(params.get("editPrice")));
        product.setType(params.get("editType"));
        product.setQuantity(Integer.valueOf(params.get("editQuantity")));
        service.save(product);
        return "redirect:/";
    }

    @RequestMapping("/save")
    public String saveProd(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id) {
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/orderById")
    public String orderById(Model model, @RequestParam(value = "id") String columnName) {
        return orderBy(model, columnName);
    }

    @RequestMapping("/orderByPrice")
    public String orderByPrice(Model model, @RequestParam(value = "price") String columnName) {
        return orderBy(model, columnName);
    }

    @RequestMapping("/orderByType")
    public String orderByType(Model model, @RequestParam(value = "type") String columnName) {
        return orderBy(model, columnName);
    }

    @RequestMapping("/orderByQuantity")
    public String orderByQuantity(Model model, @RequestParam(value = "quantity") String columnName) {
        return orderBy(model, columnName);
    }

    @RequestMapping("/orderByName")
    public String orderByName(Model model, @RequestParam(value = "name") String columnName) {
        return orderBy(model, columnName);
    }

    private String orderBy(Model model, @RequestParam("x") String columnName) {
        List<Product> listProducts;
        if (orderByCounter == 0) {
            listProducts = service.sortByAsc(columnName);
            orderByCounter = 1;
        } else {
            listProducts = service.sortByDesc(columnName);
            orderByCounter = 0;
        }
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/logout-success")
    public String logoutPage() {
        return "login";
    }
}
