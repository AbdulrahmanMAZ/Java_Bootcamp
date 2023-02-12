package com.abdulrahman.project_5.Store.service;

import com.abdulrahman.project_5.Book.model.Book;
import com.abdulrahman.project_5.Book.repository.BookRepo;
import com.abdulrahman.project_5.Customer.model.Customer;
import com.abdulrahman.project_5.Customer.repository.CustomerRepo;
import com.abdulrahman.project_5.DTO.LocationDTO;
import com.abdulrahman.project_5.Location.model.Location;
import com.abdulrahman.project_5.Location.repository.LocationRepo;
import com.abdulrahman.project_5.Store.model.Store;
import com.abdulrahman.project_5.Store.repository.StoreRepo;
import com.abdulrahman.project_5.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StoreService {
    final private StoreRepo storeRepo;
    final private BookRepo bookRepo;
    final private LocationRepo locationRepo;

    final private CustomerRepo customerRepo;



    public List<Store> getStores(){
        return storeRepo.findAll();
    }
    public void addStore(Store store){
        storeRepo.save(store);

    }
    public void editStore(Integer id,Store store){
        Store temp = storeRepo.findStoreById(id);
        if (temp == null) {
            throw new ApiException("Not found");
        }
        temp.setName(store.getName());
        temp.setBooks(store.getBooks());
        temp.setLocation(store.getLocation());
        storeRepo.save(temp);

    }
    public void deleteStore(Integer id){
        Store temp = storeRepo.findStoreById(id);
        if (temp == null) {
            throw new ApiException("Not found");
        }
        storeRepo.delete(temp);

    }
    public void addLocationToStore(Integer store_id, LocationDTO location){
        Store store_temp = storeRepo.findStoreById(store_id);


        if (store_temp == null || location == null  ) {
            throw new ApiException("Not found");
        }
        Location location_temp = new Location(null,location.getArea(),location.getStreet(),store_temp);
        store_temp.setLocation(location_temp);
        locationRepo.save(location_temp);
        storeRepo.save(store_temp);
//        locationRepo.save(location_temp);
    }
    public List<Book> getBooksInStore(Integer id){
        Store temp = storeRepo.findStoreById(id);
        if (temp == null ) {
            throw new ApiException("Not found");
        }
        return temp.getBooks();
    }
    public void addBookToStore(Integer store_id,Integer book_id){
        Store store_temp = storeRepo.findStoreById(store_id);
        Book book_temp = bookRepo.findBookById(book_id);

        if (store_temp == null || book_temp == null) {
            throw new ApiException("Not found");
        }

        store_temp.addBookToStore(book_temp);
        book_temp.setStore(store_temp);
        bookRepo.save(book_temp);
        storeRepo.save(store_temp);





    }
    public void registerCustomerToStore(Integer store_id,Integer customer_id){
        Store store_temp = storeRepo.findStoreById(store_id);
        Customer customer_temp = customerRepo.findCustomerById(customer_id);

        if (store_temp == null || customer_temp == null) {
            throw new ApiException("Not found");
        }

        store_temp.registerCustomerToStore(customer_temp);
        customer_temp.addStoreToCustomer(store_temp);

        storeRepo.save(store_temp);
        customerRepo.save(customer_temp);
    }
    public List<Customer> getCustomerInStore(Integer id){
        Store temp = storeRepo.findStoreById(id);
        if (temp == null ) {
            throw new ApiException("Not found");
        }
        return temp.getCustomers();
    }
}
