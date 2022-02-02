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

@Slf4j
@SpringBootTest
@Rollback
class UserPagMapperTest {

    @Autowired
    UserMapper mapper;

    @Test
    void page(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        Page<User> page = new Page<>(1, 2);

        mapper.selectPage(page, queryWrapper);
        log.info("{} {} {}", page.getPages(), page.getSize(), page.getTotal());

        List<User> userList = page.getRecords();
        log.info("{}", userList);
    }

    @Test
    void page2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        Page<User> page = new Page<>(1, 2);

        mapper.selectByPage(page, queryWrapper);

        log.info("{} {} {}", page.getPages(), page.getSize(), page.getTotal());

        List<User> userList = page.getRecords();
        log.info("{}", userList);
    }
}