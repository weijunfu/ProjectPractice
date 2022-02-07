package org.ijunfu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ijunfu.dto.AccountDTO;
import org.ijunfu.entity.Customer;
import org.ijunfu.service.ICustomerService;
import org.ijunfu.utils.Response;
import org.ijunfu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    public String toListPage() {
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

    /**
     *
     * @Title       toAddPage
     * @Description 跳转至客户添加页面
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/07 11:03
     * @version     1.0.0
     * @param
     * @Return      java.lang.String
     */
    @GetMapping("/toAdd")
    public String toAddPage(){
        return "customer/add";
    }

    /**
     *
     * @Title       add
     * @Description 新增客户
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/07 11:10
     * @version     1.0.0
     * @param 		customer
     * @Return      org.ijunfu.utils.Response
     */
    @PostMapping
    @ResponseBody
    public Response add(@RequestBody Customer customer, HttpSession session) {

        AccountDTO account = (AccountDTO) session.getAttribute("account");

        customer.setCreatedBy(account.getAccountId());
        customer.setLastUpdatedBy(account.getAccountId());

        boolean success = customerService.save(customer);

        return Result.buildResponse(success);
    }

    /**
     *
     * @Title       toUpdatePage
     * @Description 跳转至客户修改界面
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/07 12:12
     * @version     1.0.0
     * @param 		id
     * @param 		model
     * @Return      java.lang.String
     */
    @GetMapping("/toUpdate/{id}")
    public String toUpdatePage(@PathVariable Long id, Model model){
        Customer customer = customerService.getById(id);
        model.addAttribute("customer", customer);
        return "customer/update";
    }

    @PutMapping
    @ResponseBody
    public Response update(@RequestBody Customer customer, HttpSession session) {
        AccountDTO accountDTO = (AccountDTO) session.getAttribute("account");

        customer.setLastUpdatedBy(accountDTO.getAccountId());

        boolean success = customerService.updateById(customer);

        return Result.buildResponse(success);
    }
}
