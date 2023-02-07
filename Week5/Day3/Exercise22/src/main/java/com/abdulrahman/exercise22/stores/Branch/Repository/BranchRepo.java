package com.abdulrahman.exercise22.stores.Branch.Repository;


import com.abdulrahman.exercise22.stores.Branch.Model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch,Integer> {
    Branch findBranchById(Integer id);

}
