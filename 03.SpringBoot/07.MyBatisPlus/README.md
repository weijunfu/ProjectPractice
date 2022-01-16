# 整合 MyBatis-Plus

## 步骤

### 1. 引入驱动
```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

### 2. 引入 MyBatis
```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.4.2</version>
</dependency>
```

### 3. 修改配置文件

```sql
# schema.sql
DROP TABLE IF EXISTS tb_user;

CREATE TABLE tb_user(
    id    BIGINT(20)  NOT NULL COMMENT '主键ID',
    name  VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age   INT(11)     NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);
```

```sql
# data.sql
DELETE FROM tb_user;

INSERT INTO tb_user (id, name, age, email) VALUES
                                               (1, 'Jone', 18, 'test1@baomidou.com'),
                                               (2, 'Jack', 20, 'test2@baomidou.com'),
                                               (3, 'Tom', 28, 'test3@baomidou.com'),
                                               (4, 'Sandy', 21, 'test4@baomidou.com'),
                                               (5, 'Billie', 24, 'test5@baomidou.com');
```

```yaml
spring:
  datasource:
    driver-class-name: org.h2.Driver
    url: jdbc:h2:mem:mp;DB_CLOSE_DELAY=-1
    username: sa
    password: 123456
    schema: classpath:schema.sql
    data: classpath:data.sql

  h2:
    console:
      enabled: true
      path: /h2-console
    settings:
      web-allow-others: true

mybatis-plus:
  global-config:
    db-config:
      table-prefix: tb_
```

### 4. 创建实体类
```java
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private String email;

    // 省略 Getter Setter ToString...
}
```

### 5. 创建Mapper
```java
@Mapper
public interface UserDao extends BaseMapper<User> {

}
```

### 6. 测试
```java
@SpringBootTest
class UserDaoTest {

    final static Logger log = LoggerFactory.getLogger(UserDaoTest.class);

    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        List<User> userList = userDao.selectList(null);

        log.info("{}: {}", userList.size(), userList);
    }

}
```

