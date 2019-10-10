package com.alibaba.demo.web;

import com.alibaba.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HelloWorldController {

    @Autowired
    Pages pages;

    @RequestMapping("/hello")
    public String index() {
        return "forward:/";
    }
}