package org.ijunfu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Response<IPage<Book>> getPageBook(
            @RequestParam(defaultValue = "1") Integer page,             // 页面
            @RequestParam(defaultValue = "10") Integer pageSize,        // 页面大小
            Book book
    ) {

        IPage<Book> bookPage = bookService.page(page, pageSize, book);

        if(page > bookPage.getPages())  {
            bookPage = bookService.page((int) bookPage.getPages(), pageSize, book);
        }

            return Response.ok("查询成功", bookPage);
    }

    @GetMapping("/{id}")
    public Response<Book> getBookById(@PathVariable("id") Long id) {
        Book book = bookService.getById(id);

        return Response.ok("查询成功", book);
    }

    @PostMapping
    public Response addBook(@RequestBody Book book) {
        boolean ret = bookService.save(book);

        return ret ? Response.ok("保存成功") : Response.error("保存失败");
    }

    @PutMapping
    public Response updateBookById(@RequestBody Book book) {
        boolean ret = bookService.updateById(book);

        return ret ? Response.ok("修改成功") : Response.error("修改失败");
    }

    @DeleteMapping("/{id}")
    public Response deleteBookById(@PathVariable("id") Long id) {

        boolean ret = bookService.removeById(id);

        return ret ? Response.ok("删除成功") : Response.error("删除失败");
    }
}
