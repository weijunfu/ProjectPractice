package org.ijunfu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.ijunfu.entity.Role;
import org.ijunfu.entity.RoleResource;
import org.ijunfu.mapper.RoleMapper;
import org.ijunfu.mapper.RoleResourceMapper;
import org.ijunfu.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @Title          <h2>业务实现类</h2>
 * @Description    <p></p>
 *
 * @author         ijunfu
 * @date           2022-02-05 16:02
 * @version        1.0.0
 *
 */
@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleResourceMapper rrMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveRole(Role role) {
        try {
            save(role);

            Long roleId = role.getRoleId();

            List<Long> resourceIds = role.getResourceIds();
            if(CollectionUtils.isNotEmpty(resourceIds)) {

                for(Long id : resourceIds) {
                    RoleResource rr = new RoleResource();
                    rr.setRoleId(roleId);
                    rr.setResourceId(id);

                    rrMapper.insert(rr);
                }
            }
        } catch (Exception e) {
            log.error("{}", e);
            e.printStackTrace();
            return false;
        }


        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateRole(Role role) {

        try {
            updateById(role);

            Long roleId = role.getRoleId();

            // 删除已有资源
            rrMapper.delete(Wrappers.<RoleResource>lambdaQuery().eq(RoleResource::getRoleId, roleId));

            // 新增
            List<Long> resourceIds = role.getResourceIds();
            if(CollectionUtils.isNotEmpty(resourceIds)) {

                for(Long id : resourceIds) {
                    RoleResource rr = new RoleResource();
                    rr.setRoleId(roleId);
                    rr.setResourceId(id);

                    rrMapper.insert(rr);
                }
            }
        } catch (Exception e) {
            log.error("{}", e);
            e.printStackTrace();
            return false;
        }


        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteRole(Long roleId) {

        try {
            removeById(roleId);

            // 删除已有资源
            rrMapper.delete(Wrappers.<RoleResource>lambdaQuery().eq(RoleResource::getRoleId, roleId));
        } catch (Exception e) {
            log.error("{}", e);
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
