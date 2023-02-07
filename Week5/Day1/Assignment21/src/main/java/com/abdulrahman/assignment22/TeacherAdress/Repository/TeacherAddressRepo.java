package com.abdulrahman.assignment22.TeacherAdress.Repository;

import com.abdulrahman.assignment22.TeacherAdress.Model.TeacherAddress;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherAddressRepo extends JpaRepository<TeacherAddress,Integer> {
    TeacherAddress findTeacherAddressById(Integer id);

}
