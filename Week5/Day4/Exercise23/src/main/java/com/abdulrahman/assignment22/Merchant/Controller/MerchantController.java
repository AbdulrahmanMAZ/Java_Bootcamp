package com.abdulrahman.assignment22.Merchant.Controller;


import com.abdulrahman.assignment22.Merchant.Model.Merchant;
import com.abdulrahman.assignment22.Merchant.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;
    @GetMapping("/merchant")
    public List<Merchant> readTeacher(){
        return merchantService.getTeacher();
    }

    @PostMapping("/merchant")
    public ResponseEntity createTeachers(@RequestBody @Valid Merchant Merchant) {

        merchantService.addTeacher(Merchant);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/merchant/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id, @RequestBody @Valid Merchant merchant){
        merchantService.editTeacher(id, merchant);
        return ResponseEntity.status(200).body("Updated");
    }
    @DeleteMapping("/merchant/{id}")
    public ResponseEntity deleteMovies(@PathVariable Integer id){

        merchantService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher and address were deleted!");

    }


    // GET TEACHER INFO BY THE ID
    @GetMapping("/merchant/{id}")
    public Merchant getTeacherById(@PathVariable Integer id){
        return merchantService.getTeacherById(id);
    }
}
