package org.ijunfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        // 彻底关闭热启动
        System.setProperty("spring.devtools.restart.enabled", "false");

        SpringApplication.run(Application.class, args);
    }

}
