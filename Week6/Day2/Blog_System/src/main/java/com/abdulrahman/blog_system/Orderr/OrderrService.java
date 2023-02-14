package com.abdulrahman.blog_system.Orderr;

import com.abdulrahman.blog_system.MyUser.MyUser;
import com.abdulrahman.blog_system.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderrService {
    private final OrderrRepo orderRepo;


    public List<Orderr> getOrderrs(MyUser myUserr) {
        return orderRepo.findAllByMyUser_Id(myUserr.getId());
    }

    public void addOrderr(MyUser myUserr, Orderr order) {

        order.setMyUser(myUserr);

        orderRepo.save(order);
    }
    public void updateOrderr(MyUser myUserr, Orderr order, Integer order_id) {
        Orderr order_temp = orderRepo.findOrderrById(order_id);

        if (order_temp == null) {
            throw new ApiException("not found");
        }
        MyUser myUserr_temp = order_temp.getMyUser();
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
        orderRepo.save(order_temp);

    }

    public void deleteOrderr(MyUser myUserr, Integer order_id) {
        Orderr order_temp = orderRepo.findOrderrById(order_id);

        if (order_temp == null) {
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

        orderRepo.delete(order_temp);
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
//        Blog order_temp = orderRepo.findOrderrByTitle(blog_title);
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
