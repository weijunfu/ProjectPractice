package org.ijunfu;

import static org.junit.Assert.assertTrue;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class SimpleAuthenticationTest
{

    SimpleAccountRealm realm = new SimpleAccountRealm();

    @Before
    public void before() {
        realm.addAccount("ijunfu", "123456", "admin");
    }

    @Test
    public void testAuthentication() {
        // 1. 构建SecurityManager环境
        DefaultSecurityManager sm = new DefaultSecurityManager();
        sm.setRealm(realm);
        SecurityUtils.setSecurityManager(sm);

        // 2. 主题提交认证请求
        Subject subject = SecurityUtils.getSubject();

        // 3. 登录
        UsernamePasswordToken token = new UsernamePasswordToken("ijunfu", "123456");
        subject.login(token);

        System.out.println("isAuthenticated: " + subject.isAuthenticated());

        // 检验角色
        subject.checkRole("admin");

        // 4. 退出
        subject.logout();

        System.out.println("isAuthenticated: " + subject.isAuthenticated());
    }

}
