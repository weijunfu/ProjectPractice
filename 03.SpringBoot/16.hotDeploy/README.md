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

## 热部署范围

### 默认不触发重启的目录列表
+ `/META-INF/maven`
+ `/META-INF/resources`
+ `/resources`
+ `/static`
+ `/public`
+ `/templates`

### 自定义不参与热部署的文件或文件夹
```yaml
spring:
  devtools:
    restart:
      # 不参与热部署的文件或文件夹
      exclude: static/**, public/**, config/application.yml

```

## 关闭热部署

### 通过配置文件关闭热部署
```yaml
spring:
  devtools:
    restart:
      enabled: false
```

存在的问题：若有多个配置文件，该值可能会被覆盖。

### 通过系统属性配置(优先级比配置文件高)

```java
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        // 彻底关闭热启动
        System.setProperty("spring.devtools.restart.enabled", "false");

        SpringApplication.run(Application.class, args);
    }

}
```


扩展：若热部署仍未关闭，则存在比设置系统属性优先级更高的配置