package com.offcn.entity;

import java.io.Serializable;


/**
 * 用户表
 * @Author HLX
 * @Date 2018/7/3 11:40
 */

public class User implements Serializable{


    private String userId;

    private String uname;

    private String upwd;

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
