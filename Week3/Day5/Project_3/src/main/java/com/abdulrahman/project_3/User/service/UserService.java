package com.abdulrahman.project_3.User.service;

import com.abdulrahman.project_3.Merchant.module.Merchant;
import com.abdulrahman.project_3.Merchant.service.MerchantService;
import com.abdulrahman.project_3.MerchantStock.module.MerchantStock;
import com.abdulrahman.project_3.MerchantStock.service.MerchantStockService;
import com.abdulrahman.project_3.Product.module.Product;
import com.abdulrahman.project_3.Product.service.ProductService;
import com.abdulrahman.project_3.User.module.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {
    ArrayList<User> users = new ArrayList<>();
    final ProductService products;
    final MerchantService merchants;
    final MerchantStockService stockService;

    public ArrayList<User> getUser() {
        return users;
    }

    public boolean addUser(User user) {
        users.add(user);
        return true;
    }

    public boolean editUser(String userID,User user) {
        for (int i = 0 ; i < users.size();i++) {
            if (users.get(i).getId().equals(userID)){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }
    public boolean deleteUser(int userID) {
        for (int i = 0 ; i < users.size();i++) {
            if (users.get(i).getId().equals(userID)){
                users.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(String productID,String merchantID, int stock){
        Product product = null;
        Merchant merchant = null;

        for (Product p: products.getProducts()) {
            if (p.getId().equals(productID)){
                product = p;
            }
        }
        if (product == null)return false;
//        System.out.println("product found");


        for (Merchant m: merchants.getMerchant()) {
            if (m.getId().equals(merchantID)){
                merchant = m;
            }
        }
        if (merchant == null){return false;}
//        System.out.println("merchant found");
        Random o = new Random();
        Random s = new Random();

        char oo = (char)(o.nextInt(26) + 'a');
        char ss = (char)(o.nextInt(26) + 'a');

        stockService.addMerchantStock(new MerchantStock( ss+oo+String.valueOf((int)(Math.random()*10)) ,productID,merchantID,stock));

        return true;
    }

    public boolean checkData(String userID, String productID, String merchantID) {
        boolean validUser = false;
        User user = null;
        boolean validProduct = false;
        Product product= null;
        boolean validMerchant = false;
        Merchant merchant;
        boolean merchantHasProduct = false;
        MerchantStock merchantStock;
        boolean userHasMoney = false;


        //check user existing
        for (User u: users) {
            if (u.getId().equals(userID)){
                validUser = true;
                user = u;
            }
        }
        if (validUser ==false) return false;
        //check Product existing
        for (Product p: products.getProducts()) {
            if (p.getId().equals(productID)){
                validProduct = true;
                product = p;
            }
        }
        if (validProduct ==false) return false;
        //check Merchant existing
        for (Merchant m: merchants.getMerchant()) {
            if (m.getId().equals(merchantID)){
                validMerchant = true;
                merchant = m;
            }
        }
        if (validMerchant ==false) return false;


        //check if the merchant has the product in his stockService && reduce the stockService if exists.
        for (MerchantStock s: stockService.getMerchantStock()) {
            if (s.getMerchantID().equals(merchantID) && s.getProductID().equals(productID)){
                merchantHasProduct = true;
                //Reduce the stockService by one if the user has money
                int currentStockValue = s.getStock();

                if (Double.parseDouble( user.getBalance()) >=Double.parseDouble( product.getPrice()) && currentStockValue > 0 ){
                    userHasMoney = true;
                    MerchantStock temp = s;
                    temp.setStock(currentStockValue -1);
                    stockService.editMerchantStock(s.getId(),temp);
                    double currentUserBalance = Double.parseDouble( user.getBalance());
                    double productPrice = Double.parseDouble( product.getPrice());
                    user.setBalance(String.valueOf((currentUserBalance- productPrice)));

                }else {
                    return false;
                }




            }
        }


        return (validUser&&validMerchant&&validProduct&&merchantHasProduct&&userHasMoney);
    }

//    public boolean checkData(Payment payment) {
//    }
}
