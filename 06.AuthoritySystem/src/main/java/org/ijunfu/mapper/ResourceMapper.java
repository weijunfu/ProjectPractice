package org.ijunfu.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.ijunfu.entity.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ijunfu.vo.Tree;

import java.util.List;

/**
 *
 * @Title          <h2>Mapper接口</h2>
 * @Description   <p></p>
 *
 * @author         ijunfu
 * @date           2022-02-05 16:01
 * @version        1.0.0
 *
 */
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    List<Resource> listResource(@Param(Constants.WRAPPER) Wrapper<Resource> wrapper);

    List<Tree> listResourceByRoleId(@Param(Constants.WRAPPER) Wrapper<Resource> wrapper, @Param("roleId") Long roleId);
}
