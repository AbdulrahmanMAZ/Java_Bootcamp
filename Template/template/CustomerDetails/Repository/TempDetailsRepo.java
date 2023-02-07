package com.abdulrahman.exercise21.TempDetails.Repository;

import com.abdulrahman.exercise21.Customer.Model.Customer;
import com.abdulrahman.exercise21.TempDetails.Model.TempDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempDetailsRepo extends JpaRepository<TempDetails,Integer> {

}
