package com.zanatech.zanatech.services;

import com.zanatech.zanatech.models.Products;
import com.zanatech.zanatech.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Products> listAll(String keyword){
        if(keyword != null) {
            return repo.findAll(keyword);
        }
        return repo.findAll();
    }

    public void save(Products products){
        repo.save(products);
    }

    public Products get(Integer id){
        return repo.findById(id).get();
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }
}
