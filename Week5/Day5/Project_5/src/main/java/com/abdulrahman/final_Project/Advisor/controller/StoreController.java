package com.abdulrahman.final_Project.Advisor.controller;

import com.abdulrahman.final_Project.Appointments.model.Book;
import com.abdulrahman.final_Project.Start_up.model.Customer;
import com.abdulrahman.final_Project.DTO.LocationDTO;
import com.abdulrahman.final_Project.Advisor.model.Store;
import com.abdulrahman.final_Project.Advisor.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Book> getBooksInStore(@PathVariable Integer store_id){
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
    @PostMapping("/add_location_to_store/{store_id}")
    public ResponseEntity addLocationToStore(@PathVariable Integer store_id, @RequestBody LocationDTO location){
        storeService.addLocationToStore(store_id,location);
        return ResponseEntity.status(200).body("Store location updated");

    }

}
