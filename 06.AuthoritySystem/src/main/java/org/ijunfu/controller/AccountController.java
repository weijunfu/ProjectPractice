package org.ijunfu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ijunfu.entity.Account;
import org.ijunfu.entity.Role;
import org.ijunfu.service.IAccountService;
import org.ijunfu.service.IRoleService;
import org.ijunfu.utils.Response;
import org.ijunfu.utils.Result;
import org.ijunfu.utils.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IRoleService roleService;

    /**
     *
     * @Title       toListPage
     * @Description 跳转至账户列表页面
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/07 20:54
     * @version     1.0.0
     * @param
     * @Return      java.lang.String
     */
    @GetMapping("/toList")
    public String toListPage() {
        return "account/list";
    }

    /**
     *
     * @Title       list
     * @Description 分页查询数据接口
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/07 21:14
     * @version     1.0.0
     * @param 		realName
     * @param 		email
     * @param 		createTime
     * @param 		page
     * @param 		limit
     * @Return      org.ijunfu.utils.Response
     */
    @GetMapping("/list")
    @ResponseBody
    public Response list(
            @RequestParam(required = false) String realName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String createTime,
            @RequestParam(required = false, defaultValue = "1") Long page,
            @RequestParam(required = false, defaultValue = "10") Long limit
    ) {
        QueryWrapper<Account> wrapper = Wrappers.<Account>query();

        wrapper
                .like(StringUtils.isNotBlank(realName), "acc.real_name", realName)
                .like(StringUtils.isNotBlank(email), "acc.email", email);

        if(StringUtils.isNotBlank(createTime)) {
            String[] times = createTime.split(" - ");
            System.out.println(Arrays.asList(times));

            wrapper.ge("acc.create_time", times[0])
                    .le("acc.create_time", times[1]);
        }

        wrapper.eq("acc.deleted", 0)
                .orderByDesc("acc.account_id");

        IPage<Account> myPage = accountService.myPage(new Page<>(page, limit), wrapper);

        return Result.buildPage(myPage);
    }

    /**
     *
     * @Title       toAddPage
     * @Description 跳转至账号添加页面
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/08 00:03
     * @version     1.0.0
     * @param
     * @Return      java.lang.String
     */
    @GetMapping("/toAdd")
    public String toAddPage(Model model) {

        List<Role> roles =roleService
                .lambdaQuery()
                .orderByAsc(Role::getRoleId)
                .list();
        ;

        model.addAttribute("roles", roles);

        return "account/add";
    }

    @PostMapping
    @ResponseBody
    public Response add(@RequestBody Account account) {

        String password = account.getPassword();

        // 盐值
        String salt = StringHelper.random(32);

        account.setSalt(salt);
        account.setPassword(StringHelper.encode(password, salt));   // 加密

        boolean success = accountService.save(account);

        return Result.buildResponse(success);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Response delete(@PathVariable Long id){

        boolean success = accountService.removeById(id);

        return Result.buildResponse(success);
    }
}
