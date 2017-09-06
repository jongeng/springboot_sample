package com.app.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * Created by ${jon} on 2017/8/2.
 */
@Configuration
@EnableCaching  // 启用缓存特性
public class RedisConfig1 extends CachingConfigurerSupport {

//    /**
//         * @title: RedisConfig
//         * @package: com.app.config
//         * @describe:  自定义key的生成规则
//         * @author: Jon
//         * @date: 2017/8/2 17:02
//         * @version: V1.0.0
//         **/
//        @Bean
//        public KeyGenerator keyGenerator() {
//            return new KeyGenerator() {
//                @Override
//                public Object generate(Object target, Method method, Object... params) {
//                    //格式化缓存key字符串
//                    StringBuilder sb = new StringBuilder();
//                    //追加类名
//                    sb.append(target.getClass().getName());
//                    //追加方法名
//                    sb.append(method.getName());
//                    //遍历参数并追加
//                    for (Object obj : params) {
//                        sb.append(obj.toString());
//                    }
//                    System.out.println("调用Redis缓存key:"+sb.toString());
//                    return sb.toString();
//                }
//            };
//        }
//
//
//        /**
//         * @title: RedisConfig
//         * @package: com.app.config
//         * @describe:  自定义缓存管理器的属性
//         * @author: Jon
//         * @date: 2017/8/2 17:02
//         * @version: V1.0.0
//         **/
//        @SuppressWarnings("rawtypes")
//        @Bean
//        public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
//            RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
//            //设置缓存过期时间
//            rcm.setDefaultExpiration(2*60*60);//秒
//            return rcm;
//        }
//
//        @Bean
//        public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//            StringRedisTemplate template = new StringRedisTemplate(factory);
//            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//            ObjectMapper om = new ObjectMapper();
//            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//            jackson2JsonRedisSerializer.setObjectMapper(om);
//            template.setValueSerializer(jackson2JsonRedisSerializer);
//            template.afterPropertiesSet();
//            return template;


//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//        redisTemplate.setConnectionFactory(factory);
//        RedisSerializer<String> redisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;
//        redisTemplate.setKeySerializer(redisSerializer);
//        redisTemplate.setHashKeySerializer(redisSerializer);
//        return  redisTemplate;
//    }
}