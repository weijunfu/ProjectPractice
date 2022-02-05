package org.ijunfu.controller;

import lombok.extern.slf4j.Slf4j;
import org.ijunfu.dto.AccountDTO;
import org.ijunfu.dto.LoginDTO;
import org.ijunfu.entity.Account;
import org.ijunfu.exception.service.ServiceException;
import org.ijunfu.exception.service.UserNotFoundException;
import org.ijunfu.exception.service.UsernameOrPasswordException;
import org.ijunfu.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/05 12:30
 * @version 1.0.0
 *
 */

@Slf4j
@Controller
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private IAccountService accountService;

    /**
     *
     * @Title       toLoginPage
     * @Description 跳转到登录页面
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/05 17:34
     * @version     1.0.0
     * @param
     * @Return      java.lang.String
     */
    @GetMapping("login")
    public String toLoginPage() {
        return "login";
    }

    /**
     *
     * @Title       login
     * @Description 登录处理：成功 跳转至后台管理页面；失败 登录页面显示错误信息
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/05 17:35
     * @version     1.0.0
     * @param 		loginDTO
     * @param 		session
     * @param 		redirectAttributes
     * @Return      java.lang.String
     */
    @PostMapping("login")
    public String login(String username, String password, HttpSession session, RedirectAttributes redirectAttributes) {

        String path = "";

        try {

            LoginDTO loginDTO = new LoginDTO();
            loginDTO.setUsername(username);
            loginDTO.setPassword(password);

            Account login = accountService.login(loginDTO);

            AccountDTO dto = new AccountDTO();
            BeanUtils.copyProperties(login, dto);

            session.setAttribute("account", dto);

            path = "main";
        } catch (ServiceException e) {
            e.printStackTrace();

            log.warn("{}", e.getMessage());

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            path = "redirect:/";
        }

        return path;
    }

    /**
     *
     * @Title       logout
     * @Description 退出登录
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/05 19:11
     * @version     1.0.0
     * @param 		session
     * @Return      java.lang.String
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 销毁session
        session.invalidate();

        return "redirect:/";
    }
}
