package org.ijunfu.dao;

import org.ijunfu.domain.Book;
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
 * @date 2022/01/15 23:02
 * @version 1.0.0
 *
 */
@SpringBootTest
class BookDaoTest {
    final static Logger log = LoggerFactory.getLogger(BookDaoTest.class);

    @Autowired
    private BookDao bookDao;

    @Test
    void getBookById() {
        Book book = bookDao.getBookById(1);

        log.info("{}", book);
    }

    @Test
    void save() {
        Book book = new Book();
        book.setName("Java 核心技术");
        book.setType("Java");
        book.setRemarks("原名：Core Java 作者：凯 S.霍斯特曼 (Cay S. Horstmann)");

        bookDao.save(book);
    }

    @Test
    void insert() {
        Book book = new Book();
        book.setName("人月神话(40周年中文纪念版)");
        book.setType("软件开发");
        book.setRemarks("清华大学出版社出版，外文书名: The Mythical Man-Month:Essays on Software Engineering Anniversary Edition，作者：小弗雷德里克·布鲁克斯 (Frederick P.Brooks)");

        bookDao.insert(book);

        log.info("{}: {}", book.getId(), book);
    }
}