package org.ijunfu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 *
 * @Title          Spring MVC 配置
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/17 14:33
 * @version 1.0.0
 *
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     *
     * @Title       configureMessageConverters
     * @Description 消息转换器
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/17 14:40
     * @version     1.0.0
     * @param 		converters
     * @Return      void
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

        converters.add(new JacksonHttpMessageConverter());  // 注册 Jackson 消息转换器
    }
}
