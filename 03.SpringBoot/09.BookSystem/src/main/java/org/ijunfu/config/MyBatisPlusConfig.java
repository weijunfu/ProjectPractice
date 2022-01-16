package org.ijunfu.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Title          MyBatis Plus 配置类
 * @Description    配置MyBatis Plus相关
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/16 21:51
 * @version 1.0.0
 *
 */

@Configuration
public class MyBatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());  // 开启分页
        return interceptor;
    }
}
