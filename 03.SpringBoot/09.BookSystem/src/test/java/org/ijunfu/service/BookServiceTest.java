package org.ijunfu.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          图书测试类
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/16 23:43
 * @version 1.0.0
 *
 */
@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void count() {
        boolean ret = bookService.delete(0);

        assertEquals(false, ret);
    }
}