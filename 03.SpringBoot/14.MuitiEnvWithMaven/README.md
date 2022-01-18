# Maven 与 SpringBoot 多环境兼容

## 步骤

### 1. 设置Maven多环境
```xml
 <profiles>
    <!-- 生产环境 -->
    <profile>
        <id>pro</id>
        <properties>
            <profile.active>pro</profile.active>
        </properties>
        <!-- 设置成默认环境 -->
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
    </profile>

    <!-- 开发环境 -->
    <profile>
        <id>dev</id>
        <properties>
            <profile.active>dev</profile.active>
        </properties>
    </profile>
</profiles>
```

### 2. 参数处理

```xml
<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <!-- 启用过滤，处理参数的引用 -->
            <filtering>true</filtering>
        </resource>
    </resources>
</build>
```

### 3. 在SpringBoot中读取Maven环境配置
```yaml
spring:
  profiles:
    active: @profile.active@
    group:
      "pro": proDB
      "dev": devDB
```

需要注意的是，需要手动执行Maven的`compile`。