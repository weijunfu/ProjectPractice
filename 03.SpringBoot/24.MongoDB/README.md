# MongoDB
`MongoDB`是一个开源、高性能、无模式的文档型数据库。NoSQL数据库产品中的一种，是最像关系型数据库的非关系型数据库。

## 应用场景

### 1. 淘宝用户数据
+ 存储位置：数据库
+ 特征：永久性存储，修改频度极低

### 2. 游戏装备数据、游戏道具数据
+ 存储位置：数据库、MongoDB
+ 特征：永久性存储与临时存储相结合、修改频度较高

### 3. 直播数据、打赏数据、粉丝数据
+ 存储位置：数据库、MongoDB
+ 特征：永久性存储与临时存储相结合，修改频度极高

### 4. 物联网数据
+ 存储位置：MongoDB
+ 特征：临时存储，修改频度飞速

## 应用步骤

### 1. 引入依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

### 2. 配置参数
```yaml
spring:
  main:
    banner-mode: off  # 关闭Banner
  data:
    mongodb:
      uri: mongodb+srv://<user>:<password>@<host>
```
+ user: 用户名
+ password：密码
+ host：MongoDB服务器地址

### 3. 测试
```java
@SpringBootTest
public class MongoDBTest {

    @Autowired
    MongoTemplate mongo;

    @Test
    void save() {
        Book book = new Book();
        book.setId(1l);
        book.setName("springboot");
        book.setAuthor("ijunfu");
        book.setPublisher("...");
        book.setRemarks("test");

        mongo.save(book);
    }

    @Test
    void find() {
        List<Book> books = mongo.findAll(Book.class);
        System.out.println(books);
    }
}
```

