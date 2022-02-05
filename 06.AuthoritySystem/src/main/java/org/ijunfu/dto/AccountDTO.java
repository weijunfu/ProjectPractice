package org.ijunfu.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ qq.com>
 * @date 2022/02/05 16:44
 * @version 1.0.0
 *
 */

@Data
public class AccountDTO implements Serializable {

    private Long accountId;        // 主键

    private Long roleId;        // 角色

    private String username;        // 用户名

    private String realName;        // 真实姓名

    private String sex;        // 性别

    private String email;        // 邮箱
}
