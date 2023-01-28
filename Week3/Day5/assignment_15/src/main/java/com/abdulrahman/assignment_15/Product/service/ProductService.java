package com.abdulrahman.assignment_15.Product.service;

import com.abdulrahman.assignment_15.Product.module.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product> products = new ArrayList<>();
    public ArrayList<Product> getProducts() {
        return products;
    }

    public boolean addProducts(Product product) {
        products.add(product);
        return true;
    }

    public boolean editProducts(String productID,Product product) {
        for (int i = 0 ; i < products.size();i++) {
            if (products.get(i).getId().equals(productID)){
                products.set(i,product);
                return true;
            }
        }
        return false;
    }
    public boolean deleteProducts(int productID) {
        for (int i = 0 ; i < products.size();i++) {
            if (products.get(i).getId().equals(productID)){
                products.remove(i);
                return true;
            }
        }
        return false;
    }


}
