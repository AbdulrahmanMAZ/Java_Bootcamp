package com.abdulrahman.exercise21.TempDetails.Service;

import com.abdulrahman.exercise21.Customer.Model.Customer;
import com.abdulrahman.exercise21.Customer.Repository.CustomerRepo;
import com.abdulrahman.exercise21.TempDetails.DTO.TempDetailsDTO;
import com.abdulrahman.exercise21.TempDetails.Model.TempDetails;
import com.abdulrahman.exercise21.TempDetails.Repository.TempDetailsRepo;
import com.abdulrahman.exercise21.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@NoArgsConstructor
public class TempDetailsService {
    private final TempDetailsRepo TempDetailsRepo;
    private final CustomerRepo customerRepo;

    public List<TempDetails> getCustomer() {
        return TempDetailsRepo.findAll();
    }
    public void addCustomer(TempDetailsDTO cdDTO) {
        Customer customer = customerRepo.findCustomerById(cdDTO.getCustomer_id());
        if (customer == null) {
            throw new ApiException("No customer found! ");
        }
            TempDetails TempDetails = new TempDetails(null,"Abdulrahman",25,"Male",customer);
        TempDetailsRepo.save(TempDetails);
    }
}
