package org.ijunfu.mapper;

import org.ijunfu.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

@SpringBootTest
@Rollback
class UserMapperTest {

    @Autowired
    UserMapper mapper;

    @Test
    void test() {
        Long count = mapper.selectCount(null);

        assertEquals(2, count);
    }

    @Test
    void query() {
        List<User> list = mapper.selectList(null);

        assertEquals(2, list.size());

        System.out.println(list);
    }

    @Test
    void save() {
        User user = new User();
        user.setId(System.currentTimeMillis());
        user.setUsername("test");
        user.setManagerId(2l);

        user.setExt1("ext 1...");
        User.setExt2("ext 2...");

        int ret = mapper.insert(user);
        assertEquals(1, ret);

        List<User> userList = mapper.selectList(null);
        assertEquals(3, userList.size());
    }

    @Test
    void update() {
        User user = mapper.selectById(2);
        System.out.println(user);

        user.setUsername("admin");
        int ret = mapper.updateById(user);
        assertEquals(1, ret);

        mapper.selectById(2);
    }

    @Test
    void delete() {
        int ret = mapper.deleteById(2);
        assertEquals(1, ret);

        Long count = mapper.selectCount(null);
        assertEquals(1, count);

    }
}