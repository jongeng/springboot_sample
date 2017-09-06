package com.app.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

public class User implements Serializable {

    private static final long serialVersionUID = 5796449175854008240L;

    private Integer id;

    private String username;

    private Integer age;

    private String password;

    private String role;

    private String salt;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

//    public User(Integer id, String username, Integer age, String password, String role) {
//        this.id = id;
//        this.username = username;
//        this.age = age;
//        this.password = password;
//        this.role = role;
//    }

//    @Override
//    public String toString() {
//        return "User [id=" + id + ", username=" + username + ", age=" + age +",password=" + password +",role=" + role + "]";
//    }
}