package org.ijunfu.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/04 18:56
 * @version 1.0.0
 *
 */
@Slf4j
@SpringBootTest
class TeacherMapperForInjectorTest {

    @Autowired
    TeacherMapper teacherMapper;

    @Test
    void deleteAll(){
        int count = teacherMapper.deleteAll();

        log.info("delete num: {}", count);
    }

}