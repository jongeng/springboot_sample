package com.app.service.Impl;

import java.util.List;

import com.app.entity.User;
import com.app.service.UserRedisService;
import com.app.utils.JedisUtil;
import com.app.utils.RedisUtil;
import com.app.utils.SerializeUtil;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.util.SafeEncoder;


@Service
public class UserRedisServiceImpl extends RedisUtil<User> implements UserRedisService {

    private static final String USER_REDIS_KEY = "USER_REDIS_KEY";

    @Override
    public String getRedisKey() {
        return USER_REDIS_KEY;
    }

    @Override
    public void saveUsers(List<User> users) {
        for (User user : users) {
            put(user.getId().toString(), user, -1);
        }
    }

    @Override
    public void saveUser(User user) {
        Jedis jedis=JedisUtil.getInstance().getJedis();
        JedisUtil jedisUtil= JedisUtil.getInstance();
        JedisUtil.Strings strings = jedisUtil.new Strings();
        //strings.set("JedisUser", SerializeUtil.serialize(user));

        //jedis.set(SafeEncoder.encode("object1"),SerializeUtil.serialize(p));
        //byte[] personBy = jedis.get(SafeEncoder.encode("JedisUser"));
        //User p1 = (User) SerializeUtil.unserialize(personBy);
        //jedis.set("key_value", "test");
        System.out.println("取出的key_value值为：=============="+jedis.get("key_value"));
        //System.out.println("取出的用户名的值为：=============="+p1.getUsername());
        jedis.rename("key_value","keys");
        System.out.println("更改的keys值为：=============="+jedis.get("keys"));
        jedis.del("keys");
        System.out.println("删除的keys值为：=============="+jedis.get("keys"));

    }

    @Override
    public List<User> findAll() {
        return getAll();
    }

    public User findById(String id) {
        return get(id);
    }

    public void deleteById(String id) {
        remove(id);
    }

}
