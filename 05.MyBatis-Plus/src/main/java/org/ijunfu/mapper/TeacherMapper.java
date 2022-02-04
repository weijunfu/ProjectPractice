package org.ijunfu.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ijunfu.entity.Teacher;
import org.ijunfu.entity.User;

import java.util.List;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/02 16:53
 * @version 1.0.0
 *
 */

@Mapper
public interface TeacherMapper extends MyMapper<Teacher> {

    @Select("select  * from tb_teacher where deleted = 0 ${ew.customSqlSegment}")
    List<Teacher> mySelectList(@Param(Constants.WRAPPER)Wrapper<Teacher> userWrapper);
}
