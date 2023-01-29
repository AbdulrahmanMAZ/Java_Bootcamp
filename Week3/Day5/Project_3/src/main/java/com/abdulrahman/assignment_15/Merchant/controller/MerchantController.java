package com.abdulrahman.assignment_15.Merchant.controller;

import com.abdulrahman.assignment_15.Merchant.module.Merchant;
import com.abdulrahman.assignment_15.Merchant.service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;
    @GetMapping("/merchant")
    public ResponseEntity getMerchant(){
        return ResponseEntity.status(200).body( merchantService.getMerchant());
    }
    @PostMapping("/merchant")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors error){
        if (error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body( "Merchant Added");
    }
    @PutMapping("/merchant/{merchantID}")
    public ResponseEntity editMerchant(@PathVariable String merchantID, @Valid @RequestBody Merchant merchant, Errors error){
        if (error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.editMerchant(merchantID,merchant);
        return ResponseEntity.status(200).body( "Merchant Updated");
    }
    @DeleteMapping("/merchant/{merchantID}")
    public ResponseEntity deleteMerchant(@PathVariable int merchantID){

        merchantService.deleteMerchant(merchantID);
        return ResponseEntity.status(200).body( "Merchant Deleted");
    }

}
