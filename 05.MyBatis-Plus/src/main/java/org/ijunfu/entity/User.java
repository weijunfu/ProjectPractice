package org.ijunfu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
public class User extends Model<User> {

    @TableId(type = IdType.AUTO)
    private Long id;            // 主键

    private String name;        // 姓名
    private Byte age;           // 年龄
    private String email;       // 邮箱
    private Long managerId;    // 直属上级ID
    private Date createTime;   // 创建时间

    private transient String ext1;
    private static String ext2;

    @TableField(exist = false)
    private String ext3;

    public static String getExt2() {
        return ext2;
    }

    public static void setExt2(String ext2) {
        User.ext2 = ext2;
    }
}
