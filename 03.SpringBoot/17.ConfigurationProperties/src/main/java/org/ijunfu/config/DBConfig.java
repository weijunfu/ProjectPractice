package org.ijunfu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Title          数据库配置对象
 * @Description    读取数据库配置
 *
 * @author weijunfu<ijunfu@163.com>
 * @date 2022/01/20 13:03
 * @version 1.0.0
 *
 */
//@Configuration
@ConfigurationProperties(prefix = "db")
public class DBConfig {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DBConfig{" + "driverClassName='" + driverClassName + '\'' + ", url='" + url + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }
}
