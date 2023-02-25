package com.abdulrahman.final_Project.Location.service;

import com.abdulrahman.final_Project.Location.model.Location;
import com.abdulrahman.final_Project.Location.repository.LocationRepo;
import com.abdulrahman.final_Project.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    final private LocationRepo locationRepo;

    public List<Location> getLocations(){
        return locationRepo.findAll();
    }
    public void addLocation(Location location){
        locationRepo.save(location);

    }
    public void editLocation(Integer id,Location location){
        Location temp = locationRepo.findLocationById(id);
        if (temp == null) {
            throw new ApiException("Not found");
        }
        temp.setArea(location.getArea());
        temp.setStreet(location.getStreet());
//        temp.setStore(location.getStore());
        locationRepo.save(temp);

    }
//    public void deleteLocation(Integer id){
//        Location temp = locationRepo.findLocationById(id);
//        if (temp == null) {
//            throw new ApiException("Not found");
//        }
//        Location teacherAddress = teacherAddressRepo.findTeacherAddressById(id);
//        if (teacherAddress == null) {
//            throw new ApiException("No address found for the teacher");
//        }
//        locationRepo.delete(temp);
//
//    }

}
