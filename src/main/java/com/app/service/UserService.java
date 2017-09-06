package com.app.service;


import com.app.entity.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

public interface UserService {

    public String userQuery(String Str);


    public User findById(Integer id);

    public User findByName(String name);

    public void deleteFromCache(Integer id);

    void test();
}
