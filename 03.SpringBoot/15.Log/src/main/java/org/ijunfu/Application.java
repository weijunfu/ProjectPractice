package org.ijunfu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        // 2. 调用日志方法，记录日志
        log.debug("debug: SpringBoot 已启动");
        log.info("info: SpringBoot 已启动");
        log.warn("warn: SpringBoot 已启动");
        log.error("error: SpringBoot 已启动");
    }

}
