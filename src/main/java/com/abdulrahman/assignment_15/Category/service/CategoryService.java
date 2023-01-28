package com.abdulrahman.assignment_15.Category.service;

import com.abdulrahman.assignment_15.Category.module.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CategoryService {
    ArrayList<Category> categories = new ArrayList<>();
    public ArrayList<Category> getCategory() {
        return categories;
    }

    public boolean addCategory(Category category) {
        categories.add(category);
        return true;
    }

    public boolean editCategory(String categoryID,Category category) {
        for (int i = 0 ; i < categories.size();i++) {
            if (categories.get(i).getId().equals(categoryID)){
                categories.set(i,category);
                return true;
            }
        }
        return false;
    }
    public boolean deleteCategory(int categoryID) {
        for (int i = 0 ; i < categories.size();i++) {
            if (categories.get(i).getId().equals(categoryID)){
                categories.remove(i);
                return true;
            }
        }
        return false;
    }

}
