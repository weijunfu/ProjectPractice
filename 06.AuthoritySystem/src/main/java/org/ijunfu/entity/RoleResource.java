package org.ijunfu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ijunfu
 * @since 2022-02-05 02:38
 */
@TableName("TB_ROLE_RESOURCE")
public class RoleResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long roleResourceId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 资源ID
     */
    private Long resourceId;

    public Long getRoleResourceId() {
        return roleResourceId;
    }

    public void setRoleResourceId(Long roleResourceId) {
        this.roleResourceId = roleResourceId;
    }
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "RoleResource{" +
            "roleResourceId=" + roleResourceId +
            ", roleId=" + roleId +
            ", resourceId=" + resourceId +
        "}";
    }
}
