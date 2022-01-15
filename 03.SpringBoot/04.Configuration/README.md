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


## Yaml

Yaml（YAML Ain't Markup Language）一种数据序列化格式。

**优点**
+ 容易阅读
+ 容易与脚本语言交互
+ 以数据为核心，重数据轻格式

YAML文件扩展名为：
+ `*.yml` (主流)
+ `*.yaml`


### Yaml 语法规则
+ 大小写敏感
+ 属性层级关系使用多行描述，每行结尾使用冒号结束
+ 使用缩进表示层级关系，同层级左侧对齐，只允许使用空格（不允许使用Tab键）
+ 属性值前面添加空格（属性名与属性值之间使用`冒号+空格`作为分隔）
+ `#`表示注释

核心规则：**数据前面要加空格与冒号隔开**


需注意的是，不允许同名属性.


### Yaml支持的数据类型

+ 单一属性值（字面量）
```yaml
boolean: TRUE                         # TRUE, True, true, FALSE, False, false 均可
float: 3.14                           # 支持科学计数法
int: 18                               # 支持二进制、八进制、十进制和十六进制
null: ~                               # ~ 表示 null
string: Hello                         # 字符串可以直接书写，但特殊字符串必须使用双引号包裹
date: 2022-01-15                      # 日期，格式必须为 yyyy-MM-dd
datetime: 2022-01-15T17:52:52+08:00   # 时间和日期之间使用T相连，最后使用+表示时区
```
+ 复杂属性值
  + 数组
  ```yaml
  likes: 
    - game
    - music
    - sleep
  
  # 简写形式
  type: [root, admin, vip, user]
  
  users2:
    - name: ijunfu
      age: 18
    - name: wei
      age: 16
  
  # 简写形式
  users3: [{name:ijunfu, age:18}, {name:wei, age:16}]
  ```
  + 对象
  ```yaml
  user: 
   name: ijunfu
   age: 18
  ```
  
### Yaml 数据读取
在SpringBoot中，使用`@Value`注解读取单个属性值，引用方式为：`${x.xx...}`。
例如：
```
@Value("${likes[1]}")
private String like;
```

### 定义变量
```yaml
dir: /data
logPath: ${dir}/logs/
```

### 转义字符
当使用双引号包括字符串时，其中的转义字符将被解析，即转义字符必须使用双引号包裹。例如：
```yaml
# 转义字符
titles: "id\tname\tage\tphone"
```

### Environment
SpringBoot将yaml文件的配置项全部封装到`Environment`对象中。使用时可以直接使用其`getProperty`属性获取值。例如：
```
@Autowired
private Environment env;


log.info("{}", env.getProperty("user.name"));
```

### 使用配置类读取配置文件
步骤：
+ 创建配置类，且配置属性与该类属性名必须一致
+ 添加注解`@Configuration`，表明这是个配置类
+ 添加注解`@ConfigurationProperties`，并设置其`prefix`属性值，表明应该读取哪一组数据

例如：
```java
@Configuration
@ConfigurationProperties(prefix="datasource")
public class MyDataSource {
  private String driver;
  private String url;
  private String username;
  private String password;

}
```

```yaml
# 创建类用于封装以下数据
datasource:
  driver: com.mysql.jdbc.Driver
  url: jdbc:mysql://localhost:3306/db
  username: root
  password: 123456
```

使用：
```
@Autowired
private MyDataSource myDataSource;
    
log.info("{}", myDataSource);
```