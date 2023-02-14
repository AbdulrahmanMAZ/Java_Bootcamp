package com.abdulrahman.blog_system.MyUser;

import com.abdulrahman.blog_system.Blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser, Integer> {
     MyUser findMyUserById(Integer id);

}
