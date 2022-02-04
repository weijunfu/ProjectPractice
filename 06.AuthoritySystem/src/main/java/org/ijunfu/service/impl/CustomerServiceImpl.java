package org.ijunfu.service.impl;

import org.ijunfu.entity.Customer;
import org.ijunfu.mapper.CustomerMapper;
import org.ijunfu.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ijunfu
 * @since 2022-02-05 02:39
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
