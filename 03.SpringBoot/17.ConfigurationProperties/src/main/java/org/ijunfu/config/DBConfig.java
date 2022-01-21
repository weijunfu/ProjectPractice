package org.ijunfu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

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

    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeout;

    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;

    public Duration getServerTimeout() {
        return serverTimeout;
    }

    public void setServerTimeout(Duration serverTimeout) {
        this.serverTimeout = serverTimeout;
    }

    public DataSize getDataSize() {
        return dataSize;
    }

    public void setDataSize(DataSize dataSize) {
        this.dataSize = dataSize;
    }

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
        return "{" + "driverClassName='" + driverClassName + '\'' + ", url='" + url + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + ", serverTimeout=" + serverTimeout + ", dataSize=" + dataSize + '}';
    }
}
