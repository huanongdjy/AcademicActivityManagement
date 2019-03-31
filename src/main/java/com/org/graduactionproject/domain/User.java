package com.org.graduactionproject.domain;

public class User {
    private String password;
    private String username;
    private Identity identity;
    private String mailbox;
    private Integer college_id;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public Integer getCollege_id() {
        return college_id;
    }

    public void setCollege_id(Integer college_id) {
        this.college_id = college_id;
    }

    @Override
    public String toString() {
        return "User{" +
                ", password='" + password + '\'' +
                ", userName='" + username + '\'' +
                ", identity=" + identity +
                ", mailbox='" + mailbox + '\'' +
                '}';
    }
}
