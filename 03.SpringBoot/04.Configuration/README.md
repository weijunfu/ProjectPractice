# 配置

## 常用配置

> application.properties 配置文件

### 配置端口号

```properties
server.port=80
```

### 设置Banner

+ 关闭Banner`spring.main.banner-mode=off`
+ 新建`banner.txt`, 内容为空，即可去除Banner
+ 设置`spring.banner.image.location`的值为图片路径，即显示的Banner为当前设置的图片ACSII码


### 配置日志

```properties
logging.level.root=warn
logging.level.org.ijunfu=debug
```


## 配置文件

SpringBoot提供了三种配置文件类型，分别为`properties`、`yml`和`yaml`。

+ `application.properties`，传统格式（默认）
```properties
server.port=80
```
+ `application.yml`，主流格式
```yml
server: 
  port: 81
```
+ `appication.yaml`
```yaml
server: 
  port: 82
```

若以上三个文件同时存在，则优先级为：`properties` > `yml` > `yaml`。
但需要注意的是，相同属性的值以优先级高的为准，不同的属性被保留。


## 属性配置提示消失

首先，提示是由开发工具提供的（例如：IDEA）。 则说明当前配置文件不被认可，需要手动添加：`File`-> `Project Structure`  --> `Facets` --> `Customize Spring Boot...` -->  `+`，然后选择需要添加的配置文件

