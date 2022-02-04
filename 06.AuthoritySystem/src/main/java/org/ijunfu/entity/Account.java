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
@TableName("TB_ACCOUNT")
public class Account extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long accountId;

    /**
     * 角色
     */
    private Long roleId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String sal;

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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
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

    @Override
    public String toString() {
        return "Account{" +
            "accountId=" + accountId +
            ", roleId=" + roleId +
            ", username=" + username +
            ", password=" + password +
            ", sal=" + sal +
            ", realName=" + realName +
            ", sex=" + sex +
            ", email=" + email +
        "}";
    }
}
