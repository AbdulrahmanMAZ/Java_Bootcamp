package com.abdulrahman.store.MyUser;

import com.abdulrahman.store.Order.Order;
import com.abdulrahman.store.Order.OrderRepo;
import com.abdulrahman.store.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService {
    private final MyUserRepo myUserRepo;
    private final OrderRepo orderRepo;



    public List<MyUser> getMyUsers() {
        return myUserRepo.findAll();
    }

    public void addMyUser( MyUser user) {
        myUserRepo.save(user);
    }
    public void updateMyUser(MyUser newUser, Integer user_id) {
        MyUser user = myUserRepo.findMyUserById(user_id);

        if (user == null) {
            throw new ApiException("not found");
        }
        user.setId(user_id);
        user.setRole(newUser.getRole());
        user.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
        user.setUsername(newUser.getUsername());
        myUserRepo.save(user);


    }

    public void deleteMyUser( Integer user_id) {
        MyUser user = myUserRepo.findMyUserById(user_id);
        System.out.println("blog.getBody()hhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");

        if (user == null) {
            throw new ApiException("You are not authorized to delete this blog");
        }
        List<Order> user_Orders = orderRepo.findAllByMyUser_Id(user_id);
        for (Order userOrder : user_Orders) {
            orderRepo.delete(userOrder);
        }

        myUserRepo.delete(user);
    }

    // Get customer by ID
    public MyUser getMyUserById( Integer userId) {

            MyUser user_temp = myUserRepo.findMyUserById(userId);
            if (user_temp == null) {
                throw new ApiException("User not found");
            }

            return user_temp;

    }


}
