package org.ijunfu.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ qq.com>
 * @date 2022/02/10 18:29
 * @version 1.0.0
 *
 */

public class MyRealm extends AuthorizingRealm {

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        String username = (String) pc.getPrimaryPrincipal();

        Set<String> roles = getRoles();
        Set<String> permissions = getPermissions();

        SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
        auth.setRoles(roles);
        auth.setStringPermissions(permissions);

        return auth;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户名
        String username = (String) token.getPrincipal();

        String password = getPassword(username);
        if(null == password) return null;

        SimpleAuthenticationInfo auth = new SimpleAuthenticationInfo("ijunfu", password, "myRealm");
        auth.setCredentialsSalt(ByteSource.Util.bytes("ijunfu"));
        return auth;
    }

    // 模拟数据库
    private Map<String, String> users = new HashMap<>();
    private Map<String, String[]> roles = new HashMap<>();
    private Map<String, String[]> permissions = new HashMap<>();

    {
        super.setName("myRealm");

        users.put("ijunfu", "ea3b5434cc1f13e9bf9aed4d6d10a06a");

        roles.put("ijunfu", new String[]{"root", "admin"});

        permissions.put("root", new String[]{"user:del", "user:add"});
    }

    private Set<String> getRoles() {        // 从数据获取角色
        Set<String> set = new HashSet<>();
        set.add("root");
        set.add("user");

        return set;
    }

    private Set<String> getPermissions() {  // 从数据库获取 权限
        Set<String> set = new HashSet<>();
        set.add("user:add");
        set.add("user:delete");

        return set;
    }

    private String getPassword(String username) {
        return users.get(username);
    }
}
