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


## 错误


### No converter found for return value of type

问题原因：类属性未提供 Getter 和 Setter
解决：补全 Getter 和 Setter