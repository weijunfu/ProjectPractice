package org.ijunfu.service;

import org.ijunfu.dto.LoginDTO;
import org.ijunfu.entity.Account;
import org.ijunfu.exception.service.UserNotFoundException;
import org.ijunfu.exception.service.UsernameOrPasswordException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ qq.com>
 * @date 2022/02/05 16:58
 * @version 1.0.0
 *
 */
@SpringBootTest
class IAccountServiceTest {

    @Autowired
    IAccountService accountService;

    @Test
    void login() throws UserNotFoundException, UsernameOrPasswordException {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername("root");
        loginDTO.setPassword("123456");

        Account account = accountService.login(loginDTO);
        System.out.println(account);

    }

    @Test
    void userNotFound() throws UserNotFoundException, UsernameOrPasswordException {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername("root1");
        loginDTO.setPassword("123456");

        Account account = accountService.login(loginDTO);
        System.out.println(account);

    }

    @Test
    void usernameOrPasswordException() throws UserNotFoundException, UsernameOrPasswordException {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername("root");
        loginDTO.setPassword("1234567");

        Account account = accountService.login(loginDTO);
        System.out.println(account);

    }
}