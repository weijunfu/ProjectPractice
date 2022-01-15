package org.ijunfu.controller;

import org.apache.catalina.User;
import org.ijunfu.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @Title          用户模块 控制类
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/15 00:11
 * @version 1.0.0
 *
 */

@RestController
@RequestMapping("/books")
public class BookController {

    final static Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public String all() {
        log.info("{}", "查询所有图书");
        return "查询所有图书";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable("id") Integer id) {
        log.info("{}： {}", "查询指定图书", id);
        return "查询指定图书: " + id;
    }

    @PostMapping
    public String add(@RequestBody Book book) {
        log.info("{}：{}", "新增图书", book);
        return "添加图书";
    }

    @PutMapping
    public String put(@RequestBody Book book) {
        log.info("{}： {}", "修改图书", book);
        return "修改图书";
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable("id") Integer id) {
        log.info("{}: {}", "删除指定图书", id);
        return "删除图书: " +id;
    }
}
