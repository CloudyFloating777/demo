package com.alibaba.demo.web;

import com.alibaba.demo.persistence.mapper.StudentMapper;
import com.alibaba.demo.entity.Student;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Pages {
    private int max = 5;
    private int pageNos;

    @Autowired
    private StudentMapper studentMapper;

    public Pages(){
        pageNos = 1;
    }

    public Pages(int i){
        pageNos = i;
    }


    public void setPageNos(int pageNos) {
        this.pageNos = pageNos;
    }

    public int getPageNos() {
        return pageNos;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public List<Student> getList(String name){
        List<Student> resultList ;

        //数据库查询,分页
        PageHelper.startPage(pageNos, max);
        resultList = studentMapper.getStudent(name.trim());

        return resultList;
    }
}