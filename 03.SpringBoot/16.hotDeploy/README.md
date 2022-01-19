# 热部署

## 步骤
### 1. 引入依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

### 2. 重新构建项目(激活热部署)

`Build` -> `Build Project`（快捷键`Ctrl+F9`）

## 概念说明

+ 重启（Restart）：自定义开发代码，包含类、页面、配置文件等，使用Restart类加载器
+ 重载（Reload）：Jar包，使用Base类加载器


## IDEA自动热部署

### 配置路径1
`File` -> `Settings...` -> `Build, Execution, Deployment` -> `Compiler`
勾选`Build project automatically`

### 配置路径2

`File` -> `Settings...` -> `Advanced Settings`
在`Compiler`分组中勾选`Allow auto-make to start even if developed application is currently running`
