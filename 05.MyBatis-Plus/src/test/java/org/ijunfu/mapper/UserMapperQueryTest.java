package org.ijunfu.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
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

    @Test
    void selectListByQueryMapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper
                .like("name", "o")
                .lt("age", 30);

        List<User> userList = mapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    void selectListByLambdaQueryMapper() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .like(User::getName, "o")
                .lt(User::getAge, 30);
        List<User> userList = mapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    void formatDate() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .apply("PARSEDATETIME(create_time, 'yyyy-mm-dd') = {0}", "2022-02-01");
        List<User> userList = mapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    void between(){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.between(User::getAge, 18, 30);
        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    void in() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(User::getAge, 18, 20, 28);
        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    void customColumns() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(User::getName, User::getEmail);
        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    void condition() {
        String name = "o";
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(User::getName, User::getEmail)
                .like(StringUtils.isNotBlank(name), User::getName, name);
        List<User> userList = mapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }
    
    @Test
    void allEq() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "admin");

        queryWrapper.allEq(map);

        mapper.selectList(queryWrapper);
    }

    @Test
    void object() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        User user = new User();
        user.setName("pro");
        user.setAge(Byte.parseByte("20"));

        queryWrapper.setEntity(user);

        mapper.selectList(queryWrapper);
    }

    @Test
    void custom() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("name", "o");

        List<User> list = mapper.selectCustom(queryWrapper);
        System.out.println(list);

    }
}