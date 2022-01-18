# 多环境分组配置

## 旧版本(<2.4)

多个环境使用`,`号分隔

```yaml
spring:
  profiles:
    active: pro
    include: proDB, proRedis
```

当属性相同时，主环境配置生效；若其它环境有相同属性时，最后加载的属性生效。

## 新版本(2.4+)

```yaml
spring:
  profiles:
    active: pro
    group:
      "pro": proDB, proRedis
      "dev": devDB, devRedis
```

