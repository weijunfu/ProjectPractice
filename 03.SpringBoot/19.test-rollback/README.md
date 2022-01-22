# 业务层 数据回滚

## 步骤

### 1. 测试类上添加`@Transactional`，默认不提交事务
```java
@SpringBootTest
@Transactional
class BookServiceTest {
    
}
```
需注意的是，只有`@SpringBootTest`和`@Transactional`组合使用时，才默认不提交事务。

### 2. 若想在测试用例中提交事务，可以添加类注解`@Rollback`

+ `@Rollback(true)` 表示回滚
+ `@Rollback(false)` 不回滚，提交事务

```java
@SpringBootTest
@Transactional
@Rollback(false)
class BookServiceTest {
    
}
```