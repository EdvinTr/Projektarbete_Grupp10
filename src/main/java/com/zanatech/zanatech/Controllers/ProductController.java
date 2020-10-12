package com.zanatech.zanatech.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("Value", "Nein!");
        return "index";
    }
}
