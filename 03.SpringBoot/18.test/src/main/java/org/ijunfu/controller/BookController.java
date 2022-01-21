package org.ijunfu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/21 23:31
 * @version 1.0.0
 *
 */

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String all() {
        log.info("{}", "all is running...");
        return "query all books";
    }
}
