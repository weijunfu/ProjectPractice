package org.ijunfu.service.impl;

import org.ijunfu.entity.Resource;
import org.ijunfu.mapper.ResourceMapper;
import org.ijunfu.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ijunfu
 * @since 2022-02-05 02:36
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

}
