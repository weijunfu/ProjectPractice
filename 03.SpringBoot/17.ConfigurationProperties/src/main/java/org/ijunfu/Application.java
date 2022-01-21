package org.ijunfu;

import org.ijunfu.config.DBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        DBConfig dbConfig = context.getBean(DBConfig.class);
        System.out.println(dbConfig);

    }

}
