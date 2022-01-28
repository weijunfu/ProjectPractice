# 缓存

## 介绍

`缓存`是一种介于**数据永久存储介质**与**数据应用**之间的数据***临时存储介质***。

+ 使用缓存可以有效的减少低速数据读取过程的次数（例如：IO），以提高系统性能。
+ 缓存不仅可以用于提高永久性存储介质的数据读取效率，还可以提供临时的数据存储空间。

`SpringBoot`提供的缓存技术除了提供默认的缓存方案，还可以对其它缓存技术进行整合，统一接口，方便缓存技术的开发和管理。

## 使用

### 1. 引入依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
```

### 2. 启用缓存
`@EnableCaching`用于启用缓存。

```java
@EnableCaching
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

```

### 3. 配置缓存
```java
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/{id}")
    @Cacheable(value = "book_id_cache", key = "#id")
    public Book getById(@PathVariable Long id) {
        return bookService.getById(id);
    }
}
```

## ehcache

SpringBoot 整合 ehcache 步骤：

### 1. 引入依赖
```xml
<dependency>
    <groupId>net.sf.ehcache</groupId>
    <artifactId>ehcache</artifactId>
</dependency>
```

### 2. 配置
```yaml
spring:
  cache:
    type: ehcache
```

### 3. Ehcache配置
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:noNamespaceSchemaLocation="http:///ehcache.org/ehcache.xsd"
        updateCheck="false">

    <!-- 存储路径，缓存持久化到硬盘时使用 -->
    <diskStore path="D:/temp/cache" />

    <!-- 默认缓存策略 -->
    <!-- external：是否永久存在，值为true则不会被清除，此时与timeout冲突，通常设置为false-->
    <!-- diskPersistent：是否启用磁盘持久化-->
    <!-- maxElementsInMemory：最大缓存数量-->
    <!-- overflowToDisk：超过最大缓存数量是否持久化到硬盘-->
    <!-- timeToLiveSeconds：最大存活时间-->
    <!-- timeToIdleSeconds：最大不活动间隔，设置时间过长缓存容易溢出，设置过短无效果，可用于记录时效性数据，例如验证码-->
    <!-- memoryStoreEvictionPolicy：缓存清除策略-->
    <defaultCache eternal="false"
        diskPersistent="false"
        maxElementsInMemory="1000"
        overflowToDisk="false"
        timeToIdleSeconds="60"
        timeToLiveSeconds="60"
        memoryStoreEvictionPolicy="LRU"
    />

    <!-- 短信缓存 -->
    <cache
        name="smsCode"
        eternal="false"
      diskPersistent="false"
      maxElementsInMemory="1000"
      overflowToDisk="false"
      timeToIdleSeconds="10"
        timeToLiveSeconds="10"
      memoryStoreEvictionPolicy="LRU"
    />

</ehcache>
```

## 数据淘汰策略

+ `volatile-lru`: 挑选最近最少使用的数据淘汰
+ `volatile-lfu`: 挑选最近使用次数最少的数据淘汰
+ `volatile-ttl`: 挑选将要过期的数据淘汰
+ `volatile-random`: 任意选择数据淘汰


## 使用Redis做缓存

SpringBoot 整合 Redis 步骤：

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
  cache:
    type: redis
    redis:
      use-key-prefix: true    # 是否使用key前缀
      key-prefix: ssm_        # key 前缀，
      cache-null-values: false  # 是否缓存null值
      time-to-live: 10s   # 活跃时间
  redis:
    host: ...
    port: ...
    password: ...
```


## memcached 

### 安装 & 配置（1.4.4）

#### 安装
```shell
memcached.exe -d install
```

#### 启动 & 停止
```shell
# 启动
memcached.exe -d start

# 停止
memcached.exe -d stop
```

#### 卸载

```shell
memcached.exe -d uninstall
```

### 客户端
+ Memcached Client for Java: 最早期客户端，稳定可靠，用户群广
+ SpyMemcached：效率更高
+ XmemCached：并发处理更好

SpringBoot未提供对`memcached`的整合，需要使用硬编码方式实现客户端初始化管理。

### SpringBoot 整合 Memcached

#### 1. 引入依赖

```xml
<dependency>
    <groupId>com.googlecode.xmemcached</groupId>
    <artifactId>xmemcached</artifactId>
    <version>2.4.7</version>
</dependency>
```

#### 2. 参数配置
```yaml
xmemcached:
  servers: localhost:11211
  poolSize: 10
  opTimeout: 3000
```

```java
@Data
@Configuration
@ConfigurationProperties(prefix = "xmemcached")
public class XMemcachedProperties {

    private String servers;
    private int poolSize;
    private long opTimeout;
}
```

#### 3. 初始化配置
```java
@Configuration
public class XMemcachedConfig {

    @Autowired
    private XMemcachedProperties xMemcachedProperties;

    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {

        MemcachedClientBuilder builder = new XMemcachedClientBuilder(xMemcachedProperties.getServers());
        builder.setConnectionPoolSize(xMemcachedProperties.getPoolSize());
        builder.setOpTimeout(xMemcachedProperties.getOpTimeout());

        MemcachedClient client = builder.build();
        return client;
    }
}
```

#### 4. 存入缓存
```java
@Slf4j
@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    SMSCodeService smsCodeService;

    @Autowired
    MemcachedClient memcachedClient;

    @GetMapping
    public String getCode(String tel) {
        String code = smsCodeService.send(tel);

        try {
            // 存入缓存
            memcachedClient.set(tel, 10, code);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{}", e.getMessage());
        }

        return code;
    }
}
```

#### 5. 从缓存中读取数据
```java
@Slf4j
@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    SMSCodeService smsCodeService;

    @Autowired
    MemcachedClient memcachedClient;

    @GetMapping
    public String getCode(String tel) {
        String code = smsCodeService.send(tel);

        try {
            memcachedClient.set(tel, 10, code);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{}", e.getMessage());
        }

        return code;
    }

    @PostMapping
    public Boolean checkCode(@RequestBody SMSCode smsCode) {

        try {
            // 从缓存中读取数据
            String code = memcachedClient.get(smsCode.getTel()).toString();

            return smsCode.getCode().equals(code);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{}", e.getMessage());
        }

        return false;
    }
}
```

