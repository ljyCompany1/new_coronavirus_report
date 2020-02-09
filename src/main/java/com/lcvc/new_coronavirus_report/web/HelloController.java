package com.lcvc.new_coronavirus_report.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello(){
        //默认跳转页面是是templates路径下；如果要跳转到static目录，则需要用redirect
        return "hello";
    }
}
