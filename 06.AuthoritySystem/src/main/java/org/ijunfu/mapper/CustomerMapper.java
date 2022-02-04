package org.ijunfu.mapper;

import org.ijunfu.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ijunfu
 * @since 2022-02-05 02:39
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}
