package org.ijunfu.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ijunfu.entity.User;

import java.util.List;

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

    @Select("select * from tb_user ${ew.customSqlSegment}")
    List<User> selectCustom(@Param(Constants.WRAPPER)Wrapper<User> wrapper);

    @Select("select * from tb_user ${ew.customSqlSegment}")
    IPage<User> selectByPage(Page<User> page, @Param(Constants.WRAPPER)Wrapper<User> wrapper);
}
