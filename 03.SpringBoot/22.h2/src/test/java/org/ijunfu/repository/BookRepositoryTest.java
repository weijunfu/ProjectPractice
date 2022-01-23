package org.ijunfu.repository;

import org.ijunfu.domain.Book;
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
 * @date 2022/01/23 19:46
 * @version 1.0.0
 *
 */
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void count() {
        long count = bookRepository.count();
        assertEquals(0l, count);
    }

    @Test
    void save() {
        Book book = new Book();
        book.setName("SpringBoot");
        book.setAuthor("ijunfu");
        book.setPublisher("wei");
        book.setRemarks("test");

        Book save = bookRepository.save(book);
        System.out.println(save);

        long count = bookRepository.count();
        assertEquals(1l, count);
    }
}