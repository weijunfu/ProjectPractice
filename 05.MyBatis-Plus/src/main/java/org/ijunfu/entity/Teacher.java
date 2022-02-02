package org.ijunfu.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 *
 * @Title          教师
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/02 16:50
 * @version 1.0.0
 *
 */

@Data
public class Teacher {

    private String id;          // 主键
    private String name;        // 姓名
    private Integer age;        // 年龄
    private String email;       // 邮箱
    private String managerId;     // 直属上级ID
    private Integer version;        // 版本

    @TableLogic
    private Integer deleted;        // 是否删除
    private Date createTime;       // 创建时间
    private Date lastUpdateTime;  //最后更新时间
}
