# Shiro

## 一、简介

### 1.1 什么是`Shiro`?

+ `Shiro`是Apache的强大灵活的开源**安全**框架
+ 提供**认证**、**授权**、**企业会话管理**、**安全加密**等功能


### 1.2 `Shiro` vs `Spring Security`

+ Shiro
  + 简单、灵活
  + 不依赖Spring
  + 粒度较粗
+ Spring Security
  + 复杂、笨重
  + 不可脱离Spring
  + 粒度更细

## 二、创建Realm的四种方式


### 2.1 嵌入式

#### 步骤
+ 创建Realm
+ 构建SecurityManager环境
+ 创建Subject
+ 登录
+ 退出

#### 代码
```java
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
```

### 2.2 ini Realm

#### 创建ini文件
```text
[users]
ijunfu=123456,admin

[roles]
admin=user:delete
```

#### 代码示例
```java

public class IniRealmTest {

    @Test
    public void test() {
        // 1. 创建 Realm
        IniRealm realm = new IniRealm("classpath:auth.ini");

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
        subject.checkRole("admin");
  
        // 校验权限
        subject.checkPermission("user:delete");
        
        // 退出
        subject.logout();

        System.out.println("isAuthenticated: " + subject.isAuthenticated());
    }
}
```

### 2.3 jdbcRealm

```java
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
```

注意：JdbcRealm默认关闭权限校验，因此校验权限之前需要调用`setPermissionsLookupEnabled(true)`开启。

### 2.4 自定义Realm

```java
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

        return auth;
    }

    // 模拟数据库
    private Map<String, String> users = new HashMap<>();
    private Map<String, String[]> roles = new HashMap<>();
    private Map<String, String[]> permissions = new HashMap<>();

    {
        super.setName("myRealm");

        users.put("ijunfu", "123456");

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
```







## 三、加密

### 3.1 Hash

```
 // 加密
HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
hashedCredentialsMatcher.setHashAlgorithmName("md5");       // 加密算法
hashedCredentialsMatcher.setHashIterations(1);              // 加密次数
realm.setCredentialsMatcher(hashedCredentialsMatcher);
```

### 3.2 加盐

#### 认证时携带盐值
```
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
```