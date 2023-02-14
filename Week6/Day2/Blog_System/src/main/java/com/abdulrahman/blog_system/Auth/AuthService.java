package com.abdulrahman.blog_system.Auth;

import com.abdulrahman.blog_system.MyUser.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepo authRepo;

    public void register(MyUser myUser){
        myUser.setRole("USER");
        String hashedPassword = new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        authRepo.save(myUser);
    }

}
