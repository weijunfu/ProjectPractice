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

### 1. 常用注解

#### 1. 主键 `@TableId`
```java
@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;            // 主键
    private String username;        // 姓名
    private Byte age;           // 年龄
    private String email;       // 邮箱
    private Long managerId;    // 直属上级ID
    private Date createTime;   // 创建时间
}
```
#### 2. 类属性与表字段映射`@TableField`
```java
@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;            // 主键
    @TableField("name")
    private String username;        // 姓名
    private Byte age;           // 年龄
    private String email;       // 邮箱
    private Long managerId;    // 直属上级ID
    private Date createTime;   // 创建时间
}
```

#### 3. 排除字段的三种方式

##### 3.1 `transient` 修饰
```java
@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;            // 主键
    @TableField("name")
    private String username;        // 姓名
    private Byte age;           // 年龄
    private String email;       // 邮箱
    private Long managerId;    // 直属上级ID
    private Date createTime;   // 创建时间

    private transient String ext1;
}
```
##### 3.2 静态属性
```java
@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;            // 主键
    @TableField("name")
    private String username;        // 姓名
    private Byte age;           // 年龄
    private String email;       // 邮箱
    private Long managerId;    // 直属上级ID
    private Date createTime;   // 创建时间

    private transient String ext1;
    private static String ext2;

    public static String getExt2() {
        return ext2;
    }

    public static void setExt2(String ext2) {
        User.ext2 = ext2;
    }
}
```

##### 3.3 `@TableField(exist = false)`
```java

@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;            // 主键
    @TableField("name")
    private String username;        // 姓名
    private Byte age;           // 年龄
    private String email;       // 邮箱
    private Long managerId;    // 直属上级ID
    private Date createTime;   // 创建时间

    private transient String ext1;
    private static String ext2;

    @TableField(exist = false)
    private String ext3;

    public static String getExt2() {
        return ext2;
    }

    public static void setExt2(String ext2) {
        User.ext2 = ext2;
    }
}

```

### 2. 查询

#### 2.1 通过ID查询
```
User user = mapper.selectById(2);
System.out.println(user);
```

#### 2.2 通过ID列表，查询所有ID值在列表中的数据
```
List<Integer> ids = Arrays.asList(1, 2);
mapper.selectBatchIds(ids);
```

#### 2.3 使用Map传入参数，获取结果列表
```
Map<String, Object> columnsMap = new HashMap<>();
columnsMap.put("id", 1);
columnsMap.put("name", "root");
List<User> users = mapper.selectByMap(columnsMap);
System.out.println(users);
```
必须注意的是，`Map`中的`Key`为数据库表中的列字段。

#### 2.4 分页查询


##### 配置分页

```java
@Configuration
public class MybatisPlusConfig {

    // 分页
    @Bean
    public MybatisPlusInterceptor paginationInnerInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
```

需注意的是，此时采用的是最新版分页配置，如果使用旧版本，请采用以下方式：
```
@Bean
public PaginationInterceptor paginationInterceptor() {
    PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
    // paginationInterceptor.setOverflow(false);
    // 设置最大单页限制数量，默认 500 条，-1 不受限制
    // paginationInterceptor.setLimit(500);
    // 开启 count 的 join 优化,只针对部分 left join
    paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
    return paginationInterceptor;
}
```

##### 测试

```
QueryWrapper<User> queryWrapper = new QueryWrapper<>();

Page<User> page = new Page<>(1, 2);

mapper.selectPage(page, queryWrapper);
log.info("{} {} {}", page.getPages(), page.getSize(), page.getTotal());

List<User> userList = page.getRecords();
log.info("{}", userList);
```

#### 2.5 自定义分页

##### 定义分页方法
```
@Select("select * from tb_user ${ew.customSqlSegment}")
IPage<User> selectByPage(Page<User> page, @Param(Constants.WRAPPER)Wrapper<User> wrapper);
```

##### 测试
```
QueryWrapper<User> queryWrapper = new QueryWrapper<>();

Page<User> page = new Page<>(1, 2);

mapper.selectByPage(page, queryWrapper);

log.info("{} {} {}", page.getPages(), page.getSize(), page.getTotal());

List<User> userList = page.getRecords();
log.info("{}", userList);
```

### 3. ActiveRecord

#### 3.1 使用步骤
+ 继承`Model`
```java
@Data
public class User extends Model<User> {

    @TableId(type = IdType.AUTO)
    private Long id;            // 主键

    private String name;        // 姓名
    private Byte age;           // 年龄
    private String email;       // 邮箱
    private Long managerId;    // 直属上级ID
    private Date createTime;   // 创建时间
}
```
+ 测试
```java
@Slf4j
@SpringBootTest
@Rollback
class UserMapperWithARTest {
    
    @Test
    void insert() {
        User user = new User();
        user.setId(System.currentTimeMillis());
        user.setName("Demo");
        user.setManagerId(2l);

        boolean flag = user.insert();

        log.info("{}", flag);
    }

    @Test
    void selectById() {
        User user = new User();

        User u = user.selectById(2l);

        log.info("{} {}", user == u, u);
    }

    @Test
    void selectById2() {
        User user = new User();
        user.setId(2l);

        User u = user.selectById(user);
        log.info("{} {}", user == u, u);
    }

    @Test
    void updateById() {
        User user = new User();
        user.setId(2l);
        user.setEmail("admin@ijunfu.com");

        boolean flag = user.updateById();

        User u = user.selectById(user);

        log.info("{} {}", flag, u);
    }

    @Test
    void deleteById() {
        User user = new User();
        List<User> all = user.selectAll();
        log.info("{}", all);

        boolean ret = user.deleteById(1643788030697l);

        log.info("{}", ret);
    }
}
```

### 4. 主键策略

局部策略优先级高于全局策略。

#### 4.1 局部主键策略`@TableId`
```java
@Data
public class User extends Model<User> {

  @TableId(type = IdType.ASSIGN_ID)
  private Long id;            // 主键

  private String name;        // 姓名
  private Byte age;           // 年龄
  private String email;       // 邮箱
  private Long managerId;    // 直属上级ID
  private Date createTime;   // 创建时间
}
```

#### 4.2 全局主键策略
```yaml
mybatis-plus:
  global-config:
    db-config:
      id-type: assign_id
```


### 5. 通用Service


## 高级应用

### 1. 逻辑删除

#### 1.1 `@TableLogic` 
```java
@Data
public class Teacher {

    private String id;          // 主键
    private String name;        // 姓名
    private Integer age;        // 年龄
    private String email;       // 邮箱
    private String managerId;     // 直属上级ID
    private Integer version;        // 版本

    @TableLogic
    private Integer deleted;        // 是否删除
    private Date createTime;       // 创建时间
    private Date lastUpdateTime;  //最后更新时间
}
```

#### 2.1 测试
```
 List<Teacher> list = teacherMapper.selectList(null);
log.info("{}", list.size());

int ret = teacherMapper.deleteById(8);

list = teacherMapper.selectList(null);
log.info("{}", list.size());
```

`deleteById`实际执行的SQL语句为：`UPDATE tb_teacher SET deleted=1 WHERE id=8 AND deleted=0`