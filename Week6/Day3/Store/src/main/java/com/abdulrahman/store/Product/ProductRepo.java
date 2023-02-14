package com.abdulrahman.store.Product;

import com.abdulrahman.store.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
     List<Product> findAllById(Integer id);
     Product findProductById(Integer id);


}
