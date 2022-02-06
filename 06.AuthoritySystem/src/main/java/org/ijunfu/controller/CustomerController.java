package org.ijunfu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @Title          <h2>前端控制器</h2>
 * @Description    <p></p>
 *
 * @author         ijunfu
 * @date           2022-02-05 16:02
 * @version        1.0.0
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    /**
     *
     * @Title       toList
     * @Description 跳转至客户管理首页
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/06 15:52
     * @version     1.0.0
     * @param
     * @Return      java.lang.String
     */
    @GetMapping("/toList")
    public String toList() {
        return "customer/list";
    }
}
