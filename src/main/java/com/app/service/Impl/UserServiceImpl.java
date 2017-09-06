package com.app.service.Impl;

import com.app.entity.User;
import com.app.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import com.app.service.UserService;

import javax.annotation.Resource;

/**
 * Created by ${jon} on 2017/7/31.
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public String userQuery(String Str) {
        userMapper.selectByPrimaryKey(new Integer(Str));
        return null;
    }

    @Override
    public User findByName(String name) {
        return userMapper.selectByUsername(name);
    }

     /*
     *随机添加值
     */
    public void test(){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykey4", "random1="+Math.random());
        System.out.println(valueOperations.get("mykey4"));
    }

    @Cacheable(value="usercache") //缓存,这里没有指定key.
    public User findById(Integer id) {
        System.out.println("进行数据库获取数据的....id="+id);
        return userMapper.selectByPrimaryKey(id);
    }

    /*
    *从缓存删除
    */
    @CacheEvict(value="usercache")
    public void deleteFromCache(Integer id) {
        System.out.println("RedisService.deleteFromCache(). 从缓存中删除.");
    }
}
