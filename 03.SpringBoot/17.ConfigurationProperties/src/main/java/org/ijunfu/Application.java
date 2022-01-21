package org.ijunfu;

import com.alibaba.druid.pool.DruidDataSource;
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

        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        System.out.println(dataSource);
    }

}
