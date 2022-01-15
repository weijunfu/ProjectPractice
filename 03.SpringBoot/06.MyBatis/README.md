# 整合 MyBatis

## 配置

### 核心配置
数据库连接相关信息，即连哪种数据库，连接哪个数据库，拥有什么权限？

### 映射配置
SQL映射，可通过XML和注解两种方式进行配置。

## 步骤

> 选用注解方式

### 1. 引入数据库驱动
```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <version>2.0.206</version>
    <scope>runtime</scope>
</dependency>
```

### 2. 引入 Mybatis
```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.2.1</version>
</dependency>
```

### 3. 编写配置文件
```yaml
spring:
  application:
    name: MyBatis&H2database              # 项目名称
  datasource:
    driver-class-name: org.h2.Driver      # 数据库驱动
    url: jdbc:h2:file:~/test              # 数据库连接地址
    username: sa                          # 数据库用户名
    password:                             # 数据库密码
  h2:
    console:
      enabled: true                       # 启用 H2数据库控制台
      path: /h2-console                   # H2数据库控制台访问地址

```

### 4. 创建实体类
```java
public class Book {

    private Integer id;
    private String type;
    private String name;
    private String remarks;

    // 省略Getter、Setter、ToString等方法
}
```

### 5. 创建 Dao 接口

```java
@Mapper
public interface BookDao {

    /**
     *
     * @Title       getBookById
     * @Description 查询指定图书
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/15 23:28
     * @version     1.0.0
     * @param 		id
     * @Return      org.ijunfu.domain.Book
     */
    @Select("select * from tb_book where id=#{id}")
    public Book getBookById(Integer id);

    /**
     *
     * @Title       save
     * @Description 新增图书
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/15 23:29
     * @version     1.0.0
     * @param 		book
     * @Return      void
     */
    @Insert("insert into tb_book(type, name, remarks) values(#{type}, #{name}, #{remarks})")
    public void save(Book book);

    /**
     *
     * @Title       insert
     * @Description 新增图书，并返回其ID
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/15 23:29
     * @version     1.0.0
     * @param 		book
     * @Return      void
     */
    @Insert("insert into tb_book(type, name, remarks) values(#{type}, #{name}, #{remarks})")
    @Options(useGeneratedKeys=true, keyProperty = "id", keyColumn = "id")
    public void insert(Book book);
}
```

### 6. 创建测试类
```java
@SpringBootTest
class BookDaoTest {
    final static Logger log = LoggerFactory.getLogger(BookDaoTest.class);

    @Autowired
    private BookDao bookDao;

    @Test
    void getBookById() {
        Book book = bookDao.getBookById(1);

        log.info("{}", book);
    }

    @Test
    void save() {
        Book book = new Book();
        book.setName("Java 核心技术");
        book.setType("Java");
        book.setRemarks("原名：Core Java 作者：凯 S.霍斯特曼 (Cay S. Horstmann)");

        bookDao.save(book);
    }

    @Test
    void insert() {
        Book book = new Book();
        book.setName("人月神话(40周年中文纪念版)");
        book.setType("软件开发");
        book.setRemarks("清华大学出版社出版，外文书名: The Mythical Man-Month:Essays on Software Engineering Anniversary Edition，作者：小弗雷德里克·布鲁克斯 (Frederick P.Brooks)");

        bookDao.insert(book);

        log.info("{}: {}", book.getId(), book);
    }
}
```