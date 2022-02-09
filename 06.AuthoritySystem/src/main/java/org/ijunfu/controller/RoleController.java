package org.ijunfu.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ijunfu.entity.Role;
import org.ijunfu.service.IResourceService;
import org.ijunfu.service.IRoleService;
import org.ijunfu.utils.Response;
import org.ijunfu.utils.Result;
import org.ijunfu.vo.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IResourceService resourceService;

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

    /**
     *
     * @Title       list
     * @Description 查询 角色列表
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/08 13:56
     * @version     1.0.0
     * @param 		roleName
     * @param 		page
     * @param 		limit
     * @Return      org.ijunfu.utils.Response
     */
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

    /**
     *
     * @Title       toAddPage
     * @Description 跳转至添加页面
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/08 13:58
     * @version     1.0.0
     * @param
     * @Return      java.lang.String
     */
    @GetMapping("/toAdd")
    public String toAddPage() {
        return "role/add";
    }

    @GetMapping(value = {"/resources", "/resources/{roleId}"}, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Response<List<Tree>> resourcesList(@PathVariable(required = false) Long roleId){
        List<Tree> trees = resourceService.resourcesList(roleId);
        return Response.ok(trees);
    }

    @PostMapping
    @ResponseBody
    public Response add(@RequestBody Role role) {
        boolean success = roleService.saveRole(role);
        return Result.buildResponse(success);
    }

    @GetMapping("/toUpdate/{roleId}")
    public String toUpdatePage(@PathVariable Long roleId, Model model) {

        Role role = roleService.getById(roleId);
        model.addAttribute("role", role);
        return "role/update";
    }

    @PutMapping
    @ResponseBody
    public Response update(@RequestBody Role role) {

        boolean success = roleService.updateRole(role);

        return Result.buildResponse(success);
    }

    @DeleteMapping("/{roleId}")
    @ResponseBody
    public Response delete(@PathVariable Long roleId) {
        boolean success = roleService.deleteRole(roleId);
        return Result.buildResponse(success);
    }
}
