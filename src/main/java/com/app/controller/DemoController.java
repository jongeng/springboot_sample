package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import com.app.entity.User;
import com.app.service.UserRedisService;
import com.app.utils.JedisUtil;
import com.app.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.util.SafeEncoder;


@RestController
public class DemoController {

    @Autowired
    private UserRedisService userRedisService;


    @RequestMapping({"/","/index"})
    public String index(){
        return "Hello Spring Boot";
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testException() {
        throw new RuntimeException("this is a test exception");
    }





    @RequestMapping("/addUsers")
    public String addUsers(){
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setId(i);
            user.setAge(i);
            user.setUsername("张三" + i);
            users.add(user);
        }
        userRedisService.saveUsers(users);
        return "添加完成。";
    }

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userRedisService.findAll();
    }

    @RequestMapping(value="/findUser/{id}",method={RequestMethod.GET})
    public User findUser(@PathVariable String id){
        return userRedisService.findById(id);
    }

    /**
    * @title: DemoController
    * @package: com.app.controller
    * @describe: 使用jedis进行数据的增删改查
    * @author: Jon
    * @date: 2017/8/8 18:47
    * @version: V1.0.0
    **/
    @RequestMapping("/insertUser")
    public String JedisInsertObject() {
        User p = new User();
        p.setId(21);
        p.setAge(22);
        p.setRole("21");
        p.setPassword("123456");
        p.setUsername("测试");
        userRedisService.saveUser(p);
        return "添加完成。";
   }

}
