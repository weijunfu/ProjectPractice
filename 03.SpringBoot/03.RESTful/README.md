# Rest 风格

REST（Representational State Transfer）表现形式状态转换。

**传统**风格资源形式：

```
/book/getUserById?id=1

/book/saveUser
```


**REST**风格资源形式：

```
/books/1

/books
```


REST风格优点：

+ 隐藏资源的访问行为，无法通过地址得知对资源是何种操作
+ 书写简化


那怎么区分资源的行为呢？

按照REST风格访问资源时，我们使用**行为动作**区分对资源进行了何种操作。例如：

```
# 查询全部用户信息
[GET] /books

# 查询指定用户信息
[GET] /books/1

# 添加用户信息
[POST] /books

# 修改用户信息
[PUT] /books

# 删除指定用户
[DELETE] /books/1

```


**注意**：

上述行为时约定方式，约定不是规范，可以打破，所以称为REST风格，而不是REST规范。

描述模块的名称通常使用复数，也就是加s，表示此类资源，而非单个资源。例如：users、books……


根据REST风格对资源进行访问称为RESTful。


## 接口测试
> 使用IDEA自带的HTTP工具进行测试

### 查询所有图书
GET http://localhost:8080/books

Accept: application/json

### 查询指定图书

GET http://localhost:8080/books/1

Accept: application/json

### 添加图书
POST http://localhost:8080/books

Content-Type: application/json

{
"name": "中国近代史",
"author": "未知"
}

### 修改图书
PUT http://localhost:8080/books

Content-Type: application/json

{
"name": "朝花夕拾",
"author": "鲁迅"
}


### DELETE
DELETE http://localhost:8080/books/1

Accept: application/json
