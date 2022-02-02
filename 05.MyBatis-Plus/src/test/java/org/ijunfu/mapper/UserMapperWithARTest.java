package org.ijunfu.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.ijunfu.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/01 14:13
 * @version 1.0.0
 *
 */

@Slf4j
@SpringBootTest
@Rollback
class UserMapperWithARTest {

    @Test
    void insert() {
        User user = new User();
        user.setId(System.currentTimeMillis());
        user.setName("Demo");
        user.setManagerId(2l);

        boolean flag = user.insert();

        log.info("{}", flag);
    }

    @Test
    void selectById() {
        User user = new User();

        User u = user.selectById(2l);

        log.info("{} {}", user == u, u);
    }

    @Test
    void selectById2() {
        User user = new User();
        user.setId(2l);

        User u = user.selectById(user);
        log.info("{} {}", user == u, u);
    }

    @Test
    void updateById() {
        User user = new User();
        user.setId(2l);
        user.setEmail("admin@ijunfu.com");

        boolean flag = user.updateById();

        User u = user.selectById(user);

        log.info("{} {}", flag, u);
    }

    @Test
    void deleteById() {
        User user = new User();
        List<User> all = user.selectAll();
        log.info("{}", all);

        boolean ret = user.deleteById(1643788030697l);

        log.info("{}", ret);
    }
}