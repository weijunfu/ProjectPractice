package org.ijunfu.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ijunfu.entity.Role;
import org.ijunfu.service.IRoleService;
import org.ijunfu.utils.Response;
import org.ijunfu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     *
     * @Title       toListPage
     * @Description 跳转至列表页
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/08 12:34
     * @version     1.0.0
     * @param
     * @Return      java.lang.String
     */
    @GetMapping("/toList")
    public String toListPage() {

        return "role/list";
    }

    @GetMapping(value = "/list", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response list(
            @RequestParam(required = false) String roleName,
            @RequestParam(required = false, defaultValue = "1") Long page,
            @RequestParam(required = false, defaultValue = "10") Long limit
    ) {

        Page<Role> myPage = roleService
                                .lambdaQuery()
                                .like(StringUtils.isNotBlank(roleName), Role::getRoleName, roleName)
                                .page(new Page<>(page, limit));

        return Result.buildPage(myPage);
    }
}
