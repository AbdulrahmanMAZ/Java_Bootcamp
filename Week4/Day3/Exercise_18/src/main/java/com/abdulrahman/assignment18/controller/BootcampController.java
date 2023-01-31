package com.abdulrahman.assignment18.controller;

import com.abdulrahman.assignment18.model.Bootcamp;
import com.abdulrahman.assignment18.service.BootcampService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
@RequiredArgsConstructor
public class BootcampController {
    final BootcampService bootcampService;
    @GetMapping("/bootcamps")
    public List<Bootcamp> readBootcamps(){
        return bootcampService.getBootcamp();
    }
    @GetMapping("/bootcamps/{title}")
    public Bootcamp readBootcampsByTitle(@PathVariable String title){
        return bootcampService.getBootcampByTitle(title);
    }

    @PostMapping("/bootcamps")
    public ResponseEntity createBootcamps(@RequestBody @Valid Bootcamp bootcamp, Errors errors){
//        if (errors.hasErrors()) {
//            return ResponseEntity.status(400).body("WROOOOONG");
//        }
        bootcampService.addBootcamp(bootcamp);
        return ResponseEntity.status(200).body("Bootcamp added!");

    }
    @PutMapping("/bootcamps/{id}")
    public ResponseEntity updateBootcamps(@PathVariable Integer id, @RequestBody @Valid Bootcamp bootcamp, Errors errors){
//        if (errors.hasErrors()||bootcampService.editBootcamp(id,bootcamp) == false) {
//            return ResponseEntity.status(400).body("WROOOOONG");
//        }

        bootcampService.editBootcamp(id,bootcamp);
        return ResponseEntity.status(200).body("Bootcamp modified!");

    }
    @DeleteMapping("/bootcamps/{id}")
    public ResponseEntity deleteBootcamps(@PathVariable Integer id){
        if (bootcampService.deleteBootcamp(id) == false) {
            return ResponseEntity.status(400).body("WROOOOONG");
        }

        bootcampService.deleteBootcamp(id);
        return ResponseEntity.status(200).body("Bootcamp deleted!");

    }

}
