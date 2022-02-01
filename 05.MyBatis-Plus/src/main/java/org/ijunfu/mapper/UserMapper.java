package org.ijunfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ijunfu.entity.User;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/01 14:03
 * @version 1.0.0
 *
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
