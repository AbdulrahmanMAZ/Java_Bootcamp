package com.abdulrahman.exercise_17.service;

import com.abdulrahman.exercise_17.model.Bootcamp;
import com.abdulrahman.exercise_17.repository.Repo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BootcampService {

    final Repo repo;
    public List<Bootcamp> getBootcamp() {
         List<Bootcamp> bootcamps = repo.findAll();

        return bootcamps;
    }
    public void addBootcamp(Bootcamp bootcamp) {

        repo.save(bootcamp);
    }
    public boolean editBootcamp(Integer id, Bootcamp bootcamp) {
        Bootcamp temp_Bootcamp = repo.findById(id).get();
        if (temp_Bootcamp == null) {
            return false;
        }
        temp_Bootcamp.setTitle(bootcamp.getTitle());
        temp_Bootcamp.setDescription(bootcamp.getDescription());
        repo.save(temp_Bootcamp);
        return true;
    }
    public boolean deleteBootcamp(Integer id) {
        Bootcamp temp_Bootcamp = repo.getById(id);
        if (temp_Bootcamp == null) {
            return false;
        }
        repo.delete(temp_Bootcamp);
        return true;
    }

}
