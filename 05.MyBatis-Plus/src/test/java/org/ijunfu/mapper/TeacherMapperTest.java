package org.ijunfu.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.ijunfu.entity.Teacher;
import org.ijunfu.entity.User;
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
 * @date 2022/02/02 17:20
 * @version 1.0.0
 *
 */
@Slf4j
@SpringBootTest
class TeacherMapperTest {

    @Autowired
    TeacherMapper teacherMapper;

    @Test
    void all() {
        List<Teacher> list = teacherMapper.selectList(null);
        log.info("{}", list.size());
    }
    
    @Test
    void delete() {
        List<Teacher> list = teacherMapper.selectList(null);
        log.info("{}", list.size());

        int ret = teacherMapper.deleteById(8);

        list = teacherMapper.selectList(null);
        log.info("{}", list.size());
    }

    @Test
    void select() {
        List<Teacher> list = teacherMapper.selectList(null);
        log.info("{}", list.size());
    }

    @Test
    void mySelect() {
        LambdaQueryWrapper<Teacher> lambdaQuery = Wrappers.<Teacher>lambdaQuery();
        lambdaQuery.eq(Teacher::getDeleted, 0);
        List<Teacher> list = teacherMapper.mySelectList(lambdaQuery);
        log.info("{}", list.size());
    }

    @Test
    void mySelect2() {
        List<Teacher> list = teacherMapper.mySelectList(Wrappers.emptyWrapper());
        log.info("{}", list.size());
    }

    @Test
    void mySelect3() {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "l");
        List<Teacher> list = teacherMapper.mySelectList(queryWrapper);
        log.info("{}", list.size());
    }
}