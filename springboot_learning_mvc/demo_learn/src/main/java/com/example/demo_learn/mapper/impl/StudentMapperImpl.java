package com.example.demo_learn.mapper.impl;

import com.example.demo_learn.entity.Student;
import com.example.demo_learn.mapper.StudentMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentMapperImpl implements StudentMapper {
    private static Map<String, Student> students = null;
    static {
        students = new HashMap<String, Student>();
        students.put("1001", new Student("1001", "AA"));
        students.put("1002", new Student("1002", "BB"));
        students.put("1003", new Student("1003", "CC"));
        students.put("1004", new Student("1004", "DD"));
        students.put("1005", new Student("1005", "EE"));
    }
    @Override
    public int updateById(Student student) {
        if(students.containsKey(student.getId())){
            students.put(student.getId(),student);
            System.out.println(students);
            return 1;
        }
        else
            return 0;
    }
}
