# Redis

`Redis`是市面上常见的NoSQL解决方案之一。

`Redis`是一款`key-value`存储结构的内存级NoSQL数据库。

## 优点

+ 支持多种数据存储结构
+ 支持持久化
+ 支持集群

## 应用

### 1. 引入依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

### 2. 配置
```yaml
spring:
  main:
    banner-mode: off
  redis:
        host: localhost
    port: 14904
    password: 
```

### 3. 测试
```java
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    // 字符串
    @Test
    void setWithString() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("author", "ijunfu");
    }

    @Test
    void getWithString() {
        ValueOperations ops = redisTemplate.opsForValue();
        Object author = ops.get("author");
        System.out.println(author);
        Assertions.assertEquals("ijunfu", author.toString());
    }

    // Hash
    @Test
    void setWithHash(){
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("user", "name", "ijunfu");
    }

    @Test
    void getWithHash(){
        HashOperations ops = redisTemplate.opsForHash();
        Object name = ops.get("user", "name");
        System.out.println(name);
        Assertions.assertEquals("ijunfu", name.toString());
    }
}
```

## 客户端
`RedisTemplate`是以对象作为Key和Value，内部对数据进行序列化。

### String类型数据
```java
@SpringBootTest
public class StringRedisTemplateTest {

    @Autowired
    StringRedisTemplate redis;

    @Test
    void set() {
        ValueOperations<String, String> ops = redis.opsForValue();

        ops.set("age", "18");
    }

    @Test
    void get(){
        ValueOperations<String, String> ops = redis.opsForValue();
        String age = ops.get("age");
        System.out.println(age);

        Assertions.assertEquals("18", age);
    }
}
```
