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
@TableName("TB_CUSTOMER")
public class Customer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long customerId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "customerId=" + customerId +
            ", realName=" + realName +
            ", sex=" + sex +
            ", email=" + email +
            ", phone=" + phone +
            ", address=" + address +
        "}";
    }
}
