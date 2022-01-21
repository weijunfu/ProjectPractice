package org.ijunfu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/21 22:21
 * @version 1.0.0
 *
 */

@Validated
@Configuration
@ConfigurationProperties(prefix = "user")
public class UserConfig {

    private String name;

    @Max(value = 120, message = "年龄太大")
    @Min(value = 0, message = "年龄太小")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserConfig{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
