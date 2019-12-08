package com.gylhaut.spring_boot_start_demo.mapper;

import com.gylhaut.spring_boot_start_demo.domain.QueryVo;
import com.gylhaut.spring_boot_start_demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有
     * @return
     */
     List<User> queryUserList();

    /**
     * 保存用户
     * @param user
     */
     void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
     void updateUser(User user);

    /**
     * 根据id
     * @param id
     */

     void deleteUser(Long id);

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Long userId);

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数条件
     * @param user 查询的条件,有可能有用户名，有可能有性别，也有可能有地址，还可能都有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据id集合查询用户
     * @param vo
     * @return
     */
    List<User> findInIds(QueryVo vo);



}
