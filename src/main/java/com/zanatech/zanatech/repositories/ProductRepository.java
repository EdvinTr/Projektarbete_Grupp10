package com.zanatech.zanatech.repositories;

import com.zanatech.zanatech.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Integer> {

    @Query("SELECT p FROM Products p WHERE p.name LIKE %?1%"
            + " OR p.type LIKE %?1%")
    List<Products> findAll(String keyword);


}
