package com.alibaba.demo.web;


import com.alibaba.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    public Pages pages;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public List<Student> showStudent(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "pageNos", required = true) String pageNos,
            @RequestParam(value = "pageMax", required = true) String pageMax){
        if (pageNos != null){
            pages.setPageNos(Integer.parseInt(pageNos));
        }
        if (pageMax != null){
            pages.setMax(Integer.parseInt(pageMax));
        }
        return pages.getList(name);
    }
}
