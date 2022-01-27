package org.ijunfu.service;

import org.ijunfu.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/26 20:44
 * @version 1.0.0
 *
 */
@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    void count() {
        long count = bookService.count(null);
        assertEquals(0, count);
    }

    @Test
    void save() {
        Book book = new Book();
        book.setName("SpringBoot");
        book.setAuthor("ijunfu");
        book.setPublishTime(new Date());
        book.setPublisher("**出版社");
        book.setRemarks("测试数据");

        boolean ret = bookService.save(book);

        assertEquals(true, ret);
    }

}