package com.abdulrahman.assignment22.Merchant.Repository;

import com.abdulrahman.assignment22.Merchant.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepo extends JpaRepository<Merchant,Integer> {
    Merchant findTeacherById(Integer id);
}
