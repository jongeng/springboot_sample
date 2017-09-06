package com.app.utils;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @title: Timer
* @package: com.app.utils
* @describe: 定时器相关的类
* @author: Jon
* @date: 2017/8/15 14:17
* @version: V1.0.0
**/


@Configuration          //证明这个类是一个配置文件
//@EnableScheduling   //打开quartz定时器总开关
public class Timer {

    private static final Logger logger = LoggerFactory.getLogger(Timer.class);

    /**
     * describe: 定时器测试类
     * 1. 需在application 中 添加@EnableScheduling注解，打开定时任务的开关/或者在Timer类中添加注解
     * 2. 在方法中 添加 @Scheduled(cron = "0/2 * * * * *") 定时执行的cron表达式
     *
     *  <task:scheduled> 的参数说明如下：
     * initial-delay :  表示第一次运行前需要延迟的时间，单位是毫秒
     * fixed-delay  :  表示从上一个任务完成到下一个任务开始的间隔, 单位是毫秒
     * fixed-rate    :  表示从上一个任务开始到下一个任务开始的间隔, 单位是毫秒（如果某次任务开始时上次任务还没有结束，那么在上次任务执行完成时，当前任务会立即执行
     *
     * cron="0 0/1 * * * ?"      每一分钟执行一次
     * cron = "0/5 * * * * *"    每5秒钟执行一次
     * cron = "0 0 12 * * ?"	 	     每天中午12点触发
     *
     *
     **/
    //@Scheduled(cron = "0/5 * * * * *")
    public void timer(){
        //获取当前时间
        LocalDateTime localDateTime =LocalDateTime.now();
        logger.info("每5秒执行一次,开始...");
        System.out.println(localDateTime);
        logger.info("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        ZonedDateTime zonedDateTime=ZonedDateTime.now();
        System.out.println(zonedDateTime);
        logger.info("当前时间为:" + zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        logger.info("每5秒执行一次,结束...");
    }



    // @Scheduled(fixedRate=20000)
      public void testTasks() {
        logger.info("每20秒执行一次,开始...");
        //statusTask.healthCheck();
        logger.info("每20秒执行一次,结束...");
    }

    //@Scheduled(fixedDelay=5000)
    public void doSome() {
        System.out.println("每5秒钟执行一次。");
    }


    //@Scheduled(initialDelay=1000, fixedRate=5000)
    public void doSomething() {
        // something that should execute periodically
    }

}
