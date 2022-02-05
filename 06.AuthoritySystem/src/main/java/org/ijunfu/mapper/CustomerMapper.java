package org.ijunfu.mapper;

import org.ijunfu.entity.Customer;
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
public interface CustomerMapper extends BaseMapper<Customer> {

}
