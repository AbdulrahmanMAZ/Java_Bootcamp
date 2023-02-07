package com.abdulrahman.exercise21.CustomerDetails.Repository;

import com.abdulrahman.exercise21.Customer.Model.Customer;
import com.abdulrahman.exercise21.CustomerDetails.Model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails,Integer> {

}
