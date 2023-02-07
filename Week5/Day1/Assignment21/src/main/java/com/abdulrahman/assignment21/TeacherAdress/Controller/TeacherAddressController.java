package com.abdulrahman.assignment21.TeacherAdress.Controller;

import com.abdulrahman.assignment21.Teacher.Model.Teacher;
import com.abdulrahman.assignment21.TeacherAdress.DTO.TeacherAddressDTO;
import com.abdulrahman.assignment21.TeacherAdress.Model.TeacherAddress;
import com.abdulrahman.assignment21.TeacherAdress.Service.TeacherAddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class TeacherAddressController {
    private final TeacherAddressService teacherAddressService;

    @GetMapping("/teacher_address")
    public List<TeacherAddress> readTeacheraddress(){
        return teacherAddressService.getTeacherAddress();
    }

    @PostMapping("/teacher_address")
    public ResponseEntity createCustomers(@RequestBody @Valid TeacherAddressDTO teacherAddress) {

        teacherAddressService.addTeacherAddress(teacherAddress);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/teacher_address/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid TeacherAddressDTO TA_DTO){
        teacherAddressService.editTeacherAddress(id,TA_DTO);
        return ResponseEntity.status(200).body("Updated");
    }
    @DeleteMapping("/teacher_address/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){

        teacherAddressService.deleteTeacherAddress(id);
        return ResponseEntity.status(200).body("Teacher address was deleted!");

    }



}
