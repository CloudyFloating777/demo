package com.alibaba.demo.web;

import com.alibaba.demo.entity.Administrators;
import com.alibaba.demo.entity.Student;
import com.alibaba.demo.persistence.mapper.AdministratorsMapper;
import com.alibaba.demo.persistence.mapper.StudentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdministratorController {

    @Autowired
    Pages pages;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    AdministratorsMapper administratorsMapper;

    //登陆界面
    @RequestMapping(value = "/administratior", method = RequestMethod.GET)
    public String homePage(){
        return "hello";
    }

    //登陆
    @RequestMapping(value = "/administratior", method = RequestMethod.POST)
    public ModelAndView login(
            @RequestParam(value = "account", required = true) String account,
            @RequestParam(value = "password", required = true) String password){
        Administrators administrators = administratorsMapper.login(account, password);

        if (administrators != null){
            ModelAndView modelAndView = new ModelAndView("/administratior/administer");
            modelAndView.addObject("administratior", administrators);
            return  modelAndView;
        }
        return new ModelAndView("/administratior/fail");
    }

    //管理（显示登陆页面，有管理选项输入框）
    @RequestMapping(value = "/administratior/administer", method = RequestMethod.GET)
    public String administerPage(
            @Param("administratior") Administrators administrators){
        //待补全
        return "administer";
    }

    //管理(判断对学生进行CRUD的哪个操作)
    @RequestMapping(value = "/administratior/administer", method = RequestMethod.POST)
    public String administer(@Param("CRUD") String crud){
        if (crud == "c" || crud == "C")
            return "forward:/administratior/administer/c";
        else if (crud == "r" || crud == "R")
            return "forward:/administratior/administer/r";
        else if (crud == "u" || crud == "U")
            return "forward:/administratior/administer/u";
        else if (crud == "d" || crud == "U")
            return "forward:/administratior/administer/d";
        else
            return "fail";
    }

    //增
    @RequestMapping(value = "/administratior/administer/c", method = RequestMethod.GET)
    public String creatPage(){
        return "c";
    }

    @RequestMapping(value = "/administratior/administer/c", method = RequestMethod.POST)
    public String creat(@Param("Student")Student student){
        if (studentMapper.selectStudent(student.getTelephone()) == null) {
            studentMapper.addStudent(student);//加一些重复判断的逻辑
            return "success";
        }
        return "fail";
    }

    //删
    @RequestMapping(value = "/administratior/administer/d", method = RequestMethod.GET)
    public String deletePage(){
        return "d";
    }

    @RequestMapping(value = "/administratior/administer/d", method = RequestMethod.POST)
    public String delete(@Param("telephone") String telephone){
        if (studentMapper.selectStudent(telephone) != null) {//存在判断
            studentMapper.deleteStudent(telephone);
            return "success";
        }
        return "fail";
    }

    //改
    @RequestMapping(value = "/administratior/administer/u", method = RequestMethod.GET)
    public String updatePage(){
        return "u";
    }

    @RequestMapping(value = "/administratior/administer/u", method = RequestMethod.POST)
    public String update(@Param("student") Student student){
        studentMapper.modifyStudent(student);
        return "success";
    }

    //查
    @RequestMapping(value = "/administratior/administer/r", method = RequestMethod.GET)
    public String readPage(){
        return "r";
    }

    @RequestMapping(value = "/administratior/administer/r", method = RequestMethod.POST)
    public String read(@Param("telephone") String telephone){
        studentMapper.selectStudent(telephone);
        return "success";
    }
}
