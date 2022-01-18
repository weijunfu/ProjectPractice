# 多环境开发

> 单文件实现多环境配置

`yaml`格式中设置多环境使用`---`分隔环境边界。例如：
```yaml
spring:
  profiles:
    active: test # 启用指定环境

# 通用配置
# ...

---
spring:
  profiles: pro # 生产环境

server:
  port: 80

---
spring:
  profiles: dev # 开发环境

server:
  port: 81

---
spring:
  profiles: test # 测试环境

server:
  port: 82
```

每种环境的区别在于加载的配置属性不同。

