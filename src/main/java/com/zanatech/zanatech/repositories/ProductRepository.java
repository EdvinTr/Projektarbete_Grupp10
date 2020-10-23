package com.zanatech.zanatech.repositories;

import com.zanatech.zanatech.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
            + " OR p.type LIKE %?1%")
    List<Product> findAll(String keyword);

}
