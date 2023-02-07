package com.abdulrahman.exercise22.stores.Merchant.Repository;

import com.abdulrahman.exercise22.stores.Merchant.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepo extends JpaRepository<Merchant,Integer> {
    Merchant findMerchantById(Integer id);
}
