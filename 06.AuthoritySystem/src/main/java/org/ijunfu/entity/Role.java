package org.ijunfu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import org.ijunfu.entity.BaseEntity;
import lombok.Data;


/**
 *
 * @Title          <h2>实体类</h2>
 * @Description    <p></p>
 *
 * @author         ijunfu
 * @date           2022-02-05 16:02
 * @version        1.0.0
 *
 */

@Data
@TableName("TB_ROLE")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ROLE_ID", type = IdType.ASSIGN_ID)
    private Long roleId;        // 主键

    private String roleName;        // 角色名称

    private String remarks;        // 备注

    @TableField(exist = false)
    private List<Long> resourceIds;
}
