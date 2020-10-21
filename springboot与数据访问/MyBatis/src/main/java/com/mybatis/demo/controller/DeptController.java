package com.mybatis.demo.controller;

import com.mybatis.demo.bean.Department;
import com.mybatis.demo.bean.Employee;
import com.mybatis.demo.mapper.DepartmentMapper;
import com.mybatis.demo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//不返回页面，直接返回json数据
@RestController
public class DeptController {

//    不写service层，直接把DepartmentMapper注入
    @Autowired(required = false)
    DepartmentMapper departmentMapper;

    @Autowired(required = false)
    EmployeeMapper employeeMapper;

//    处理的映射
//    请求，根据地址栏写路径进入这个方法
    @GetMapping("/dept/{ID}")
    public Department getDepartment(@PathVariable("ID") Integer ID) {
        return departmentMapper.getDeptById(ID);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/depts")
    public List<Department> getDepts() {
        return departmentMapper.getDepts();
    }

    @GetMapping("/emp/{ID}")
    public Employee getEmp(@PathVariable("ID") Integer ID) {
        return employeeMapper.getEmpById(ID);
    }

    @GetMapping("/emps")
    public List<Employee> getEmps() {
        return employeeMapper.getEmps();
    }

}
