package com.abdulrahman.blog_system.MyUser;

import com.abdulrahman.blog_system.Blog.Blog;
import com.abdulrahman.blog_system.Blog.BlogRepo;
import com.abdulrahman.blog_system.MyUser.MyUser;
import com.abdulrahman.blog_system.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MyUserService {
    private final MyUserRepo myUserRepo;
    private final BlogRepo blogRepo;



    public List<MyUser> getMyUsers() {
        return myUserRepo.findAll();
    }

    public void addMyUser( MyUser user) {
        myUserRepo.save(user);
    }
    public void updateMyUser( MyUser newUser,Integer user_id) {
        MyUser user = myUserRepo.findMyUserById(user_id);

        if (user == null) {
            throw new ApiException("not found");
        }
        user.setId(user_id);
        user.setRole(newUser.getRole());
        user.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
        user.setUsername(newUser.getUsername());
        myUserRepo.save(user);


    }

    public void deleteMyUser( Integer user_id) {
        MyUser user = myUserRepo.findMyUserById(user_id);
        System.out.println("blog.getBody()hhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");

        if (user == null) {
            throw new ApiException("You are not authorized to delete this blog");
        }
        List<Blog> user_blogs = blogRepo.findAllByMyUser_Id(user_id);
        for (Blog blog: user_blogs) {
            System.out.println(blog.getBody());
            blogRepo.delete(blog);
        }

        myUserRepo.delete(user);
    }

}
