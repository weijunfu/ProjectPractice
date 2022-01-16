package org.ijunfu.dao;

import org.ijunfu.domain.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/16 20:52
 * @version 1.0.0
 *
 */
@SpringBootTest
class UserDaoTest {

    final static Logger log = LoggerFactory.getLogger(UserDaoTest.class);

    @Autowired
    private UserDao userDao;

    @Test
    void getUserById() {
        User user = userDao.getUserById(1);

        log.info("-> {}", user);
    }
}