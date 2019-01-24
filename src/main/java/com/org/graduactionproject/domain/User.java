package com.org.graduactionproject.domain;

public class User {
    private Integer userId;
    private String password;
    private String userName;
    private String identity;
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
    @Override
    public String toString(){
        return "userId: " + userId + "username：" + userName + ", identity：" + identity;
    }

}
