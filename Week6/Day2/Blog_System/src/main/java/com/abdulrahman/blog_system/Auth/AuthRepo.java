package com.abdulrahman.blog_system.Auth;

import com.abdulrahman.blog_system.MyUser.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<MyUser,Integer> {
    MyUser findMyUserByUsername(String username);
}
