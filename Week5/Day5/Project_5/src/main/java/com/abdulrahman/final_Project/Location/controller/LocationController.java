package com.abdulrahman.final_Project.Location.controller;

import com.abdulrahman.final_Project.Location.model.Location;
import com.abdulrahman.final_Project.Location.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor
public class LocationController {

    // ServiceInjection
    private final LocationService locationService;

    // getter
    @GetMapping("/getlocation")
    public List<Location> getBooks(){
        return locationService.getLocations();
    }
    @PostMapping("/addlocation")

    public ResponseEntity addBooks( @RequestBody Location location){
                locationService.addLocation(location);
                return ResponseEntity.status(200).body("Success");

    }
    @PutMapping("/editlocation")
    public ResponseEntity updateBooks(@PathVariable Integer id, @RequestBody Location location){
        locationService.editLocation(id,location);
        return ResponseEntity.status(200).body("Updated");

    }
    @DeleteMapping("/deletelocation")
    public ResponseEntity updateBooks(@PathVariable Integer id){
        locationService.deleteLocation(id);
        return ResponseEntity.status(200).body("Updated");

    }
}
