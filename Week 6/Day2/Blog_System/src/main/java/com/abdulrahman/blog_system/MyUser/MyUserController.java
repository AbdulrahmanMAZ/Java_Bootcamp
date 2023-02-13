package com.abdulrahman.blog_system.MyUser;


import com.abdulrahman.blog_system.MyUser.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class MyUserController {
    private final MyUserService myUserService;

    @GetMapping
    public List<MyUser> getMyUsers(){
        return myUserService.getMyUsers();
    }
    @PostMapping
    public ResponseEntity addMyUser(@AuthenticationPrincipal MyUser myUser, @RequestBody MyUser user){
        myUserService.addMyUser(myUser,user);

        return ResponseEntity.status(HttpStatus.OK).body("Done! ");
    }
    @PutMapping("/{blog_id}")
    public ResponseEntity updateMyUser(@AuthenticationPrincipal MyUser myUser, @RequestBody MyUser user,@PathVariable Integer blog_id){
        myUserService.updateMyUser(myUser,user,blog_id);
        return ResponseEntity.status(HttpStatus.OK).body("Updated! ");
    }
    @DeleteMapping("/{blog_id}")
    public ResponseEntity deleteMyUser(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer user_id){
        myUserService.deleteMyUser(myUser,user_id);

        return ResponseEntity.status(HttpStatus.OK).body("Deleted! ");
    }
}
