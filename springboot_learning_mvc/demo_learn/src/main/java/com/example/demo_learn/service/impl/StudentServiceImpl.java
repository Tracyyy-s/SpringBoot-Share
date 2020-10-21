package com.example.demo_learn.service.impl;

import com.example.demo_learn.entity.Student;
import com.example.demo_learn.mapper.StudentMapper;
import com.example.demo_learn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired StudentMapper studentMapper;
    @Override
    public int updateById(Student student) {
        int updateCount = studentMapper.updateById(student);
        System.out.println("更新结果："+updateCount);
        return updateCount;
    }
}
