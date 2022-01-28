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
