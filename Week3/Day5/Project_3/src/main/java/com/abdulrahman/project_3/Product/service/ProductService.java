package com.abdulrahman.project_3.Product.service;

import com.abdulrahman.project_3.Category.service.CategoryService;
import com.abdulrahman.project_3.Product.module.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProductService {
    ArrayList<Product> products = new ArrayList<>();
    final CategoryService categories;
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
    public boolean deleteProducts(String productID) {
        for (int i = 0 ; i < products.size();i++) {
            if (products.get(i).getId().equals(productID)){
                products.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean findCategory(String categoryID) {
        for (int i = 0 ; i < categories.getCategory().size();i++) {
            if (categories.getCategory().get(i).getId().equals(categoryID)){
                return true;
            }
        }
        return false;
    }


}
