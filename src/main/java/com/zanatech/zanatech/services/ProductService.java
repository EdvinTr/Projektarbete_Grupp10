package com.zanatech.zanatech.services;

import com.zanatech.zanatech.models.Product;
import com.zanatech.zanatech.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> listAll(String keyword) {
        if (keyword != null) {
            return repo.findAll(keyword);
        }
        return repo.findAll();
    }

    public void save(Product product) {
        repo.save(product);
    }

    public Product get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<Product> sortByAsc(String columnName) {
        return repo.findAll(Sort.by(Sort.Direction.ASC, columnName));
    }

    public List<Product> sortByDesc(String columnName) {
        return repo.findAll(Sort.by(Sort.Direction.DESC, columnName));
    }
}
