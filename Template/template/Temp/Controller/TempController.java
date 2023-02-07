package com.abdulrahman.exercise21.Temp.Controller;

import com.abdulrahman.exercise21.Temp.Model.Temp;
import com.abdulrahman.exercise21.Temp.Service.TempService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor
public class TempController {
    private final TempService TempService;
    @GetMapping("/Temp")
    public List<Temp> readTemp(){
        return TempService.getTemp();
    }

    @PostMapping("/Temp")
    public ResponseEntity createTemps(@RequestBody @Valid Temp Temp) {

        TempService.addTemp(Temp);
        return ResponseEntity.status(200).body("Added");
    }
//    @PutMapping("/Temp/{id}")
//    public ResponseEntity updateMovies(@PathVariable String id, @RequestBody @Valid Director Temp, Errors errors){
//
//        TempService.editDirector(id,Temp);
//        return ResponseEntity.status(200).body("Movie modified!");
//
//    }
//    @DeleteMapping("/Temp/{id}")
//    public ResponseEntity deleteMovies(@PathVariable String id){
//
//        TempService.deleteDirector(id);
//        return ResponseEntity.status(200).body("Movie deleted!");
//
//    }
}
