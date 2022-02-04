package org.ijunfu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import org.ijunfu.entity.BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author ijunfu
 * @since 2022-02-05 02:39
 */
@TableName("TB_ROLE")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String remarks;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Role{" +
            "roleId=" + roleId +
            ", roleName=" + roleName +
            ", remarks=" + remarks +
        "}";
    }
}
