package org.ijunfu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.ijunfu.entity.User;
import org.ijunfu.mapper.UserMapper;
import org.ijunfu.service.UserService;
import org.springframework.stereotype.Service;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/02 16:21
 * @version 1.0.0
 *
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
