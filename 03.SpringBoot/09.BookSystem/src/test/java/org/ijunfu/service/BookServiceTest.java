package org.ijunfu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ijunfu.domain.Book;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    static Logger log = LoggerFactory.getLogger(BookServiceTest.class);

    @Autowired
    private BookService bookService;

    @Test
    void getPageBook() {

        IPage<Book> pageBook = new Page<>(1, 10);
        bookService.page(pageBook);

        assertEquals(2, pageBook.getTotal());
        assertEquals(1, pageBook.getRecords().size());

    }

    @Test
    void getBookById() {
        Book book = bookService.getById(2);

        assertEquals(2, book.getId());
        log.info("{}", book);
    }

    @Test
    void addBook() {
        Book book = new Book();
        book.setId(3);
        book.setName("疯狂Java讲义（第5版）");
        book.setAuthor("李刚");
        book.setPublisher("电子工业出版社");
        book.setRemarks("渗透Java编程思想，《向上生长》九边|北大信科教授齐荐，李刚作品行销几十万册，成为海峡两岸读者之选，赠送20+小时视频、源代码、课件、面试题");

        boolean ret = bookService.save(book);
        assertEquals(true, ret);
    }

    @Test
    void updateBookById() {
        Book book = new Book();
        book.setId(2);
        book.setName("疯狂Java讲义（第5版）");
        book.setAuthor("李刚");
        book.setPublisher("电子工业出版社");
        boolean ret = bookService.updateById(book);

        assertEquals(true, ret);

        Book b = bookService.getById(2);

        assertEquals("疯狂Java讲义（第5版）", b.getName());
    }

    @Test
    void deleteBookById() {
        boolean ret = bookService.removeById(3);

        assertEquals(true, ret);
    }
}