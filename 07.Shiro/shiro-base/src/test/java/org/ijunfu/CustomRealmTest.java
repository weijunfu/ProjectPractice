package org.ijunfu;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.ijunfu.realm.MyRealm;
import org.junit.Test;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ qq.com>
 * @date 2022/02/10 18:37
 * @version 1.0.0
 *
 */

public class CustomRealmTest {

    @Test
    public void test() {
        // 1. 创建 Realm
        MyRealm realm = new MyRealm();

        // 2. 构建SecurityManager环境
        DefaultSecurityManager sm = new DefaultSecurityManager();
        sm.setRealm(realm);
        SecurityUtils.setSecurityManager(sm);

        // 3. 创建Subject
        Subject subject = SecurityUtils.getSubject();

        // 4. 登录
        UsernamePasswordToken token = new UsernamePasswordToken("ijunfu", "123456");
        subject.login(token);

        System.out.println("isAuthenticated: " + subject.isAuthenticated());

        // 校验角色
        subject.checkRole("root");

        // 校验权限
        subject.checkPermissions("user:add");

        // 退出
        subject.logout();

        System.out.println("isAuthenticated: " + subject.isAuthenticated());
    }
}
