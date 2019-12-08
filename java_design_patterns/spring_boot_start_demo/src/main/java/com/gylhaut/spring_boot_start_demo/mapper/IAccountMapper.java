package com.gylhaut.spring_boot_start_demo.mapper;

import com.gylhaut.spring_boot_start_demo.domain.Account;
import com.gylhaut.spring_boot_start_demo.domain.AccountUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IAccountMapper {
    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
