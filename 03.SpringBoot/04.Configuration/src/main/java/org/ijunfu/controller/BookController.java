package org.ijunfu.controller;

import org.ijunfu.configuration.MyDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Title          Book 控制类
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu@163.com>
 * @date 2022/01/15 17:58
 * @version 1.0.0
 *
 */

@RestController
@RequestMapping("/books")
public class BookController {

    final static Logger log = LoggerFactory.getLogger(BookController.class);


    @Value("${language}")
    private String lang;

    @Value("${user.name}")
    private String name;

    @Value("${likes[1]}")
    private String like;

    @Value("${logPath}")
    private String logPath;

    @Value("${titles}")
    private String titles;

    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String readProperties() {
        log.info("{}{}", "当前的语言环境：", lang);
        log.info("{}{}", "当前用户名：", name);
        log.info("{}{}", "第二爱好：", like);

        log.info("{}{}", "日志路径：", logPath);

        log.info("{}{}", "表格头：", titles);

        log.info("-----------------------------");

        log.info("{}", env.getProperty("user.name"));

        log.info("-----------------------------");

        log.info("{}", myDataSource);

        return "read Properties";
    }
}
