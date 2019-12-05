package com.gylhaut.spring_boot_start_demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gylhaut.spring_boot_start_demo.domain.User;
import com.gylhaut.spring_boot_start_demo.mapper.UserMapper;
import com.gylhaut.spring_boot_start_demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStartDemoApplication.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Test
    public void test(){
        List<User> users = userMapper.queryUserList();
        System.out.println(users);

    }

    @Test
    public void TestJpa(){
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }

    @Test
    public void testRedis() throws JsonProcessingException {
        //从redis 缓存中获取指定的数据
        String userListData = redisTemplate.boundValueOps("user.findAll").get();
        //如果redis中没有数据的话
        if (null == userListData){
            //查询数据库
            List<User> all = userRepository.findAll();
            //转换成json格式字符串
            ObjectMapper om = new ObjectMapper();
            userListData = om.writeValueAsString(all);
            //保存到redis
            redisTemplate.boundValueOps("user.findAll").set(userListData);
            System.out.println("=================从数据库获取数据==================");
        }else {
            System.out.println("====================从redis缓存中获取数据=========================");
        }
        System.out.println(userListData);

    }
}
