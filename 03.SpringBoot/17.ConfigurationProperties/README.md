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


## 松散（宽松）绑定
当我们是以`@ConfigurationProperties`绑定属性时，配置文件中属性名支持以下模式：
+ 驼峰模式
```yaml
db:
  driverClassName: org.h2.Driver
```
+ 下划线模式
```yaml
db:
  driver_class_name: org.h2.Driver
```
+ 中划线模式
```yaml
db:
  driver-class-name: org.h2.Driver
```
+ 常量模式
```yaml
db:
  DRIVER_CLASS_NAME: org.h2.Driver
```

须注意的是，`@ConfigurationProperties`的`prefix`属性值仅能使用纯小写字母、数字、下划线作为合法的字符。
`@Value`并不支持宽松绑定。

## SpringBoot支持JDK8提供的时间与空间计量单位
```java
@ConfigurationProperties(prefix = "db")
public class DBConfig {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeout;

    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
    
    //...
}
```



`ChronoUnit`支持的时间单位：

![image-20220121192639013](https://gitee.com/weijunfu/images/raw/master/typora/image-20220121192639013.png)

`DataUnit`支持的空间计量单位：

![image-20220121193531513](https://gitee.com/weijunfu/images/raw/master/typora/image-20220121193531513.png)

## JavaBean 校验

**步骤**：

### 1. 引入JSR303规范
```xml
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
</dependency>
```
### 2. 引入Hibernate校验框架
```xml
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
</dependency>
```

### 3. 开启校验
`@Validated` 用于启用校验。

```java
@Validated
@Configuration
@ConfigurationProperties(prefix = "user")
public class UserConfig {
    // ...
}
```

### 4. 书写校验规则
```java
@Validated
@Configuration
@ConfigurationProperties(prefix = "user")
public class UserConfig {

    private String name;

    @Max(value = 120, message = "年龄太大")
    @Min(value = 0, message = "年龄太小")
    private Integer age;

   // ...
}
```