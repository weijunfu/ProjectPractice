# 测试

## 添加临时属性（两种模式）

### 第一种：properties属性模式
```java
@SpringBootTest(properties = {"test.author=ijunfu"})
class ApplicationTests {
    //...
}
```

### 第二种：args属性模式
> 可用于模拟命令行操作

```java
@SpringBootTest(args = {"--test.author=ijunfu"})
class ApplicationTests {
 // ...   
}
```

若，配置文件、properties属性和args属性同时配置相同参数，优先级从低到高为：配置文件 < properties属性 < args属性。

### 优势
比多环境开发中的测试环境影响范围更小，仅对当前测试类有效。

## 添加测试类专用配置
> 使用`@Import`可加载当前测试类专用的配置

### 配置类
```java
@Configuration
public class MsgConfig {

    @Bean
    public String msg() {
        return "test msg";
    }
}

```

### 测试类
```java
@SpringBootTest
@Import(MsgConfig.class)
public class MsgConfigTest {

    @Autowired
    private String msg;

    @Test
    public void testMsg() {
        Assertions.assertEquals("test msg", msg);
    }

}
```

## Web 测试

### 测试请求状态

#### Controller类
```java
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String all() {
        log.info("{}", "all is running...");
        return "query all books";
    }
}
```

#### 测试类
```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 定义Web环境
@AutoConfigureMockMvc   // 开启虚拟MVC
class BookControllerTest {

    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception {
        // 1. 定义请求地址
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 2. 执行请求
        ResultActions actions = mvc.perform(builder);

        // 3. 预计本次执行成功，状态值为200
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();

        // 4. 与期望值对比
        actions.andExpect(ok);
    }
}
```

### 测试请求返回值

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 定义Web环境
@AutoConfigureMockMvc   // 开启虚拟MVC
class BookControllerTest {
    
    @Test
    void testBody(@Autowired MockMvc mvc) throws Exception {
        // 1. 定义请求地址
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 2. 执行请求
        ResultActions actions = mvc.perform(builder);

        // 3. 预计本次调用返回值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher ret = content.string("query all books");

        // 4. 与期望值对比
        actions.andExpect(ret);
    }
}
```

### 测试请求返回值类型为JSON

#### 测试基类
```java
@Data
public class Book {

    private Integer id;
    private String name;
    private String author;
    private String type;
    private String remarks;
}
```

#### 测试Controller
```java
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {
    
    @GetMapping
    public Book getById() {
        log.info("{}", "all is running...");

        Book book = new Book();
        book.setId(100827);
        book.setName("SpringBoot 2.x");
        book.setAuthor("SpringBoot");
        book.setType("Java");
        book.setRemarks("官方出品，盗版必究");

        return book;
    }
}
```

#### 测试类
```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 定义Web环境
@AutoConfigureMockMvc   // 开启虚拟MVC
class BookControllerTest {

    @Test
    void testJSONBody(@Autowired MockMvc mvc) throws Exception {
        // 1. 定义请求地址
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 2. 执行请求
        ResultActions actions = mvc.perform(builder);

        // 3. 预计本次调用返回值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher ret = content.json("{\"id\": 100827,\n" + "\"name\": \"SpringBoot 2.x1\",\n" + "\"author\": \"SpringBoot\",\n" + "\"type\": \"Java\",\n" + "\"remarks\": \"官方出品，盗版必究\"}");

        // 4. 与期望值对比
        actions.andExpect(ret);
    }
}
```

### 测试响应头
```java
@Test
void testContentType(@Autowired MockMvc mvc) throws Exception {
    // 1. 定义请求地址
    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
    // 2. 执行请求
    ResultActions actions = mvc.perform(builder);

    // 3. 预计本次调用返回值
    HeaderResultMatchers header = MockMvcResultMatchers.header();
    ResultMatcher contentType = header.string("Content-Type", "application/json");

    // 4. 与期望值对比
    actions.andExpect(contentType);
}
```