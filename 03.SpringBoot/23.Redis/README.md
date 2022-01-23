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

## Jedis

### 1. 引入依赖
```xml
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
</dependency>
```

### 2. 测试
执行上述`StringRedisTemplateTest`测试类中的方法即可。


## Lettcus & Jedis
+ Jedis采用直连的方式连接Redis服务器。当多线程模式下使用Jedis会存在线程安全问题，解决方案可以通过配置连接池使每个连接专用，这样整体性能就大受影响。
+ Lettcus是SpringBoot**默认**客户端。Lettcus基于Netty框架进行与Redis服务器连接，底层设计中采用`StatefulRedisConnection`。`StatefulRedisConnection`自身是线程安全的，可以保障并发访问安全问题，所以一个连接可以被多线程复用。
  当然Lettcus也支持多连接实例一起工作。