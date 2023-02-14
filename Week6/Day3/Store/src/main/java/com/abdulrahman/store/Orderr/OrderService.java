package com.abdulrahman.store.Orderr;

import com.abdulrahman.store.MyUser.MyUser;
import com.abdulrahman.store.Product.Product;
import com.abdulrahman.store.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;


    public List<Orderr> getOrders(MyUser myUserr) {
        return orderRepo.findAllByMyUser_Id(myUserr.getId());
    }

    public void addOrder(MyUser myUserr, Orderr userOrder) {

        Integer totalprice = 0;
        for (Product product : userOrder.getProducts()) {
            totalprice+=product.getPrice();
        }
        userOrder.setTotalPrice(totalprice);
        userOrder.setMyUser(myUserr);

        orderRepo.save(userOrder);
    }
    public void updateOrder(MyUser myUserr, Orderr userOrder, Integer order_id) {
        Orderr userOrder_temp = orderRepo.findOrderById(order_id);

        if (userOrder_temp == null) {
            throw new ApiException("not found");
        }
        MyUser myUserr_temp = userOrder_temp.getMyUser();
        if (myUserr_temp == null) {
            throw new ApiException("not found");
        }
        if (myUserr_temp.getId() != myUserr.getId()) {
            throw new ApiException("You are not authorized to edit this order");
        }
//
//        order_temp.setQuantity(order.getQuantity());
//        order_temp.setStatus(order.getStatus());
//        order_temp.setTotalPrice(order.getTotalPrice());
        orderRepo.save(userOrder_temp);

    }

    public void deleteOrder(MyUser myUserr, Integer order_id) {
        Orderr userOrder_temp = orderRepo.findOrderById(order_id);

        if (userOrder_temp == null) {
            throw new ApiException("not found");
        }
//        MyUser myUserr_temp = order_temp.getMyUser();
//        if (myUserr_temp == null) {
//            throw new ApiException("not found");
//        }
//
//        if (myUserr_temp.getId() != myUserr.getId()) {
//            throw new ApiException("You are not authorized to delete this blog");
//        }

        orderRepo.delete(userOrder_temp);
    }

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
