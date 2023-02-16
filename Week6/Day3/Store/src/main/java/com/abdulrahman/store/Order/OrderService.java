package com.abdulrahman.store.Order;

import com.abdulrahman.store.MyUser.MyUser;
import com.abdulrahman.store.Product.Product;
import com.abdulrahman.store.Product.ProductRepo;
import com.abdulrahman.store.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    // Get all customer orders
    public List<Order> getMyOrders() {
        return orderRepo.findAll();
    }

    // In Add order endpoint: calculate the total price , status by defalut new
    public void addOrder(MyUser myUserr, Order userOrder,Integer product_id) {
        Product product_temp = productRepo.findProductById(product_id);
        if (product_temp == null) {
            throw new ApiException("not found");
        }
        Integer totalPrice = product_temp.getPrice() * userOrder.getQuantity();


        userOrder.setTotalPrice(totalPrice);
        userOrder.setMyUser(myUserr);
        userOrder.setStatus("new");

        orderRepo.save(userOrder);
    }

    public void updateOrder(MyUser myUser, Order userOrder, Integer order_id) {
        Order userOrder_temp = orderRepo.findOrderById(order_id);

        if (userOrder_temp == null) {
            throw new ApiException("not found");
        }
        if (userOrder_temp.getStatus().equals("inProgress")||userOrder_temp.getStatus().equals("completed")) {
            throw new ApiException("The order is already on the way");
        }
        MyUser myUser_temp = userOrder_temp.getMyUser();
        if (myUser_temp == null) {
            throw new ApiException("not found");
        }
        if (myUser_temp.getId() != myUser.getId()) {
            throw new ApiException("You are not authorized to edit this order");
        }

        userOrder_temp.setQuantity(userOrder.getQuantity());
        orderRepo.save(userOrder_temp);

    }

    // In Delete endpoint, check order status if its in progress or complete throw an exception
    public void deleteOrder(MyUser myUser, Integer order_id) {
        Order userOrder_temp = orderRepo.findOrderById(order_id);

        if (userOrder_temp == null) {
            throw new ApiException("not found");
        }
        if (userOrder_temp.getStatus().equals("inProgress")||userOrder_temp.getStatus().equals("completed")) {
            throw new ApiException("The order is already on the way");
        }
        MyUser myUser_temp = userOrder_temp.getMyUser();
        if (myUser_temp == null) {
            throw new ApiException("not found");
        }
        if (myUser_temp.getId() != myUser.getId()) {
            throw new ApiException("You are not authorized to edit this order");
        }

        orderRepo.delete(userOrder_temp);
    }
    // Create endpoint that change order status(only admin can change it)
    public void changeStatus(MyUser myUser, Integer order_id, String newStatus) {
        Order userOrder_temp = orderRepo.findOrderById(order_id);

        if (userOrder_temp == null) {
            throw new ApiException("not found");
        }
        userOrder_temp.setStatus(newStatus);
        if(newStatus.equals("completed")){
            userOrder_temp.setDate_received(LocalDateTime.now());
        }
        orderRepo.save(userOrder_temp);
    }


    // Get order by Id
    public Order getOrder(MyUser myUser,Integer order_id) {
        Order userOrder_temp = orderRepo.findOrderById(order_id);
        if (userOrder_temp == null) {
            throw new ApiException("Order not found");
        }
        MyUser myUser_temp = userOrder_temp.getMyUser();
        if (myUser_temp == null) {
            throw new ApiException("not found");
        }

        if (myUser_temp.getId() != myUser.getId()) {
            throw new ApiException("You are not authorized to delete this blog");
        }
        return orderRepo.findOrderById(myUser.getId());
    }


//    public void addProductToOrder(MyUser myUser ,Integer order_id, Integer product_id) {
//        Product product_temp = productRepo.findProductById(product_id);
//        Order userOrder_temp = orderRepo.findOrderById(order_id);
//
//        if (userOrder_temp == null) {
//            throw new ApiException("not found");
//        }
//        if (product_temp == null) {
//            throw new ApiException("not found");
//        }
//        MyUser myUser_temp = userOrder_temp.getMyUser();
//        if (myUser_temp == null) {
//            throw new ApiException("not found");
//        }
//
//        if (myUser_temp.getId() != myUser.getId()) {
//            throw new ApiException("You are not authorized to delete this blog");
//        }
//
//        userOrder_temp.addProdct(product_temp);
//        product_temp.setUserOrder(userOrder_temp);
//        orderRepo.save(userOrder_temp);
//        productRepo.save(product_temp);
//    }
//    public Blog getBlogById(MyUser myUser,Integer blog_id) {
//        Blog order_temp = orderRepo.findBlogById(blog_id);
//
//        if (order_temp == null) {
//            throw new ApiException("not found");
//        }
//        MyUser myUser_temp = order_temp.getMyUser();
//        if (myUser_temp == null) {
//            throw new ApiException("not found");
//        }
//
//        if (myUser_temp.getId() != myUser.getId()) {
//            throw new ApiException("You are not authorized to delete this blog");
//        }
//        return order_temp;
//    }
//    public Blog getBlogByTitle(MyUser myUser,String blog_title) {
//        Blog order_temp = orderRepo.findOrderByTitle(blog_title);
//        if (order_temp == null) {
//            throw new ApiException("not found");
//        }
//        MyUser myUser_temp = order_temp.getMyUser();
//        if (myUser_temp == null) {
//            throw new ApiException("not found");
//        }
//
//        if (myUser_temp.getId() != myUser.getId()) {
//            throw new ApiException("You are not authorized to delete this blog");
//        }
//
//        return order_temp;
//    }

}
