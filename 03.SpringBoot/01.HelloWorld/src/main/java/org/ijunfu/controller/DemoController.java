package org.ijunfu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/14 23:21
 * @version 1.0.0
 *
 */

@RestController
@RequestMapping("/demos")
public class DemoController {

    @GetMapping
    public String hello() {
        return "Hello!";
    }
}
