package com.app.service;

import com.app.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ${jon} on 2017/8/8.
 */
public interface UserRedisService {


    public String getRedisKey();

    public void saveUsers(List<User> users);

    public void saveUser(User users);

    public List<User> findAll();

    public User findById(String id);

    public void deleteById(String id);

    }
