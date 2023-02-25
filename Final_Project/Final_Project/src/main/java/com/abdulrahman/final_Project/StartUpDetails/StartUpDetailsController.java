package com.abdulrahman.final_Project.StartUpDetails;

import com.abdulrahman.final_Project.Appointments.Appointments;
import com.abdulrahman.final_Project.DTO.LocationDTO;
import com.abdulrahman.final_Project.Start_up.StartUp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor
public class StartUpDetailsController {

    // ServiceInjection
    private final StartUpDetailsService startUpDetailsService;

    // getter
    @GetMapping("/getstartUpDetails")
    public List<StartUpDetails> getStartUpDetailss(){
        return startUpDetailsService.getStartUpDetails();
    }
    @PostMapping("/addstartUpDetails")

    public ResponseEntity addStartUpDetails( @RequestBody StartUpDetails startUpDetails){
                startUpDetailsService.addStartUpDetails(startUpDetails);
                return ResponseEntity.status(200).body("Success");

    }
    @PutMapping("/editstartUpDetails/{id}")
    public ResponseEntity updateStartUpDetailss(@PathVariable Integer id, @RequestBody StartUpDetails startUpDetails){
        startUpDetailsService.editStartUpDetails(id,startUpDetails);
        return ResponseEntity.status(200).body("Updated");

    }
    @DeleteMapping("/deletestartUpDetails/{id}")
    public ResponseEntity updateStartUpDetailss(@PathVariable Integer id){
        startUpDetailsService.deleteStartUpDetails(id);
        return ResponseEntity.status(200).body("Updated");

    }


}
