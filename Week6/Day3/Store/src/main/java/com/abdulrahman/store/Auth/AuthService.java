package com.abdulrahman.store.Auth;

import com.abdulrahman.store.MyUser.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepo authRepo;

    public void register(MyUser myUserr){
        myUserr.setRole("USER");
        String hashedPassword = new BCryptPasswordEncoder().encode(myUserr.getPassword());
        myUserr.setPassword(hashedPassword);
        authRepo.save(myUserr);
    }

}
