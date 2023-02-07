package com.abdulrahman.exercise22.stores.Branch.Service;


import com.abdulrahman.exercise22.stores.Branch.DTO.BranchDTO;
import com.abdulrahman.exercise22.stores.Branch.Model.Branch;
import com.abdulrahman.exercise22.stores.Branch.Repository.BranchRepo;
import com.abdulrahman.exercise22.stores.Merchant.Model.Merchant;
import com.abdulrahman.exercise22.stores.Merchant.Repository.MerchantRepo;
import com.abdulrahman.exercise22.stores.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
//@NoArgsConstructor
public class BranchService {
    private final BranchRepo branchRepo;
    private final MerchantRepo merchantRepo;

    public List<Branch> getBranch() {
        return branchRepo.findAll();
    }
    public void addBranch(Branch brch) {
//        Branch branch = branchRepo.findBranchById()

        branchRepo.save(brch);
    }

    public void editBranch(Integer id,Branch branch) {

    }

    public void assignBranch(Integer merchant_id, Integer branch_id){
        Merchant merchant = merchantRepo.findMerchantById(merchant_id);
        Branch branch = branchRepo.findBranchById(branch_id);
        if (branch == null || merchant == null) {
            throw new ApiException("Not valid data");
        }
//        Set<Branch> branches =  merchant.getBranches();
        branch.setMerchant(merchant);

        merchant.addNewBranch(branch);
        branchRepo.save(branch);
        merchantRepo.save(merchant);
    }
}
