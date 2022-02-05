package org.ijunfu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;


/**
 *
 * @Title          <h2>实体类</h2>
 * @Description    <p></p>
 *
 * @author         ijunfu
 * @date           2022-02-05 16:01
 * @version        1.0.0
 *
 */

@Data
@TableName("TB_ROLE_RESOURCE")
public class RoleResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ROLE_RESOURCE_ID", type = IdType.ASSIGN_ID)
    private Long roleResourceId;        // 主键

    private Long roleId;        // 角色ID

    private Long resourceId;        // 资源ID


}
