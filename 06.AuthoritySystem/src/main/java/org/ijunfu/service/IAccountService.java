package org.ijunfu.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

    /**
     *
     * @Title       login
     * @Description 用户登录
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/07 21:31
     * @version     1.0.0
     * @param 		loginDTO
     * @Return      org.ijunfu.entity.Account
     */
    Account login(LoginDTO loginDTO) throws UserNotFoundException, UsernameOrPasswordException;

    /**
     *
     * @Title       myPage
     * @Description 分页查询账户 & 角色
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/07 21:31
     * @version     1.0.0
     * @param 		page
     * @param 		wrapper
     * @Return      com.baomidou.mybatisplus.core.metadata.IPage<org.ijunfu.entity.Account>
     */
    IPage<Account> myPage(IPage<Account> page, Wrapper<Account> wrapper);

    /**
     *
     * @Title       selectAccountById
     * @Description 根据ID查询账户详情
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/08 00:56
     * @version     1.0.0
     * @param 		id
     * @Return      org.ijunfu.entity.Account
     */
    Account selectAccountById(Long id);
}
