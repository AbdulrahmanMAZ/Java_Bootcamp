package com.abdulrhamn.Assignment_18.service;

import com.abdulrhamn.Assignment_18.exception.ApiException;
import com.abdulrhamn.Assignment_18.model.User;

import com.abdulrhamn.Assignment_18.model.UserCredential;
import com.abdulrhamn.Assignment_18.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
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
    public void addUser(User user) {

        userRepo.save(user);
    }
    public boolean editUser(Integer id, User user) {
        User temp_User = userRepo.findById(id).get();
        if (temp_User == null) {
            return false;
        }
        if (!temp_User.getUserName().equals(user.getUserName())){
            temp_User.setUserName(user.getUserName());
        }
        if (!temp_User.getEmail().equals(user.getEmail())){
            temp_User.setEmail(user.getEmail());
        }
        temp_User.setName(user.getName());
        temp_User.setAge(user.getAge());
        temp_User.setRole(user.getRole());


    try{
        userRepo.save(temp_User);
        return true;

    }catch (DataIntegrityViolationException e){
        return false;
    }
    }
    public boolean deleteUser(Integer id) {
        User temp_User = userRepo.getById(id);
        if (temp_User == null) {
            return false;
        }
        userRepo.delete(temp_User);
        return true;
    }
    public boolean checkUserCredential(UserCredential userCredential) {
        User user = userRepo.findUserByUserNameAndPassword(userCredential.userName(), userCredential.password());
        if (user == null) {
            throw new ApiException("Wrong credential");
        }
        return true;
    }
    public User findUserByEmail(String email) {
        User user = userRepo.findUserByEmail(email);
        if (user == null) {
            throw new ApiException("Wrong credential");
        }
        return user;
    }
    public List<User> findAllRoles(String role) {
        List<User> users = userRepo.findAllByRole(role);
        if (users == null) {
            throw new ApiException("Enter a correct role");
        }
        return users;
    }
    public List<User> findAllAge(Integer age) {
        List<User> users = userRepo.findAllByAgeGreaterThanEqual(age);
        if (users == null) {
            throw new ApiException("Enter a correct role");
        }
        return users;
    }

}
