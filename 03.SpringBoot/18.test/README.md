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