package com.offcn.login.service;

import com.offcn.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User findUserByUname(String uname) {
        User user = new User();
        user.setUname("wei");
        user.setUpwd("123");
        if(uname.equals(user.getUname())){
            return user;
        }
        return null;
    }
}
