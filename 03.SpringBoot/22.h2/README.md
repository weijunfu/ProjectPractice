# 内嵌数据库

SpringBoot提供了三种内嵌数据库供开发者选择，以提高开发测试效率
+ H2
+ HSQL
+ Derby

## 应用步骤

### 1. 引入依赖
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

### 2. 配置
```yaml
spring:
  datasource:     # 数据源配置
    url: jdbc:h2:mem:test
    driver-class-name: org.h2.Driver
    username: sa
    password:
    hikari:
      maximum-pool-size: 50
  h2:
    console:  # H2database 控制台配置
      enabled: true
      path: /h2-console
      settings:
        trace: true
  jpa:
    show-sql: true    # 显示SQL
    hibernate:
      ddl-auto: update
  main:
    banner-mode: off # 关闭SpringBoot
```
### 3. 实体类
```java
@Data
@Entity
@Table(name = "tb_book")    // 定义表名
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    private String publisher;
    private String remarks;
}
```

### 4. DAO层
```java
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
```

### 5. 测试

```java
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void count() {
        long count = bookRepository.count();
        assertEquals(0l, count);
    }

    @Test
    void save() {
        Book book = new Book();
        book.setName("SpringBoot");
        book.setAuthor("ijunfu");
        book.setPublisher("wei");
        book.setRemarks("test");

        Book save = bookRepository.save(book);
        System.out.println(save);

        long count = bookRepository.count();
        assertEquals(1l, count);
    }
}
```

