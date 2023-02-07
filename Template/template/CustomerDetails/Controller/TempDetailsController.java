package com.abdulrahman.exercise21.TempDetails.Controller;

import com.abdulrahman.exercise21.Customer.Model.Customer;
import com.abdulrahman.exercise21.TempDetails.DTO.TempDetailsDTO;
import com.abdulrahman.exercise21.TempDetails.Model.TempDetails;
import com.abdulrahman.exercise21.TempDetails.Service.TempDetailsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class TempDetailsController {
    private final TempDetailsService TempDetailsService;

    @GetMapping("/TempDetails")
    public List<TempDetails> readCustomer(){
        return TempDetailsService.getCustomer();
    }

    @PostMapping("/TempDetails")
    public ResponseEntity createCustomers(@RequestBody @Valid TempDetailsDTO TempDetails) {

        TempDetailsService.addCustomer(TempDetails);
        return ResponseEntity.status(200).body("Added");
    }
}
