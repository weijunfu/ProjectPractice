package org.ijunfu.domain;

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
 * @date 2022/01/22 13:27
 * @version 1.0.0
 *
 */
@SpringBootTest
class BookCaseTest {

    @Autowired
    private BookCase bookCase;

    @Test
    void test() {
        System.out.println(bookCase);
    }
}