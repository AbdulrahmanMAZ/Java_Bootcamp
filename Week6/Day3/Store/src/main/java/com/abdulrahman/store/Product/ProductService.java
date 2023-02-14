package com.abdulrahman.store.Product;

import com.abdulrahman.store.MyUser.MyUser;
import com.abdulrahman.store.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;


    public List<Product> getProducts(MyUser myUserr) {
        return productRepo.findAllById(myUserr.getId());
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }
    public void updateProduct(Product product,Integer product_id) {
        Product product_temp = productRepo.findProductById(product_id);

        if (product_temp == null) {
            throw new ApiException("not found");
        }
//        MyUser myUser_temp = product_temp.getMyUser();
//        if (myUser_temp == null) {
//            throw new ApiException("not found");
//        }
//        if (myUser_temp.getId() != myUser.getId()) {
//            throw new ApiException("You are not authorized to edit this product");
//        }
        product_temp.setId(product_id);
        product_temp.setPrice(product.getPrice());
        product_temp.setName(product.getName());
        productRepo.save(product_temp);

    }

    public void deleteProduct(Integer product_id) {
        Product product_temp = productRepo.findProductById(product_id);

        if (product_temp == null) {
            throw new ApiException("not found");
        }
//        MyUser myUser_temp = product_temp.getMyUser();
//        if (myUser_temp == null) {
//            throw new ApiException("not found");
//        }
//
//        if (myUser_temp.getId() != myUser.getId()) {
//            throw new ApiException("You are not authorized to delete this blog");
//        }

        productRepo.delete(product_temp);
    }

//    public Blog getPById(MyUser myUser,Integer blog_id) {
//        Product blog_temp = productRepo.findProductById(blog_id);
//
//        if (blog_temp == null) {
//            throw new ApiException("not found");
//        }
//        MyUser myUser_temp = blog_temp.getMyUser();
//        if (myUser_temp == null) {
//            throw new ApiException("not found");
//        }
//
//        if (myUser_temp.getId() != myUser.getId()) {
//            throw new ApiException("You are not authorized to delete this blog");
//        }
//        return blog_temp;
//    }
//    public Blog getBlogByTitle(MyUser myUser,String blog_title) {
//        Blog blog_temp = blogRepo.findBlogByTitle(blog_title);
//        if (blog_temp == null) {
//            throw new ApiException("not found");
//        }
//        MyUser myUser_temp = blog_temp.getMyUser();
//        if (myUser_temp == null) {
//            throw new ApiException("not found");
//        }
//
//        if (myUser_temp.getId() != myUser.getId()) {
//            throw new ApiException("You are not authorized to delete this blog");
//        }
//
//        return blog_temp;
//    }

}
