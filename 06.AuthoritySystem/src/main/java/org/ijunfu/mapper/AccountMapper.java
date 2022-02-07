package org.ijunfu.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.ijunfu.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @Title          <h2>Mapper接口</h2>
 * @Description   <p></p>
 *
 * @author         ijunfu
 * @date           2022-02-05 16:02
 * @version        1.0.0
 *
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    /**
     *
     * @Title       myPage
     * @Description 分页查询账户 & 角色
     *
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/07 21:30
     * @version     1.0.0
     * @param 		page
     * @param 		wrapper
     * @Return      com.baomidou.mybatisplus.core.metadata.IPage<org.ijunfu.entity.Account>
     */
    IPage<Account> myPage(IPage<Account> page, @Param(Constants.WRAPPER)Wrapper<Account> wrapper);
}
