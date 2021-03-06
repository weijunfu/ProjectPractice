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

## Jackson Null值处理

### 步骤


#### 1. 创建 Jackson消息转换器
```java
public class JacksonHttpMessageConverter extends MappingJackson2HttpMessageConverter  {

    /**
     * 处理字符串类型的null值，即将 null --> ''
     */
    public class NullStringJsonSerializer extends JsonSerializer<Object> {

        @Override
        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            jsonGenerator.writeString(StringUtils.EMPTY);
        }
    }

    class MyBeanSerializerModifier extends BeanSerializerModifier {
        @Override
        public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {

            for(BeanPropertyWriter writer : beanProperties) {

                Class<?> clazz = writer.getType().getRawClass();

                if(CharSequence.class.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz)) { // 字符串类型判断
                    writer.assignNullSerializer(new NullStringJsonSerializer());
                }
            }

            return beanProperties;
        }
    }

    JacksonHttpMessageConverter() {
        ObjectMapper mapper = getObjectMapper().setSerializerFactory(getObjectMapper().getSerializerFactory().withSerializerModifier(new MyBeanSerializerModifier()));
    }

}
```

#### 2. 向Spring中注册消息转换器
```java
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

        converters.add(new JacksonHttpMessageConverter());      // 注册 Jackson 消息转换器
    }
}
```

## 错误

### No converter found for return value of type

问题原因：类属性未提供 Getter 和 Setter
解决：补全 Getter 和 Setter