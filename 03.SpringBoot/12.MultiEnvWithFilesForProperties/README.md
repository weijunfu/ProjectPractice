# 多环境开发（Properties）

## 主启动配置文件 `application.properties`
```yaml
spring.profiles.active=dev    # 启用环境
```

## 生产环境`application-pro.properties`
```yaml
# 生产环境
server.port=80
```

## 开发`application-dev.properties`
```yaml
# 开发环境
server.port=81
```

## 测试`application-test.properties`
```yaml
# 测试环境
server.port=82
```


