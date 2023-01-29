package com.abdulrahman.project_3.Product.controller;

import com.abdulrahman.project_3.Product.module.Product;
import com.abdulrahman.project_3.Product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/products")
    public ResponseEntity getProducts(){
        return ResponseEntity.status(200).body( productService.getProducts());
    }
    @PostMapping("/products")
    public ResponseEntity addProducts(@Valid @RequestBody Product product, Errors error){
        if (error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (productService.findCategory(product.getCategoryID())){
            productService.addProducts(product);
            return ResponseEntity.status(200).body( "Product Added");

        }
        return ResponseEntity.status(400).body( "The category name is not correct");

    }
    @PutMapping("/products/{productID}")
    public ResponseEntity editProducts(@PathVariable String productID,@Valid @RequestBody Product product, Errors error){
        if (error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.editProducts(productID,product);
        return ResponseEntity.status(200).body( "Product Updated");
    }
    @DeleteMapping("/products/{productID}")
    public ResponseEntity deleteProducts(@PathVariable String productID){


        productService.deleteProducts(productID);
        return ResponseEntity.status(200).body( "Product Deleted");
    }

}
