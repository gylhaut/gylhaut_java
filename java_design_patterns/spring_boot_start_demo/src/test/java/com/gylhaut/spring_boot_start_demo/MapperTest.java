package com.gylhaut.spring_boot_start_demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gylhaut.spring_boot_start_demo.domain.Account;
import com.gylhaut.spring_boot_start_demo.domain.AccountUser;
import com.gylhaut.spring_boot_start_demo.domain.QueryVo;
import com.gylhaut.spring_boot_start_demo.domain.User;
import com.gylhaut.spring_boot_start_demo.mapper.IAccountMapper;
import com.gylhaut.spring_boot_start_demo.mapper.UserMapper;
import com.gylhaut.spring_boot_start_demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStartDemoApplication.class)
public class MapperTest {

    private static final Logger logger = LoggerFactory.getLogger(MapperTest.class);
    @Autowired
    private UserMapper userMapper;



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        List<User> users = userMapper.queryUserList();
        System.out.println(users);

    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("wangwu");
        user.setPassword("1234344");
        user.setName("王五");
        System.out.println("保存操作之前：" + user);
        //执行保存
        userMapper.saveUser(user);
        System.out.println("保存操作之后："+ user);

    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(4L);
        user.setUsername("mybastis update user");
        user.setPassword("7889000");
        user.setName("数据库");
        //执行更新操作
        userMapper.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete(){
        //5.执行删除方法
        userMapper.deleteUser(4L);
    }

    /**
     * 测试查询一个操作
     */
    @Test
    public void testFindOne(){
        //5.执行查询一个方法
        User  user = userMapper.findById(3L);
        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName(){
        //5.执行查询一个方法
        List<User> users = userMapper.findByName("%zhang%");
//        List<User> users = userDao.findByName("王");
        for(User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal(){
        //5.执行查询一个方法
        int count = userMapper.findTotal();
        System.out.println(count);
    }


    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void testFindByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%zhang%");
        vo.setUser(user);
        //5.执行查询一个方法
        List<User> users = userMapper.findUserByVo(vo);
        for(User u : users){
            System.out.println(u);
        }
    }
    @Test
    public void testFindUserByCondition(){
        User user = new User();
        user.setUsername("lisi");
        user.setName("李四");
        //5.执行查询一个方法
        List<User> users = userMapper.findUserByCondition(user);
        logger.info("日志打印记录成功");
        for(User u : users){
            System.out.println(u);
        }
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


    @Test
    public void testFindInIds(){
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        vo.setIds(ids);
        //执行操作
        List<User> users = userMapper.findInIds(vo);
        users.stream().forEach(user ->System.out.println(user));
    }


}
