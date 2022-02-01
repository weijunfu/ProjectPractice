# MyBatis Plus 深入浅出教程

## 一、了解 `MyBatis Plus`


### 1.1 MyBatis VS JPA

#### MyBatis 

##### 优势
+ SQL语句可以自由控制，更灵活，性能更高
+ SQL与代码分离，易于阅读和维护

##### 劣势
+ 简单的CRUD操作还得写SQL
+ XML中有大量的SQL要维护
+ MyBatis自身功能很有限，但支持插件

#### JPA
+ 移植性比较好（JPQL）
+ 提供了很多CRUD方法、开发效率高
+ 对象化程度更高

### 1.2 `MyBatis Plus`介绍

`MyBatis Plus`（简称`MP`）是一个`MyBatis`的增强工具，在`Mybatis`的基础上只做增强不做改变，为简化开发、提高效率而生。

**官网**：[https://baomidou.com](https://baomidou.com)

### 1.3 架构

![架构](https://gitee.com/weijunfu/images/raw/master/typora/mybatis-plus-framework.jpg)


### 1.4 特性

+ 无侵入、损耗小、强大的CRUD操作
+ 支持Lambda形式调用、支持多种数据库
+ 支持主键自动生成、支持ActiveRecord模式
+ 支持自定义全局通用操作、支持关键词自动转义
+ 内置代码生成器、内置分页插件、内置性能分析插件
+ 内置全局拦截插件、内置SQL注入剥离器

## 二、lombok

### 2.1 引入依赖

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <scope>provided</scope>
</dependency>
```

### 2.2 常用注解

+ `@Data`：
  + `@ToString`：覆盖默认的`toString()`方法，可通过`of`属性限定显示字段，通过`exclude`属性排除某些字段
  + `@EqualsAndHashCode`：覆盖默认的`equals()`和`hashCode()`方法
  + `@Getter`/`@Setter`：生成所有成员变量的`getter`和`setter`方法
  + `@RequiredArgsConstructor`：生成构造函数
+ `@Slf4j`：为类提供一个属性名为`log`的日志对象

### 2.3 示例

```java
import lombok.Data;

@Data
public class User{
    private Integer uid;
    private String username;
}
```

## 快速入门小例子

