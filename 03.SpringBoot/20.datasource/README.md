# 数据源


## 数据源配置格式

### 格式一：使用默认数据源（HikariCP）
```yaml
spring:
  datasource:
    driver-class-name: org.h2.Driver
    url: jdbc:h2:mem:test
    username: san
    password:
```

### 格式二：使用指定数据源（一）
```yaml
spring:
  datasource:
    driver-class-name: org.h2.Driver
    url: jdbc:h2:mem:test
    username: san
    password:
    type: com.alibaba.druid.pool.DruidDataSource
```


### 格式三：使用指定数据源（二）
```yaml
spring:
  datasource:
    druid:
      driver-class-name: org.h2.Driver
      url: jdbc:h2:mem:test
      username: san
      password:
```

## 内嵌数据源

SpringBoot提供了3种内嵌的数据源对象供开发者选择
+ HikariCP：默认内置数据源对象
+ Tomcat提供DataSource：HikariCP不可用情况下，且在WEB环境中，将使用Tomcat服务器配置的数据源对象
+ Commons DBCP：Hikari不可用，Tomcat数据源也不可用，将使用DBCP数据源
