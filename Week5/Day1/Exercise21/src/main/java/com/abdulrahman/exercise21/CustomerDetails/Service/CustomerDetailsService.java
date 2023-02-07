package com.abdulrahman.exercise21.CustomerDetails.Service;

import com.abdulrahman.exercise21.Customer.Model.Customer;
import com.abdulrahman.exercise21.Customer.Repository.CustomerRepo;
import com.abdulrahman.exercise21.CustomerDetails.DTO.CustomerDetailsDTO;
import com.abdulrahman.exercise21.CustomerDetails.Model.CustomerDetails;
import com.abdulrahman.exercise21.CustomerDetails.Repository.CustomerDetailsRepo;
import com.abdulrahman.exercise21.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@NoArgsConstructor
public class CustomerDetailsService {
    private final CustomerDetailsRepo customerDetailsRepo;
    private final CustomerRepo customerRepo;

    public List<CustomerDetails> getCustomer() {
        return customerDetailsRepo.findAll();
    }
    public void addCustomer(CustomerDetailsDTO cdDTO) {
        Customer customer = customerRepo.findCustomerById(cdDTO.getCustomer_id());
        if (customer == null) {
            throw new ApiException("No customer found! ");
        }
            CustomerDetails customerDetails = new CustomerDetails(null,"Abdulrahman",25,"Male",customer);
        customerDetailsRepo.save(customerDetails);
    }
}
