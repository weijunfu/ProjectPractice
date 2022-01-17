package org.ijunfu.config;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.util.List;

/**
 *
 * @Title          Jackson 消息转换器
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/17 14:21
 * @version 1.0.0
 *
 */

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