package org.ijunfu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ijunfu.domain.User;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/16 20:50
 * @version 1.0.0
 *
 */

@Mapper
public interface UserDao {

    @Select("select * from tb_user where id=#{id}")
    public User getUserById(Integer id);
}
