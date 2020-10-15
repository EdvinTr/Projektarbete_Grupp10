package com.zanatech.zanatech.controllers;

import com.zanatech.zanatech.models.Products;
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
        List<Products> listProducts = service.listAll(keyword);
        /* HÄR ÄR ETT FEL*/
        Products products = new Products();
        model.addAttribute("products", products);
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("products") Products products, @RequestParam Map<String, String> params) {
        products.setName(params.get("editName"));
        products.setPrice(Double.valueOf(params.get("editPrice")));
        products.setType(params.get("editType"));
        products.setQuantity(Integer.valueOf(params.get("editQuantity")));
        service.save(products);
        return "redirect:/";
    }

    @RequestMapping("/save")
    public String saveProd(@ModelAttribute("products") Products product) {
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
        List<Products> listProducts;
        if (orderByCounter == 0) {
            listProducts = service.sortByAsc(columnName);
            orderByCounter = 1;
        } else {
            listProducts = service.sortByDesc(columnName);
            orderByCounter = 0;
        }
        Products products = new Products();
        model.addAttribute("products", products);
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
