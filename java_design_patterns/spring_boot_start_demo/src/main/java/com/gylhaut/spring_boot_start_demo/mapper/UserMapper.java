package com.gylhaut.spring_boot_start_demo.mapper;

import com.gylhaut.spring_boot_start_demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> queryUserList();
}
