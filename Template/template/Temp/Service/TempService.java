package com.abdulrahman.exercise21.Temp.Service;

import com.abdulrahman.exercise21.Temp.Model.Temp;
import com.abdulrahman.exercise21.Temp.Repository.TempRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class TempService {

    private final TempRepo TempRepo;
    public List<Temp> getTemp() {
       return TempRepo.findAll();
    }
    public void addTemp(Temp Temp) {

        TempRepo.save(Temp);
    }
}
