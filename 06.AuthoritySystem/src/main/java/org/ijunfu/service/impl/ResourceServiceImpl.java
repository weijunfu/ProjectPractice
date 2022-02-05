package org.ijunfu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.ijunfu.entity.Resource;
import org.ijunfu.mapper.ResourceMapper;
import org.ijunfu.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @Title          <h2>业务实现类</h2>
 * @Description    <p></p>
 *
 * @author         ijunfu
 * @date           2022-02-05 16:01
 * @version        1.0.0
 *
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

    @Override
    public List<Resource> listBy(Long roleId) {
        QueryWrapper<Resource> queryWrapper = Wrappers.<Resource>query();

        queryWrapper.eq("rr.role_id", roleId)
                .isNull("res.parent_id");

        List<Resource> resourceList = baseMapper.listResource(queryWrapper);
        resourceList.forEach(item -> {
            Long resourceId = item.getResourceId();

            QueryWrapper<Resource> subQueryWrapper = Wrappers.<Resource>query();
            subQueryWrapper.eq("rr.role_id", roleId)
                    .eq("res.parent_id", resourceId);
            List<Resource> list = baseMapper.listResource(subQueryWrapper);
            if(CollectionUtils.isNotEmpty(list)) {
                item.setChilds(list);
            }

        });

        return resourceList;
    }
}
