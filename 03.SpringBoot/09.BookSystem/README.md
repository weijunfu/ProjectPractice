# 图书系统

## 技术栈
+ SpringBoot
+ MyBatis Plus
+ Druid
+ H2database

## 分页

```
@Bean
public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor());  // 开启分页
    return interceptor;
}
```
