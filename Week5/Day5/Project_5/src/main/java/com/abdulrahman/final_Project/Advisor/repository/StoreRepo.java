package com.abdulrahman.final_Project.Advisor.repository;

import com.abdulrahman.final_Project.Advisor.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo extends JpaRepository<Store,Integer> {
    Store findStoreById(Integer id);

}
