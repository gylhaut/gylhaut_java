package com.gylhaut.spring_boot_start_demo;

import com.gylhaut.spring_boot_start_demo.domain.Account;
import com.gylhaut.spring_boot_start_demo.domain.AccountUser;
import com.gylhaut.spring_boot_start_demo.mapper.IAccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStartDemoApplication.class)
public class AccountTest {
    @Autowired
    private IAccountMapper accountMapper;

    @Test
    public void testFindAllAccount(){
        List<AccountUser> aus = accountMapper.findAllAccount();
        aus.stream().forEach(au ->System.out.println(au));
    }

    @Test
    public void TestfindAll(){
        List<Account> acounts = accountMapper.findAll();
        for (Account acount : acounts) {
            System.out.println(acount);
            System.out.println(acount.getUser2());
        }
    }
}
