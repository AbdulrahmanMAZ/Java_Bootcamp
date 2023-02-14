package com.abdulrahman.store.Orderr;

import com.abdulrahman.store.MyUser.MyUser;
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
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<Orderr> getOrders(@AuthenticationPrincipal MyUser myUserr){
        return orderService.getOrders(myUserr);
    }
    @PostMapping
    public ResponseEntity addOrder(@AuthenticationPrincipal MyUser myUserr, @Valid @RequestBody Orderr userOrder){
        orderService.addOrder(myUserr, userOrder);

        return ResponseEntity.status(HttpStatus.OK).body("Done! ");
    }
    @PutMapping("/{order_id}")
    public ResponseEntity updateOrder(@AuthenticationPrincipal MyUser myUserr, @Valid @RequestBody Orderr userOrder, @PathVariable Integer order_id){
        orderService.updateOrder(myUserr, userOrder,order_id);
        return ResponseEntity.status(HttpStatus.OK).body("Updated! ");
    }
    @DeleteMapping("/{order_id}")
    public ResponseEntity deleteOrder(@AuthenticationPrincipal MyUser myUserr, @PathVariable Integer order_id){
        orderService.deleteOrder(myUserr,order_id);

        return ResponseEntity.status(HttpStatus.OK).body("Deleted! ");
    }

//    @GetMapping("/id/{order_id}")
//    public Order getOrderById(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer order_id){
//        return orderService.getOrderById(myUser,order_id);
//    }
//
//    @GetMapping("/title/{order_title}")
//    public Order getOrderByTitle(@AuthenticationPrincipal MyUser myUser,@PathVariable String blog_title){
//        return blogService.getBlogByTitle(myUser,blog_title);
//    }
}
