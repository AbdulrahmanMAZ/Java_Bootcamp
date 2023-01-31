package com.abdulrahman.assignment18.service;

import com.abdulrahman.assignment18.exception.ApiException;
import com.abdulrahman.assignment18.model.Bootcamp;
import com.abdulrahman.assignment18.repository.Repo;
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
    public Bootcamp getBootcampByTitle(String title){
        Bootcamp bootcamp = repo.findBootcampByTitleContainingIgnoreCase(title);
        if (bootcamp == null){
            throw new ApiException("Not found!");

        }        return bootcamp;
    }
    public void addBootcamp(Bootcamp bootcamp) {
        try {
            repo.save(bootcamp);

        } catch (ApiException e){
            throw new ApiException("wrong credentials");
        }
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
