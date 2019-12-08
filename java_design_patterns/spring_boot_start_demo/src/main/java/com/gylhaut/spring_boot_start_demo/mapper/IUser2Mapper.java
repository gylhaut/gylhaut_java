package com.gylhaut.spring_boot_start_demo.mapper;

import com.gylhaut.spring_boot_start_demo.domain.User2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IUser2Mapper {

    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    List<User2> findAll();




}
