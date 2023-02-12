package com.abdulrahman.project_5.Store.controller;

import com.abdulrahman.project_5.Book.model.Book;
import com.abdulrahman.project_5.Customer.model.Customer;
import com.abdulrahman.project_5.Store.model.Store;
import com.abdulrahman.project_5.Store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor
public class StoreController {

    // ServiceInjection
    private final StoreService storeService;

    // getter
    @GetMapping("/getstore")
    public List<Store> getStores(){
        return storeService.getStores();
    }
    @PostMapping("/addstore")

    public ResponseEntity addStores( @RequestBody Store store){
                storeService.addStore(store);
                return ResponseEntity.status(200).body("Success");

    }
    @PutMapping("/editstore/{id}")
    public ResponseEntity updateStores(@PathVariable Integer id, @RequestBody Store store){
        storeService.editStore(id,store);
        return ResponseEntity.status(200).body("Updated");

    }
    @DeleteMapping("/deletestore/{id}")
    public ResponseEntity updateStores(@PathVariable Integer id){
        storeService.deleteStore(id);
        return ResponseEntity.status(200).body("Updated");

    }

    // Create endpoint that takes storeid and return all the books
    @GetMapping("/get_store_books/{store_id}")
    public Set<Book> getBooksInStore(@PathVariable Integer store_id){
        return storeService.getBooksInStore(store_id);
    }
    //Create endpoint thar takes storeid and return all customers
    @GetMapping("/get_store_customers/{store_id}")
    public List<Customer> getCustomersByStore(@PathVariable Integer store_id){
        return storeService.getCustomerInStore(store_id);
    }

    // End points to add books and register customers
    @PutMapping("{store_id}/assignbook/{book_id}")
    public ResponseEntity updateStores(@PathVariable Integer store_id,@PathVariable Integer book_id){
        storeService.addBookToStore(store_id,book_id);
        return ResponseEntity.status(200).body("assigned");

    }
    @PutMapping("{store_id}/register_user_to_store/{customer_id}")
    public ResponseEntity registerCustomerToStore(@PathVariable Integer store_id,@PathVariable Integer customer_id){
        storeService.registerCustomerToStore(store_id,customer_id);
        return ResponseEntity.status(200).body("customer is now registered");

    }

}
