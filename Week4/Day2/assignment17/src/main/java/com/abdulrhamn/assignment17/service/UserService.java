package com.abdulrhamn.assignment17.service;

import com.abdulrhamn.assignment17.model.User;

import com.abdulrhamn.assignment17.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    final UserRepo userRepo;
    public List<User> getUser() {
         List<User> users = userRepo.findAll();

        return users;
    }
    public void addUser(User bootcamp) {

        userRepo.save(bootcamp);
    }
    public boolean editUser(Integer id, User bootcamp) {
        User temp_User = userRepo.findById(id).get();
        if (temp_User == null) {
            return false;
        }
        temp_User.setName(bootcamp.getName());
        temp_User.setAge(bootcamp.getAge());
        temp_User.setRole(bootcamp.getRole());
        temp_User.setEmail(bootcamp.getEmail());
        temp_User.setUserName(bootcamp.getUserName());

        userRepo.save(temp_User);
        return true;
    }
    public boolean deleteUser(Integer id) {
        User temp_User = userRepo.getById(id);
        if (temp_User == null) {
            return false;
        }
        userRepo.delete(temp_User);
        return true;
    }

}
