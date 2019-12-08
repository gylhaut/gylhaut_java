package com.gylhaut.spring_boot_start_demo;

import com.gylhaut.spring_boot_start_demo.domain.User2;
import com.gylhaut.spring_boot_start_demo.mapper.IUser2Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStartDemoApplication.class)
public class UserMapperTest {
    @Autowired
    private IUser2Mapper iUser2Mapper;

    @Test
    public void testFindAll(){
        List<User2> user2s =  iUser2Mapper.findAll();
        user2s.forEach(user -> System.out.println(user));
    }

}
