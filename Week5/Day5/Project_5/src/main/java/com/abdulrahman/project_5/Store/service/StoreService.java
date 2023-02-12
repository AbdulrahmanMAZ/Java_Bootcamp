package com.abdulrahman.project_5.Store.service;

import com.abdulrahman.project_5.Book.model.Book;
import com.abdulrahman.project_5.Book.repository.BookRepo;
import com.abdulrahman.project_5.Customer.model.Customer;
import com.abdulrahman.project_5.Customer.repository.CustomerRepo;
import com.abdulrahman.project_5.Store.model.Store;
import com.abdulrahman.project_5.Store.model.Store;
import com.abdulrahman.project_5.Store.repository.StoreRepo;
import com.abdulrahman.project_5.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    final private StoreRepo storeRepo;
    final private BookRepo bookRepo;

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
    public void addBookToStore(Integer store_id,Integer book_id){
        Store store_temp = storeRepo.findStoreById(store_id);
        Book book_temp = bookRepo.findBookById(book_id);

        if (store_temp == null || book_temp == null) {
            throw new ApiException("Not found");
        }

        store_temp.addBookToStore(book_temp);
        storeRepo.save(store_temp);
        bookRepo.save(book_temp);


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
