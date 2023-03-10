package com.abdulrahman.assignment23.TeacherAdress.Service;


import com.abdulrahman.assignment23.Teacher.Model.Teacher;
import com.abdulrahman.assignment23.Teacher.Repository.TeacherRepo;
import com.abdulrahman.assignment23.TeacherAdress.DTO.TeacherAddressDTO;
import com.abdulrahman.assignment23.TeacherAdress.Model.TeacherAddress;
import com.abdulrahman.assignment23.TeacherAdress.Repository.TeacherAddressRepo;
import com.abdulrahman.assignment23.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@NoArgsConstructor
public class TeacherAddressService {
    private final TeacherAddressRepo teacherAddressRepo;
    private final TeacherRepo teacherRepo;

    public List<TeacherAddress> getTeacherAddress() {
        return teacherAddressRepo.findAll();
    }
    public void addTeacherAddress(TeacherAddressDTO cdDTO) {
        Teacher teacher = teacherRepo.findTeacherById(cdDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("No teacher found! ");
        }
            TeacherAddress teacherAddress = new TeacherAddress(null,cdDTO.getArea(),cdDTO.getStreet(), cdDTO.getBuildingNumber(), teacher);
//        teacher.setTeacherAddress(teacherAddress);
//        teacherRepo.save(teacher);
        teacherAddressRepo.save(teacherAddress);
    }
    public void editTeacherAddress(Integer id, TeacherAddressDTO TA_DTO) {
        Teacher teacher = teacherRepo.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("No teacher found! ");
        }
        TeacherAddress teacherAddress = teacherAddressRepo.findTeacherAddressById(id);
        if (teacherAddress == null) {
            throw new ApiException("No address found for the teacher");
        }
        teacherAddress.setArea(TA_DTO.getArea());
        teacherAddress.setStreet(TA_DTO.getStreet());
        teacherAddress.setBuildingNumber(TA_DTO.getBuildingNumber());

//        TeacherAddress teacherAddress = new TeacherAddress(null,cdDTO.getArea(),cdDTO.getStreet(), cdDTO.getBuildingNumber(), teacher);
        teacherAddressRepo.save(teacherAddress);
    }
    public void deleteTeacherAddress(Integer id) {
        Teacher teacher = teacherRepo.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("No teacher found! ");
        }
        TeacherAddress teacherAddress = teacherAddressRepo.findTeacherAddressById(id);
        if (teacherAddress == null) {
            throw new ApiException("No address found for the teacher");
        }

        teacher.setTeacherAddress(null);
        teacherRepo.save(teacher);
        teacherAddressRepo.delete(teacherAddress);
    }
}
