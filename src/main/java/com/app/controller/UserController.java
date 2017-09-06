package com.app.controller;

import com.app.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.util.Objects;

/**
* @title: UserController
* @package: controller
* @describe:
* @author: Jon
* @date: 2017/7/31 16:53
* @version: V1.0.0
**/
@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

//    @Resource
//    private RedisTestService redisService;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

/**
* @title: UserController
* @package: com.app.controller
* @describe: redis user对象测试类
* @author: Jon
* @date: 2017/8/2 16:41
* @version: V1.0.0
**/
    @RequestMapping("/redis/write/object")
    public Object test(Integer id,String username, Integer age, String password, String role){
        System.out.println("向Redis写入object对象");
      //  return redisService.getUser(id, username,age,password,role);
        return null;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        User loaded = userService.findById(1);
        System.out.println("loaded="+loaded);
        return "ok";
    }




    @RequestMapping("/delete/redisInfo")
    @ResponseBody
    public String delete(Integer id){
        userService.deleteFromCache(id);
        System.out.println("根据key值删除Redis数据");
        return"ok";
    }

    @RequestMapping("/redis/write/string")
    @ResponseBody
    public String test1(){
        userService.test();
        System.out.println("向Redis写入String字符串");
        return"ok";
    }
}
