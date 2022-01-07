package org.ijunfu.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @version 1.0.0
 * @Title <Title>
 * @Description <TODO>
 * @date 2022/01/06 19:23
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    /**
     * @Title       测试页面
     * @Description 
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/06 20:59
     * @version     1.0.0
     * @param 		model
     * @Return      java.lang.String
     */
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "ijunfu");
        return "hello";
    }
}
