package org.ijunfu.mapper;

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
 * @date 2022/01/16 21:33
 * @version 1.0.0
 *
 */
@SpringBootTest
class BookMapperTest {

    final static Logger log = LoggerFactory.getLogger(BookMapperTest.class);

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void count() {
        Integer count = bookMapper.selectCount(null);

        log.info("{}{}", "总图书数量：", count);

        assertEquals(0, count);
    }
}