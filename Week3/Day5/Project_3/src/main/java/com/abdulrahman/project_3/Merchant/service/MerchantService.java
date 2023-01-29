package com.abdulrahman.project_3.Merchant.service;

import com.abdulrahman.project_3.Merchant.module.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MerchantService {
    ArrayList<Merchant> merchants = new ArrayList<>();
    public ArrayList<Merchant> getMerchant() {
        return merchants;
    }

    public boolean addMerchant(Merchant category) {
        merchants.add(category);
        return true;
    }

    public boolean editMerchant(String categoryID, Merchant category) {
        for (int i = 0 ; i < merchants.size();i++) {
            if (merchants.get(i).getId().equals(categoryID)){
                merchants.set(i,category);
                return true;
            }
        }
        return false;
    }
    public boolean deleteMerchant(int categoryID) {
        for (int i = 0 ; i < merchants.size();i++) {
            if (merchants.get(i).getId().equals(categoryID)){
                merchants.remove(i);
                return true;
            }
        }
        return false;
    }

}
