# 属性绑定

## 绑定对象

### 配置
```yaml
db:
  driverClassName: org.h2.Driver
  url: jdbc:h2:mem:test
  username: root
  password: 123456hikari
```

### 配置类
```java
@Configuration
@ConfigurationProperties(prefix = "db")
public class DBConfig {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    
    // Getter、Setter、ToString……
}
```

## 绑定第三方属性

### 配置
```yaml
datasource:
  driverClassName: org.h2.Driver
  url: jdbc:h2:mem:test
  username: root
  password: 123456hikari
```

### 绑定
```java
@Configuration
public class DruidConfig {

    /**
     *
     * @Title       dataSource
     * @Description 为第三方绑定属性
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/21 17:20
     * @version     1.0.0
     * @param
     * @Return      com.alibaba.druid.pool.DruidDataSource
     */
    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
}
```

## @EnableConfigurationProperties 注解

> `@EnableConfigurationProperties`用于将`@ConfigurationProperties`对应的类添加到Spring容器中

### 配置类

```java
// @Configuration
@ConfigurationProperties(prefix = "db")
public class DBConfig {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    
    // Getter、Setter、ToString……
}
```

```java
@Configuration
@EnableConfigurationProperties(DBConfig.class)
public class DruidConfig {

    // ...
}
```

需要注意的是`@EnableConfigurationProperties`和`@Component`冲突，因此`@EnableConfigurationProperties`指定的类上不能添加`@Component`。
