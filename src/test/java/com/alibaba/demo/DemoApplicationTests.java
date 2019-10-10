package com.alibaba.demo;

import com.alibaba.demo.entity.Student;
import com.alibaba.demo.persistence.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetStudent() {
        List<Student> list  = studentMapper.getStudent("小明");
        System.out.println(list.get(0));
    }

}
