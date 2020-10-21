package com.mybatis.demo.mapper;

import com.mybatis.demo.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

//@Mapper
public interface EmployeeMapper {

    Employee getEmpById(Integer ID);
    void insertEmp(Employee employee);
    List<Employee> getEmps();
}
