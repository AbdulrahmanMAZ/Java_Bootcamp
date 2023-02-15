package com.abdulrahman.store.Product;


import com.abdulrahman.store.MyUser.MyUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts(@AuthenticationPrincipal MyUser myUser){
        return productService.getProducts(myUser);
    }
    @PostMapping
    public ResponseEntity addProduct(@Valid @RequestBody Product product){
        productService.addProduct(product);

        return ResponseEntity.status(HttpStatus.OK).body("Done! ");
    }
    @PutMapping("/{product_id}")
    public ResponseEntity updateProduct(@Valid @RequestBody Product product,@PathVariable Integer product_id){
        productService.updateProduct(product,product_id);
        return ResponseEntity.status(HttpStatus.OK).body("Updated! ");
    }
    @DeleteMapping("/{product_id}")
    public ResponseEntity deleteProduct( @PathVariable Integer product_id){
        productService.deleteProduct(product_id);

        return ResponseEntity.status(HttpStatus.OK).body("Deleted! ");
    }
    // Get product by ID
    @GetMapping("/{product_id}")
    public Product getProductById(@PathVariable Integer product_id){
        return productService.getProductById(product_id);
    }
//
//    @GetMapping("/id/{product_id}")
//    public Product getProductById(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer product_id){
//        return productService.getProductById(myUser,product_id);
//    }
//
//    @GetMapping("/title/{product_title}")
//    public Product getProductByTitle(@AuthenticationPrincipal MyUser myUser,@PathVariable String product_title_title){
//        return blogService.getBlogByTitle(myUser,blog_title);
//    }
}
