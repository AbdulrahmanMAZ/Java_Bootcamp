package com.abdulrahman.project_3.MerchantStock.controller;

import com.abdulrahman.project_3.MerchantStock.module.MerchantStock;
import com.abdulrahman.project_3.MerchantStock.service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/stock")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStocksService;
    @GetMapping("/merchantStocks")
    public ResponseEntity getMerchantStock(){
        return ResponseEntity.status(200).body( merchantStocksService.getMerchantStock());
    }
    @PostMapping("/merchantStocks")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock merchantStocks, Errors error){
        if (error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStocksService.addMerchantStock(merchantStocks);
        return ResponseEntity.status(200).body( "MerchantStock Added");
    }
    @PutMapping("/merchantStocks/{merchantStocksID}")
    public ResponseEntity editMerchantStock(@PathVariable String merchantStocksID, @Valid @RequestBody MerchantStock merchantStocks, Errors error){
        if (error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStocksService.editMerchantStock(merchantStocksID,merchantStocks);
        return ResponseEntity.status(200).body( "MerchantStock Updated");
    }
    @DeleteMapping("/merchantStocks/{merchantStocksID}")
    public ResponseEntity deleteMerchantStock(@PathVariable int merchantStocksID){

        merchantStocksService.deleteMerchantStock(merchantStocksID);
        return ResponseEntity.status(200).body( "MerchantStock Deleted");
    }

}
