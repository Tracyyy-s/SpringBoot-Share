package com.mybatis.demo.mapper;

import com.mybatis.demo.bean.Department;
import org.apache.ibatis.annotations.*;
import java.util.List;

//告诉MyBatis这是一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where ID=#{ID}")
    Department getDeptById(Integer ID);

    @Select("select * from department")
    List<Department> getDepts();

    @Delete("delete from department where ID=#{ID}")
    int deleteDeptById(Integer ID);

    //    userGeneratedKeys:是否生成自动配置的组件
//    keyProperty:哪个属性是封装组件的
    @Options(useGeneratedKeys = true, keyProperty = "ID")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where ID=#{ID}")
    int updateDept(Department department);
}