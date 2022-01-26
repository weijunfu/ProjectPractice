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
