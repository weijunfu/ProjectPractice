package org.ijunfu.mapper;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.ijunfu.entity.Account;
import org.ijunfu.entity.Role;
import org.ijunfu.utils.StringHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/05 14:37
 * @version 1.0.0
 *
 */

@Slf4j
@SpringBootTest
class AccountMapperTest {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    RoleMapper roleMapper;

    @Test
    void save(){
        Role role = roleMapper.selectById(1l);

        log.info("{}", role);

        Account account = new Account();
        account.setUsername("root");
        account.setEmail("ijunfu@qq.com");

        String salt = StringHelper.random(32);
        System.out.println(salt);
        account.setSalt(salt);

        String password = "123456";
        String encode = StringHelper.encode(password, salt);
        System.out.println(encode);
        account.setPassword(encode);

        account.setRoleId(1l);

        System.out.println(account);

        int ret = accountMapper.insert(account);
        assertEquals(1, ret);

    }

    @Test
    void random() {
        for(int i=0; i<10; i++) {
            String str = RandomUtil.randomString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789", 32);
            System.out.println(str);
        }
    }

    @Test
    void randomSalt() {
        for(int i=0; i<10; i++) {
            String str = StringHelper.random(32);
            System.out.println(str);
        }
    }

    @Test
    void encode() {
        String password = "weizg123";

        String salt = StringHelper.random(32);
        System.out.println(salt);

        String encode = StringHelper.encode(password, salt);
        System.out.println(encode);
    }

    @Test
    void myPage() {
        Page<Account> page = new Page<>(1, 10);
        accountMapper.myPage(page, Wrappers.emptyWrapper());

    }
}