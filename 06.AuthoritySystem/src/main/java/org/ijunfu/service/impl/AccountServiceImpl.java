package org.ijunfu.service.impl;

import org.ijunfu.entity.Account;
import org.ijunfu.mapper.AccountMapper;
import org.ijunfu.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ijunfu
 * @since 2022-02-05 02:39
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
