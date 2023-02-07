package com.abdulrahman.exercise22.stores.Merchant.Controller;

import com.abdulrahman.exercise22.stores.Branch.Model.Branch;
import com.abdulrahman.exercise22.stores.Merchant.Model.Merchant;
import com.abdulrahman.exercise22.stores.Merchant.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;
    @GetMapping("/merchant")
    public List<Merchant> readMerchant(){
        return merchantService.getMerchant();
    }

    @PostMapping("/merchant")
    public ResponseEntity createMerchants(@RequestBody @Valid Merchant Merchant) {

        merchantService.addMerchant(Merchant);
        return ResponseEntity.status(200).body("Added");
    }


}
