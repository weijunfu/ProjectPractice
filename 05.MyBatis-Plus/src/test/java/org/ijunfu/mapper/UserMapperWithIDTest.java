package org.ijunfu.mapper;

import lombok.extern.slf4j.Slf4j;
import org.ijunfu.entity.User;
import org.junit.jupiter.api.Test;
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
class UserMapperWithIDTest {

    @Test
    void selectAll() {
        User user = new User();
        List<User> userList = user.selectAll();
        log.info("{}", userList);
    }

    @Test
    void insert() {
        User user = new User();
        user.setName("Demo03");
        user.setManagerId(5l);

        boolean flag = user.insert();

        log.info("{}", flag);
    }
}