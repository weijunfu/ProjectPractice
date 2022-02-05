package org.ijunfu.service;

import org.ijunfu.dto.LoginDTO;
import org.ijunfu.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ijunfu.exception.service.UserNotFoundException;
import org.ijunfu.exception.service.UsernameOrPasswordException;

/**
 *
 * @Title          <h2>业务类</h2>
 * @Description    <p></p>
 *
 * @author         ijunfu
 * @date           2022-02-05 16:02
 * @version        1.0.0
 *
 */
public interface IAccountService extends IService<Account> {

    Account login(LoginDTO loginDTO) throws UserNotFoundException, UsernameOrPasswordException;
}
