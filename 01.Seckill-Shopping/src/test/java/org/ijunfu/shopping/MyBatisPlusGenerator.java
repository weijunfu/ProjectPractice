package org.ijunfu.shopping;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

/**
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @version 1.0.0
 * @Title <Title>
 * @Description <TODO>
 * @date 2022/01/07 23:06
 */

@SpringBootTest
public class MyBatisPlusGenerator {

    final static Logger logger = LoggerFactory.getLogger(MyBatisPlusGenerator.class);

    @Test
    public void generator() {
        String url = "jdbc:h2:file:~/SeckillShopping";                     //  数据库 URL
        String username = "san";                // 数据库用户名
        String password = "";                // 数据库用户密码

        logger.info("{} {} {}", url, username, password);

        // 项目目录下
        String pkgPath = System.getProperty("user.dir") + "/src/main/java";
        String mapperXml = System.getProperty("user.dir") + "/src/main/resources/mapper";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("weijunfu<ijunfu@163.com>")
                            .fileOverride()     // 覆盖文件
                            .outputDir(pkgPath);     // 输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("org.ijunfu.shopping")          // 包名
//                            .entity("entity")                       // entity 包名
//                            .mapper("mapper")                       // Mapper 包名
//                            .xml("mapper.xml")
//                            .service("service")                     // Service 包名
//                            .serviceImpl("service.impl")            // Service Impl 包名
//                            .controller("controller")               // Controller 包名

                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, mapperXml))   // Mapper配置文件路径
                            ;
                })
                .strategyConfig(builder -> {
                    builder.addInclude("T_USER")          // 需要生成的表名
                            .addTablePrefix("T_")     // 表前缀
//                            .addTableSuffix("")    // 表后缀
                    ;

                    builder.entityBuilder().enableRemoveIsPrefix(); // 去除表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine())     // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
