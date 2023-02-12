package com.abdulrahman.assignment22.Customer.Service;


import com.abdulrahman.assignment22.Merchant.Model.Merchant;
import com.abdulrahman.assignment22.Customer.Model.Customer;
import com.abdulrahman.assignment22.Customer.Repository.CustomerRepo;
import com.abdulrahman.assignment22.Merchant.Repository.MerchantRepo;
import com.abdulrahman.assignment22.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@NoArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final MerchantRepo merchantRepo;

    public List<Customer> getCustomer() {
        return customerRepo.findAll();
    }
    public void addCustomer(Customer customer) {
//        Customer customer1 = customerRepo.findCustomerById()
//        if (merchant == null) {
//            throw new ApiException("No teacher found! ");
//        }
//            Customer customer2 = new Customer(null,customer.getName(),customer.getArea() , merchant);
        customerRepo.save(customer);
    }
    public void editCustomer(Integer id, Customer TA_DTO) {
        Merchant merchant = merchantRepo.findTeacherById(id);
        if (merchant == null) {
            throw new ApiException("No teacher found! ");
        }
        Customer customer = customerRepo.findCustomerById(id);
        if (customer == null) {
            throw new ApiException("No address found for the teacher");
        }
        customer.setArea(TA_DTO.getArea());
        customer.setName(TA_DTO.getName());

//        Customer customer = new Customer(null,customer.getArea(),customer.getStreet(), customer.getBuildingNumber(), teacher);
        customerRepo.save(customer);
    }
    public void deleteCustomer(Integer id) {
        Merchant merchant = merchantRepo.findTeacherById(id);
        if (merchant == null) {
            throw new ApiException("No teacher found! ");
        }
        Customer customer = customerRepo.findCustomerById(id);
        if (customer == null) {
            throw new ApiException("No address found for the teacher");
        }

        merchantRepo.save(merchant);
        customerRepo.delete(customer);
    }
    public void assignCustomerToMerchant(Integer customer_id,Integer merchant_id) {
        Merchant merchant = merchantRepo.findTeacherById(merchant_id);
        if (merchant == null) {
            throw new ApiException("No merchant found! ");
        }
        Customer customer = customerRepo.findCustomerById(customer_id);
        if (customer == null) {
            throw new ApiException("No customer");
        }
        merchant.addCustomer(customer);
        customer.addMerchant(merchant);
        merchantRepo.save(merchant);
        customerRepo.delete(customer);
    }


}
