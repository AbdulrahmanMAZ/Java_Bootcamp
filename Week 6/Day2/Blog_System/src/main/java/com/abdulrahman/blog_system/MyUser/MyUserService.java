package com.abdulrahman.blog_system.MyUser;

import com.abdulrahman.blog_system.MyUser.MyUser;
import com.abdulrahman.blog_system.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService {
    private final MyUserRepo myUserRepo;


    public List<MyUser> getMyUsers() {
        return null;
    }

    public void addMyUser(MyUser myUser, MyUser blog) {

    }
    public void updateMyUser(MyUser myUser , MyUser newUser,Integer user_id) {
        MyUser user = myUserRepo.findMyUserById(user_id);

        if (user == null) {
            throw new ApiException("not found");
        }
        user.setPassword(newUser.getPassword());
        user.setUsername(newUser.getUsername());
        myUserRepo.save(user);



    }

    public void deleteMyUser(MyUser myUser, Integer blog_id) {
        MyUser user = myUserRepo.findMyUserById(blog_id);


        if (user == null) {
            throw new ApiException("You are not authorized to delete this blog");
        }

        myUserRepo.delete(user);
    }

}
