package com.abdulrahman.blog_system.Orderr;

import com.abdulrahman.blog_system.MyUser.MyUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderrController {
    private final OrderrService orderService;

    @GetMapping
    public List<Orderr> getOrderrs(@AuthenticationPrincipal MyUser myUserr){
        return orderService.getOrderrs(myUserr);
    }
    @PostMapping
    public ResponseEntity addOrderr(@AuthenticationPrincipal MyUser myUserr, @Valid @RequestBody Orderr order){
        orderService.addOrderr(myUserr,order);

        return ResponseEntity.status(HttpStatus.OK).body("Done! ");
    }
    @PutMapping("/{order_id}")
    public ResponseEntity updateOrderr(@AuthenticationPrincipal MyUser myUserr, @Valid @RequestBody Orderr order, @PathVariable Integer order_id){
        orderService.updateOrderr(myUserr,order,order_id);
        return ResponseEntity.status(HttpStatus.OK).body("Updated! ");
    }
    @DeleteMapping("/{order_id}")
    public ResponseEntity deleteOrderr(@AuthenticationPrincipal MyUser myUserr, @PathVariable Integer order_id){
        orderService.deleteOrderr(myUserr,order_id);

        return ResponseEntity.status(HttpStatus.OK).body("Deleted! ");
    }

//    @GetMapping("/id/{order_id}")
//    public Orderr getOrderrById(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer order_id){
//        return orderService.getOrderrById(myUser,order_id);
//    }
//
//    @GetMapping("/title/{order_title}")
//    public Orderr getOrderrByTitle(@AuthenticationPrincipal MyUser myUser,@PathVariable String blog_title){
//        return blogService.getBlogByTitle(myUser,blog_title);
//    }
}
