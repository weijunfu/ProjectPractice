package org.ijunfu.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.ijunfu.dto.LoginDTO;
import org.ijunfu.entity.Account;
import org.ijunfu.exception.service.UserNotFoundException;
import org.ijunfu.exception.service.UsernameOrPasswordException;
import org.ijunfu.mapper.AccountMapper;
import org.ijunfu.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.ijunfu.utils.StringHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @Title          <h2>业务实现类</h2>
 * @Description    <p></p>
 *
 * @author         ijunfu
 * @date           2022-02-05 16:02
 * @version        1.0.0
 *
 */
@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Override
    public Account login(LoginDTO loginDTO) throws UserNotFoundException, UsernameOrPasswordException {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        String msg = "";

        Account account = lambdaQuery().eq(Account::getUsername, username).one();
        if(null == account) {
            msg = "用户不存在";
            log.warn("{}", msg);
            throw new UserNotFoundException(msg);
        }

        String encode = StringHelper.encode(password, account.getSalt());
        String pwd = account.getPassword();

        if(!pwd.equals(encode)){
            msg = "用户名或密码错误";
            log.warn("{}", msg);
            throw new UsernameOrPasswordException(msg);
        }

        return account;
    }

    @Override
    public IPage<Account> myPage(IPage<Account> page, Wrapper<Account> wrapper) {
        return baseMapper.myPage(page, wrapper);
    }
}
