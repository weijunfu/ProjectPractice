package org.ijunfu.dao;

import org.ijunfu.domain.Book;
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
 * @date 2022/01/23 00:29
 * @version 1.0.0
 *
 */
@SpringBootTest
class BookDAOTest {

    @Autowired
    BookDAO bookDAO;

    @Test
    void queryAll() {
        List<Book> books = bookDAO.queryAll();
        System.out.println(books);
        assertEquals(22, books.size());
    }

    @Test
    void save() {
        Book book = new Book();
        book.setName("springboot");
        book.setAuthor("springboot");
        book.setPublisher("springboot");
        book.setRemarks("springboot");
        int ret = bookDAO.save(book);

        assertEquals(1, ret);
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(22L);
        book.setName("springboot");
        book.setAuthor("springboot");
        book.setPublisher("springboot");
        book.setRemarks("springboot");

        int ret = bookDAO.update(book);
        assertEquals(1, ret);

        List<Book> books = bookDAO.queryAll();
        System.out.println(books);

        assertEquals(22, books.size());
    }

    @Test
    void delete() {
        int ret = bookDAO.delete(22l);
        assertEquals(1, ret);

        List<Book> books = bookDAO.queryAll();
        System.out.println(books);

        assertEquals(21, books.size());
    }
}