package org.ijunfu.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/29 23:35
 * @version 1.0.0
 *
 */

@Component
public class MyTask {

    @Scheduled(cron = "0/1 * * * * ?")
    public void print() {
        System.out.println("task run...   ");
    }
}
