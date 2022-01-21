package org.ijunfu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Title          Druid 数据库连接池
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/21 17:05
 * @version 1.0.0
 *
 */

@Configuration
@EnableConfigurationProperties(DBConfig.class)
public class DruidConfig {

    /**
     *
     * @Title       dataSource
     * @Description 为第三方绑定属性
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/21 17:20
     * @version     1.0.0
     * @param
     * @Return      com.alibaba.druid.pool.DruidDataSource
     */
    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
}
