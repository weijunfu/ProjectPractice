package org.ijunfu.mapper;

import lombok.extern.slf4j.Slf4j;
import org.ijunfu.entity.Role;
import org.junit.jupiter.api.Test;
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
 * @date 2022/02/05 14:39
 * @version 1.0.0
 *
 */

@Slf4j
@SpringBootTest
class RoleMapperTest {

    @Autowired
    RoleMapper roleMapper;

    @Test
    void all() {
        List<Role> roles = roleMapper.selectList(null);

        log.info("{}", roles);
    }
}