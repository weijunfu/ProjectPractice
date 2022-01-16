package org.ijunfu.dao;

import org.apache.ibatis.logging.Log;
import org.ijunfu.domain.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/16 13:11
 * @version 1.0.0
 *
 */
@SpringBootTest
class UserDaoTest {

    final static Logger log = LoggerFactory.getLogger(UserDaoTest.class);

    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        List<User> userList = userDao.selectList(null);

        log.info("{}: {}", userList.size(), userList);
    }

}