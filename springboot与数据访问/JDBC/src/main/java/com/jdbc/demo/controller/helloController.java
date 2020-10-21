package com.jdbc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

@Controller
public class helloController {

    @Autowired
//  SpringBoot原生的jdbc操作数据库的类
    JdbcTemplate jdbcTemplate;

//    返回JSON数据
    @ResponseBody
//    请求
    @GetMapping("/query")
    public List<Map<String, Object>> map() {
//        query返回结果是List，且List中元素必须是自定义的bean
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
        return list;
    }
}