package com.abdulrahman.assignment_15.MerchantStock.service;

import com.abdulrahman.assignment_15.MerchantStock.module.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MerchantStockService {
    ArrayList<MerchantStock> merchants = new ArrayList<>();
    public ArrayList<MerchantStock> getMerchantStock() {
        return merchants;
    }


    public boolean addMerchantStock(MerchantStock merchantStock) {
        merchants.add(merchantStock);
        return true;
    }

    public boolean editMerchantStock(String merchantStockID, MerchantStock merchantStock) {
        for (int i = 0 ; i < merchants.size();i++) {
            if (merchants.get(i).getId().equals(merchantStockID)){
                merchants.set(i,merchantStock);
                return true;
            }
        }
        return false;
    }
    public boolean deleteMerchantStock(int merchantStockID) {
        for (int i = 0 ; i < merchants.size();i++) {
            if (merchants.get(i).getId().equals(merchantStockID)){
                merchants.remove(i);
                return true;
            }
        }

        return false;
    }
}
