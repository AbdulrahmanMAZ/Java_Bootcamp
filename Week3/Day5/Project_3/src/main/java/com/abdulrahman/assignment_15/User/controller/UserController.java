package com.abdulrahman.assignment_15.User.controller;

import com.abdulrahman.assignment_15.Merchant.service.MerchantService;
import com.abdulrahman.assignment_15.MerchantStock.module.MerchantStock;
import com.abdulrahman.assignment_15.MerchantStock.service.MerchantStockService;
import com.abdulrahman.assignment_15.User.module.User;
import com.abdulrahman.assignment_15.User.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final MerchantStockService merchantStockService;

    @GetMapping("/user")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body( userService.getUser());
    }
    @PostMapping("/user")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors error){
        if (error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body( "User Added");
    }
    @PutMapping("/user/{userID}")
    public ResponseEntity editUser(@PathVariable String userID,@Valid @RequestBody User user, Errors error){
        if (error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (userService.editUser(userID,user)){
            return ResponseEntity.status(200).body( "User Updated");
        }else {
            return ResponseEntity.status(400).body( "User Not Found");

        }

    }
    @DeleteMapping("/user/{userID}")
    public ResponseEntity deleteUser(@PathVariable int userID){

        userService.deleteUser(userID);
        return ResponseEntity.status(200).body( "User Deleted");
    }
    @PostMapping("/add_product")
    public ResponseEntity addProduct(@Valid @RequestBody MerchantStock merchantStock, Errors error){
        if (error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if ( userService.addProduct(merchantStock.getProductID(), merchantStock.getMerchantID(), merchantStock.getStock())) {
            return ResponseEntity.status(200).body( "Product Added to the merchant stock");

        }else {
            return ResponseEntity.status(400).body( "Product Not added");

        }


    }
    @PostMapping("/buy_product")
    public ResponseEntity buyProduct(@Valid @RequestBody Payment payment, Errors error){
        if (error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean validTransaction = userService.checkData(payment.userID(),payment.productID(),payment.merchantID());
        if (validTransaction == true) {
            return ResponseEntity.status(200).body( "Successful purchases");

        }else {
            return ResponseEntity.status(400).body( "Something went wrong");

        }
//        merchantStockService.addMerchantStock(merchantStock);

    }

}
 record Payment(String userID, String productID, String merchantID) { }
