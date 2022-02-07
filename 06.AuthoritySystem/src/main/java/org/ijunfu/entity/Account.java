package org.ijunfu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
@TableName("TB_ACCOUNT")
public class Account extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "ACCOUNT_ID", type = IdType.ASSIGN_ID)
    private Long accountId;        // 主键

    private Long roleId;        // 角色

    private String username;        // 用户名

    private String password;        // 密码

    private String salt;        // 盐值

    private String realName;        // 真实姓名

    private String sex;        // 性别

    private String email;        // 邮箱

    @TableField(exist = false)
    private String roleName;    // 角色名称
}
