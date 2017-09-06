package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 *
 * thymeleaf 模板测试
 *
 * Created by ${jon} on 2017/8/16.
 */
@Controller
public class TemplatesController {

    /*
    * 使用thymeleaf模板
    * 返回Map
    *
    */
    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String,Object> map){
        map.put("hello","from TemplatesController.helloHtml");
        return "helloHtml";
    }

     /*
     * 使用thymeleaf模板
     * 返回Model
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        return "hello";
    }

    /**
     *
     * 使用freemarker模板
     * 返回Map
     */

    @RequestMapping("/helloFtl")
    public String helloFtl(Map<String,Object> map){
        map.put("hello","from TemplatesController.helloFtl");
        return "helloFtl";
    }
}
