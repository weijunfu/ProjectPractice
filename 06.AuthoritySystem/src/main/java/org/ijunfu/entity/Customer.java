package org.ijunfu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("TB_CUSTOMER")
public class Customer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CUSTOMER_ID", type = IdType.ASSIGN_ID)
    private Long customerId;        // 主键

    private String realName;        // 真实姓名

    private String sex;        // 性别

    private String email;        // 邮箱

    private String phone;        // 手机号码

    private String address;        // 地址


}
