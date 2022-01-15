# 整合 JUnit

> 使用Spring initializr创建项目，默认已导入测试依赖，若其它途径创建项目，则需要手动导入依赖

## 步骤

### 1. 导入依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

### 2.创建接口
```java
public interface BookDao {
    public void save();
}
```

### 3. 创建实现类
```java
@Repository
public class BookDaoImpl implements BookDao {

    final static Logger log = LoggerFactory.getLogger(BookDaoImpl.class);

    @Override
    public void save() {

        log.info("保存图书成功");
    }
}
```


### 4. 创建测试类
```java
@SpringBootTest
class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void save() {
        bookDao.save();
    }
}
```

### 5. 运行测试类

运行测试类中的`save`方法，如果程序运行未报错，且能够输出打印“保存图书成功”，则说明此次测试成功执行。

需要注意的是如果测试类不在引导类（*Application.java）包及其子包下，则测试必须为`@SpringBootTest`的`classes`指定引导类的class。
例如：
```java
@SpringBootTest(classes = Application.class)
class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void save() {
        bookDao.save();
    }
}
```