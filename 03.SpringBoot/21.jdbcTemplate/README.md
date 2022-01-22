# SpringBoot JDBC 应用

## 使用步骤

### 1. 引入依赖
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

### 2. 初始化数据库
详见`db`目录下的数据库脚本文件。

### 3. 修改配置
```yaml
spring:
  h2:
    console:
      enabled: true     # 启用H2控制台
      path: /h2-console # h2 访问路径
      settings:
        web-allow-others: true
  datasource: # 数据库配置
    driver-class-name: org.h2.Driver
    url: jdbc:h2:mem:test
    username: sa
    password:
  sql:
    init: # 初始化SQL
      schema-locations: classpath*:db/schema.sql # 数据结构
      data-locations: classpath*:db/data.sql # 数据
      username: sa
      password:
  main:
    banner-mode: off  # 关闭Banner
  jpa:
    hibernate:
      ddl-auto: none

logging:
  level:
    root: info
    org.springframework.jdbc.datasource.init: debug # 检查初始化是否执行
```

此处需要注意观察程序启动后，是否执行初始化数据库脚本

### 4. 创建实体类
```java
@Data
public class Book {

    private Long id;
    private String name;
    private String author;
    private String publisher;
    private String remarks;
}
```

### 5. 实现DAO层（CRUD）
```java
@Repository
public class BookDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Book> queryAll() {
        String sql = "select * from tb_book";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Book.class));
    }

    public int save(Book book) {
        String sql = "insert into tb_book(name, author, publisher, remarks) values(:name, :author, :publisher, :remarks)";

        MapSqlParameterSource ps = new MapSqlParameterSource();
        ps.addValue("name", book.getName());
        ps.addValue("author", book.getAuthor());
        ps.addValue("publisher", book.getPublisher());
        ps.addValue("remarks", book.getRemarks());

        return jdbcTemplate.update(sql, ps);
    }

    public int update(Book book) {
        String sql = "update tb_book set name=:name, author=:author, publisher=:publisher, remarks=:remarks where id=:id";
        MapSqlParameterSource ps = new MapSqlParameterSource();
        ps.addValue("id", book.getId());
        ps.addValue("name", book.getName());
        ps.addValue("author", book.getAuthor());
        ps.addValue("publisher", book.getPublisher());
        ps.addValue("remarks", book.getRemarks());
        return jdbcTemplate.update(sql, ps);
    }

    public int delete(Long id) {
        String sql = "delete from tb_book where id=:id";
        MapSqlParameterSource ps = new MapSqlParameterSource();
        ps.addValue("id", id);
        return jdbcTemplate.update(sql, ps);
    }
}
```
+ `MapSqlParameterSource`：防止SQL注入