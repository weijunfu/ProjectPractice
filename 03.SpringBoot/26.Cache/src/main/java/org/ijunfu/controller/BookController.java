package org.ijunfu.controller;

import org.ijunfu.domain.Book;
import org.ijunfu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/26 19:08
 * @version 1.0.0
 *
 */

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.list();
    }

    @GetMapping("/{id}")
    @Cacheable(value = "book_id_cache", key = "#id")
    public Book getById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PostMapping
    public Boolean save(Book book) {
        System.out.println(book);

        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(Book book) {
        return bookService.updateById(book);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteById(@PathVariable Long id) {
        return bookService.removeById(id);
    }
}
