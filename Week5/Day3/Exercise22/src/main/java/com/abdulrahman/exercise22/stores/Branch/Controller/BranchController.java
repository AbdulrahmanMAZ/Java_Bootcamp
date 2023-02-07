package com.abdulrahman.exercise22.stores.Branch.Controller;

import com.abdulrahman.exercise22.stores.Branch.Model.Branch;
import com.abdulrahman.exercise22.stores.Branch.Service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class BranchController {
    private final BranchService branchService;

    @GetMapping("/branch")
    public List<Branch> readMerchant(){
        return branchService.getBranch();
    }

    @PostMapping("/branch")
    public ResponseEntity createCustomers(@RequestBody @Valid Branch branch) {

        branchService.addBranch(branch);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/branch/{id}")
    public ResponseEntity editCustomers(@PathVariable Integer id,@RequestBody @Valid Branch branch) {

        branchService.editBranch(id,branch);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("{merchant_id}/branch/{id}")
    public ResponseEntity editCustomers(@PathVariable Integer merchant_id,@PathVariable Integer id) {

        branchService.assignBranch(merchant_id,merchant_id);
        return ResponseEntity.status(200).body("Added");
    }

}
