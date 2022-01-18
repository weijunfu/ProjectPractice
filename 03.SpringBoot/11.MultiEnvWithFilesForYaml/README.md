# 多环境开发 （多文件）

## 主启动配置文件 `application.yml`
```yaml
spring:
  profiles:
    active: test    # 启用环境
```

## 生产环境`application-pro.yml`
```yaml
# 生产环境
server:
  port: 80
```

## 开发`application-dev.yml`
```yaml
# 开发环境
server:
  port: 81
```

## 测试`application-test.yml`
```yaml
# 测试环境
server:
  port: 82
```
