# 日志

## 作用
+ 编程期间可用于调试代码
+ 运营期间可用于记录信息
  + 记录日常运营重要信息（峰值流量、平均响应时间……）
  + 记录应用报错信息（错误堆栈）
  + 记录运维过程数据（扩容、宕机、报警……）

## 使用步骤
+ 创建日志对象
+ 调用日志方法，记录日志
代码如下：
```java
 @SpringBootApplication
public class Application {

    // 1. 创建日志对象
    private final static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        // 2. 调用日志方法，记录日志
        log.info("SpringBoot 已启动");
    }

}
```

## 日志级别
+ TRACE：运行堆栈信息，使用效率低
+ DEBUG：程序员调试代码使用
+ INFO：记录运维过程数据
+ WARN：记录运维过程报警数据
+ ERROR：记录错误堆栈信息
+ FATAL：灾难信息，合并记入ERROR

## 设置日志级别

### 开启Debug模式
> 将输出调试信息，常用于检查系统运行情况

```yaml
debug: true
```

### 设置日志级别
```yaml
logging:
  level:
    root: info
```

SpringBoot默认为info级别。
`root`表示根节点，即整体应用日志级别。

### 设置程序包的日志级别
```yaml
logging:
  level:
    org.ijunfu: debug
```

### 设置分组，对某个组设置日志级别
```yaml
logging:
  group:
    base: org.ijunfu.base       # base 组
    pay: com.aliyun, com.qq     # pay 组，多个包使用逗号分隔
  level:
    root: info
    base: warn                 # base 组日志级别
    pay: error                 # pay 组日志级别
```

## 优化日志创建代码

### 引入 lombok
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>
```

### 使用类注解`@Slf4j`
```java
@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        // 2. 调用日志方法，记录日志
        log.info("SpringBoot 已启动");
    }

}
```

## 设置日志输出格式

### 简单格式
```yaml
logging:
  pattern: 
    console: "%d - %m%n"
```

+ %d: 日期
+ %m: 消息
+ %n: 换行

### 复杂格式
```yaml
logging:
  pattern:
    console: "%d %clr(%5p) --- [%16t] %clr(%-40.40c){cyan} > %m%n"
```

+ %clr: 颜色 
+ %t: 线程
+ %c: 类名
+ -: 左对齐，默认右对齐
+ .num: 保留多少位

## 日志文件

### 设置日志文件
```yaml
logging:
  file:
    name: server.log
```

### 设置滚动日志文件
```yaml
logging:
  file:
    name: server.log
  logback:
    rollingpolicy:
      max-file-size: 4kb
      file-name-pattern: server.%d{yyyy-MM-dd}.%i.log
```