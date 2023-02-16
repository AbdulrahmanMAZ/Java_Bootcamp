package com.abdulrahman.store.Order;

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

    // Get all customer orders
    @GetMapping
    public List<Order> getOrders(@AuthenticationPrincipal MyUser myUser){
        return orderService.getMyOrders();
    }
    @PostMapping("/{product_id}")
    public ResponseEntity addOrder(@AuthenticationPrincipal MyUser myUserr, @Valid @RequestBody Order userOrder,@PathVariable Integer product_id){
        orderService.addOrder(myUserr, userOrder,product_id);

        return ResponseEntity.status(HttpStatus.OK).body("Done! ");
    }
    @PutMapping("/{order_id}")
    public ResponseEntity updateOrder(@AuthenticationPrincipal MyUser myUserr, @Valid @RequestBody Order userOrder, @PathVariable Integer order_id){
        orderService.updateOrder(myUserr, userOrder,order_id);
        return ResponseEntity.status(HttpStatus.OK).body("Updated! ");
    }
    @DeleteMapping("/{order_id}")
    public ResponseEntity deleteOrder(@AuthenticationPrincipal MyUser myUserr, @PathVariable Integer order_id){
        orderService.deleteOrder(myUserr,order_id);

        return ResponseEntity.status(HttpStatus.OK).body("Deleted! ");
    }
    @PutMapping("/admin/{order_id}/change_status/{newStatus}")
    public ResponseEntity addProduct(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer order_id,@PathVariable String newStatus){
        orderService.changeStatus(myUser,order_id,newStatus);
        return ResponseEntity.status(HttpStatus.OK).body("Status changed to: "+newStatus);
    }
    @GetMapping("/{order_id}")
    public Order getOrderById(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer order_id){
        return orderService.getOrder(myUser,order_id);
    }

//    @PutMapping("/{order_id}/add_to_order/{product_id}")
//    public ResponseEntity addProduct(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer order_id,@PathVariable Integer product_id){
//        orderService.addProductToOrder(myUser,order_id,product_id);
//        return ResponseEntity.status(HttpStatus.OK).body("Change to! ");
//    }

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
