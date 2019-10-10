package com.alibaba.demo.persistence.mapper;

import com.alibaba.demo.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StudentMapper {

    List<Student> getStudent(@Param("name") String name);
    Student selectStudent(@Param("telephone") String telephone);
    Student deleteStudent(@Param("telephone") String telephone);
    Student modifyStudent(@Param("Student") Student student);
    void addStudent(@Param("Student") Student student);
}
