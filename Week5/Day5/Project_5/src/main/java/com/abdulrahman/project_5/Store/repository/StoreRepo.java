package com.abdulrahman.project_5.Store.repository;

import com.abdulrahman.project_5.Store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo extends JpaRepository<Store,Integer> {
    Store findStoreById(Integer id);

}
