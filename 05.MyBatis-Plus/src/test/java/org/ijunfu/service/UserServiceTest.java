package org.ijunfu.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.ijunfu.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/02 16:22
 * @version 1.0.0
 *
 */
@Slf4j
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void select() {

        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getName, "root"));

        log.info("{}", user);
    }

    @Test
    void page() {
        Page<User> page = new Page<>(0, 10);

        userService.page(page);

        log.info("{} {} {}", page.getCurrent(), page.getPages(), page.getSize());
    }

    @Test
    void batch() {
        List<Long> list = Arrays.asList(1488785389968486402l, 1488785889300365313l, 1488786243291267073l);

        boolean ret = userService.removeBatchByIds(list);

        assertEquals(true, ret);
    }
}