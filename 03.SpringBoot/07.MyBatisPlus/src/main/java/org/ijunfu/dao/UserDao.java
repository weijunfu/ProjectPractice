package org.ijunfu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ijunfu.domain.User;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/15 23:00
 * @version 1.0.0
 *
 */

@Mapper
public interface UserDao extends BaseMapper<User> {

}
