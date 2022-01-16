# 整合 Druid

## 步骤

### 1. 引入Druid依赖
```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>1.2.8</version>
</dependency>
```

### 2. 修改配置
> Druid有两种配置方式，这里建议使用第二种。

#### 2.1 简洁模式
```yaml
spring:
  datasource:
    driver-class-name: org.h2.Driver
    url: jdbc:h2:mem:druidDB
    username: san
    password:
    type: com.alibaba.druid.pool.DruidDataSource
```

#### 2.2 标准模式
```yaml
spring:
  datasource:
    druid:
      driver-class-name: org.h2.Driver
      url: jdbc:h2:mem:druidDB
      username: san
      password:
```


### 小结

整合任意第三方技术的关键：
+ 导入对应的`starter`
+ 配置对应的设置或采用默认配置