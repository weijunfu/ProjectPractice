package org.ijunfu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ijunfu.entity.Customer;
import org.ijunfu.service.ICustomerService;
import org.ijunfu.utils.Response;
import org.ijunfu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ConcurrentHashMap;

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

    @Autowired
    private ICustomerService customerService;

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

    @GetMapping(value = "/list", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<ConcurrentHashMap<String, Object>> list(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phone,
            @RequestParam(defaultValue = "1", required = false) Long page,
            @RequestParam(defaultValue = "10", required = false) Long limit){

        Page<Customer> customerPage = new Page<>(page, limit);

        LambdaQueryWrapper<Customer> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .like(StringUtils.isNotBlank(name), Customer::getRealName, name)
                .like(StringUtils.isNotBlank(phone), Customer::getPhone, phone)
                .orderByDesc(Customer::getCustomerId);

        customerService.page(customerPage, lambdaQueryWrapper);

        return Result.buildPage(customerPage);
    }
}
