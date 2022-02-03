package org.ijunfu.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.ijunfu.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/02 17:20
 * @version 1.0.0
 *
 */
@Slf4j
@SpringBootTest
class TeacherMapperWithOptimisticLockerTest {

    @Autowired
    TeacherMapper teacherMapper;

    @Test
    void all() {
        List<Teacher> list = teacherMapper.selectList(null);
        log.info("{}", list.size());
    }
    
    @Test
    void update() {
        Teacher teacher = new Teacher();
        teacher.setId("1489179862380625921");
        teacher.setName("hello");

        Teacher t = teacherMapper.selectById("1489179862380625921");

        teacher.setVersion(t.getVersion());

        teacherMapper.updateById(teacher);

    }

    @Test
    void insert() {
        Teacher teacher = new Teacher();
        teacher.setName("World");
        teacher.setManagerId("5");

        teacherMapper.insert(teacher);
    }
}