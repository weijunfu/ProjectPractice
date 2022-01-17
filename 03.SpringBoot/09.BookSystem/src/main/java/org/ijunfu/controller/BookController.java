package org.ijunfu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ijunfu.domain.Book;
import org.ijunfu.service.BookService;
import org.ijunfu.utils.Response;
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
    public Response getPageBook(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        IPage<Book> pageBook = new Page<Book>(page, pageSize);
        bookService.page(pageBook);

        return Response.ok(pageBook);
    }

    @GetMapping("/{id}")
    public Response getBookById(@PathVariable("id") Integer id) {
        Book book = bookService.getById(id);

        return Response.ok(book);
    }

    @PostMapping
    public Response addBook(@RequestBody Book book) {
        boolean ret = bookService.save(book);

        return ret ? Response.ok() : Response.error();
    }

    @PutMapping
    public Response updateBookById(@RequestBody Book book) {
        boolean ret = bookService.updateById(book);

        return ret ? Response.ok() : Response.error();
    }

    @DeleteMapping("/{id}")
    public Response deleteBookById(@PathVariable("id") Integer id) {
        boolean ret = bookService.removeById(id);
        return ret ? Response.ok() : Response.error();
    }
}
