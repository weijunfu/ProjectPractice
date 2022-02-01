package org.ijunfu.entity;

import lombok.Data;

import java.util.Date;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/01 13:56
 * @version 1.0.0
 *
 */

@Data
public class User {

    private Long id;            // 主键
    private String name;        // 姓名
    private Byte age;           // 年龄
    private String email;       // 邮箱
    private Long managerId;    // 直属上级ID
    private Date createTime;   // 创建时间
}
