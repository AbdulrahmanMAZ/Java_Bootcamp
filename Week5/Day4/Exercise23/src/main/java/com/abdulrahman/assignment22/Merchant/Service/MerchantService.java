package com.abdulrahman.assignment22.Merchant.Service;



import com.abdulrahman.assignment22.Merchant.Model.Merchant;
import com.abdulrahman.assignment22.Merchant.Repository.MerchantRepo;
import com.abdulrahman.assignment22.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class MerchantService {

    private final MerchantRepo teacherRepo;

    public  void editTeacher(int id, Merchant merchant) {
        Merchant merchant_temp = teacherRepo.findTeacherById(id);
        if (merchant_temp == null) {
            throw new ApiException("not found");
        }
        merchant_temp.setEmail(merchant.getEmail() == "" ? merchant_temp.getEmail(): merchant.getEmail());
        merchant_temp.setName(merchant.getName() == "" ? merchant_temp.getName() : merchant.getName());

        teacherRepo.save(merchant_temp);
    }

    public List<Merchant> getTeacher() {
       return teacherRepo.findAll();
    }
    public void addTeacher(Merchant Merchant) {

        teacherRepo.save(Merchant);
    }
    public void deleteTeacher(Integer id) {
        Merchant merchant = teacherRepo.findTeacherById(id);
        if (merchant == null){
            throw new ApiException("not found");
        }
        teacherRepo.delete(merchant);
    }

    public Merchant getTeacherById(Integer id) {
        Merchant merchant = teacherRepo.findTeacherById(id);
        if (merchant == null) {
            throw new ApiException("Not found");
        }
        return merchant;
    }
}
