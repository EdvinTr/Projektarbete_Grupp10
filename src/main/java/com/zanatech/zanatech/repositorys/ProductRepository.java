package com.zanatech.zanatech.repositorys;

import com.zanatech.zanatech.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
