package org.ijunfu;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ qq.com>
 * @date 2022/02/10 15:27
 * @version 1.0.0
 *
 */

public class JdbcRealmTest {

    DruidDataSource dataSource = new DruidDataSource();

    {
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:~/shiroTest");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        DruidPooledConnection conn = null;
        try {
            conn = dataSource.getConnection();

            // 创建表结构
            // 删除表
            System.out.println("删除表");
            conn.prepareStatement("drop table if exists users").executeUpdate();
            conn.prepareStatement("drop table if exists user_roles").executeUpdate();
            conn.prepareStatement("drop table if exists roles_permissions").executeUpdate();

            // 创建表
            System.out.println("创建表");
            conn.prepareStatement("create table users(username varchar(30) comment '用户名',password varchar(64) comment '密码',password_salt varchar(64) comment '盐值');").executeUpdate();
            conn.prepareStatement("create table user_roles(username varchar(30) comment '用户名',role_name varchar(30) comment '角色名')").executeUpdate();
            conn.prepareStatement("create table roles_permissions(role_name varchar(30) comment '角色名',permission varchar(30) comment '权限')").executeUpdate();

            // 插入数据
            System.out.println("插入数据");
            conn.prepareStatement("insert into users(username,password) values('ijunfu', '123456')").executeUpdate();
            conn.prepareStatement("insert into user_roles values('ijunfu', 'root')").executeUpdate();
            conn.prepareStatement("insert into roles_permissions values('root', 'usr:del')").executeUpdate();

            ResultSet resultSet = conn.prepareStatement("select permission from roles_permissions where role_name = 'root'").executeQuery();
            while(resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                conn = null;
            }
        }
    }

    @Test
    public void test() {
        // 1. 创建 Realm
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(dataSource);
        realm.setPermissionsLookupEnabled(true);

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
        subject.checkPermissions("usr:del");

        // 退出
        subject.logout();

        System.out.println("isAuthenticated: " + subject.isAuthenticated());
    }
}
