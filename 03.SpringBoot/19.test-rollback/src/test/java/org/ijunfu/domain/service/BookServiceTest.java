package org.ijunfu.domain.service;

import org.ijunfu.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/22 13:01
 * @version 1.0.0
 *
 */
@SpringBootTest
@Transactional
@Rollback(true)
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void test() {
        List<Book> list = bookService.list();

        assertEquals(22, list.size());
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("springboot");
        book.setAuthor("test");
        book.setPublisher("test");
        book.setRemarks("test");

        bookService.save(book);

        bookService.list();

    }
}