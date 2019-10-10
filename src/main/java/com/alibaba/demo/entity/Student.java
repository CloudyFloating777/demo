package com.alibaba.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class Student {

    private String name;

    private String age;

    private String telephone;

    private String email;

    public String getTelephone(){
        return telephone;
    }

}
