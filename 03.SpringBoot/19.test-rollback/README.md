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

# 测试中随机数的使用
测试用例数据通常采用随机值进行测试，使用SpringBoot提供的随机数为其赋值
```yaml
testcase:
  book:
    id: ${random.int(10,100)}   # 10~100 内随机数
    name: ${random.value} # 随机字符串
    uuid: ${random.uuid} # 随机UUID
    publishTime: ${random.long} # 随机整数
```

+ `${random.int}`: 随机整数
+ `${random.int(10)}`: 10以内的随机数
+ `${random.int(10,100)}`: 10~100以内的随机数，且`,`后不能添加空格，否则报错`NumberFormatException`

须注意的是，其中的`()`可以是任意字符，例如`[]`,`!!`等，但不能使用特殊字符，例如`-`。
