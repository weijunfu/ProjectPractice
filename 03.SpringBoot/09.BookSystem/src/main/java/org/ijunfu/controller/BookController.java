package org.ijunfu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ijunfu.domain.Book;
import org.ijunfu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/17 12:33
 * @version 1.0.0
 *
 */

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public IPage<Book> getPageBook(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        IPage<Book> pageBook = new Page<Book>(page, pageSize);
        return bookService.page(pageBook);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Integer id) {
        return bookService.getById(id);
    }

    @PostMapping
    public boolean addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping
    public boolean updateBookById(@RequestBody Book book) {
        return bookService.updateById(book);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBookById(@PathVariable("id") Integer id) {
        return bookService.removeById(id);
    }
}
