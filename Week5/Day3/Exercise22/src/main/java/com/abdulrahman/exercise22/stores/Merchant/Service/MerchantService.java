package com.abdulrahman.exercise22.stores.Merchant.Service;

import com.abdulrahman.exercise22.stores.Branch.Model.Branch;
import com.abdulrahman.exercise22.stores.Merchant.Model.Merchant;
import com.abdulrahman.exercise22.stores.Merchant.Repository.MerchantRepo;
import com.abdulrahman.exercise22.stores.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class MerchantService {

    private final MerchantRepo merchantRepo;
    public List<Merchant> getMerchant() {
       return merchantRepo.findAll();
    }
    public void addMerchant(Merchant Merchant) {

        merchantRepo.save(Merchant);
    }

}
