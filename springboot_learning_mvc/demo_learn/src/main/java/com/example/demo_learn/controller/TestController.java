package com.example.demo_learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@Conntroller ->@Component(将此类标记为Spring容器中的一个Bean)
//@RestController
public class TestController {
//    地址外一定是双引号
    @RequestMapping("/say")
    @ResponseBody
    public String say(){
        return "HelloWorld";
    }
}
