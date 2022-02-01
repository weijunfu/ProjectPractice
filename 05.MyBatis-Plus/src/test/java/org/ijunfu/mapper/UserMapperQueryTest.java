package org.ijunfu.mapper;

import org.ijunfu.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
class UserMapperQueryTest {

    @Autowired
    UserMapper mapper;

    @Test
    void selectById() {
        User user = mapper.selectById(2);
        System.out.println(user);
    }
    
    @Test
    void selectBatchIds() {
        List<Integer> ids = Arrays.asList(1, 2);
        mapper.selectBatchIds(ids);
    }

    @Test
    void selectByMap() {
        Map<String, Object> columnsMap = new HashMap<>();
        columnsMap.put("id", 1);
        columnsMap.put("name", "root");
        List<User> users = mapper.selectByMap(columnsMap);
        System.out.println(users);
    }
}