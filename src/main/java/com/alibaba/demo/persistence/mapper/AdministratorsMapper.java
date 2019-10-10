package com.alibaba.demo.persistence.mapper;

import com.alibaba.demo.entity.Administrators;
import org.apache.ibatis.annotations.Param;

public interface AdministratorsMapper {

    Administrators login(
            @Param("account") String account,
            @Param("password") String password);
}
