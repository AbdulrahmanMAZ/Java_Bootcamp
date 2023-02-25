package com.abdulrahman.final_Project.AdvisorDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor
public class AdvisorDetailsController {

    // ServiceInjection
    private final AdvisorDetailsService advisorDetailsService;

    // getter
    @GetMapping("/get_advisor_details")
    public List<AdvisorDetails> getStores(){
        return advisorDetailsService.getAdvisorDetails();
    }
    @PostMapping("/add_advisor_details")

    public ResponseEntity addStores( @RequestBody AdvisorDetails _advisor_details){
                advisorDetailsService.addStore(_advisor_details);
                return ResponseEntity.status(200).body("Success");

    }
    @PutMapping("/edit_advisor_details/{id}")
    public ResponseEntity updateStores(@PathVariable Integer id, @RequestBody AdvisorDetails _advisor_details){
        advisorDetailsService.editStore(id,_advisor_details);
        return ResponseEntity.status(200).body("Updated");

    }
    @DeleteMapping("/delete_advisor_details/{id}")
    public ResponseEntity updateStores(@PathVariable Integer id){
        advisorDetailsService.deleteStore(id);
        return ResponseEntity.status(200).body("Updated");

    }


}
