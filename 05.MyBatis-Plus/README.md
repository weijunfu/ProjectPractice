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