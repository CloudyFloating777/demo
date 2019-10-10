package com.alibaba.demo.web;

import com.alibaba.demo.entity.Administrators;
import com.alibaba.demo.entity.Student;
import com.alibaba.demo.persistence.mapper.AdministratorsMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    Pages pages;

    @Autowired
    AdministratorsMapper administratorsMapper;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "index";
    }

}
