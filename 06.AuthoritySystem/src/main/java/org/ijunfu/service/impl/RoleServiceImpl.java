package org.ijunfu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.ijunfu.entity.Role;
import org.ijunfu.entity.RoleResource;
import org.ijunfu.mapper.RoleMapper;
import org.ijunfu.mapper.RoleResourceMapper;
import org.ijunfu.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
                }
            }
        } catch (Exception e) {
            log.error("{}", e);
            e.printStackTrace();
            return false;
        }


        return true;
    }
}
