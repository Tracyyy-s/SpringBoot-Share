package com.example.demo_learn.controller;

import com.example.demo_learn.entity.Student;
import com.example.demo_learn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/{username}")
    @ResponseBody
    public Object hello(@PathVariable String username){
        return  "hi "+username;
    }

    @ResponseBody
    @RequestMapping(value = "/update")
//    等于 @RequestMapping("/update")
//将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上
    public  Object updateById(@RequestParam(value = "id")String id,@RequestParam(value = "name")String name){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        int updateCount = studentService.updateById(student);
        return updateCount;
    }
}
