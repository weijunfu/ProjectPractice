package org.ijunfu.quartz.config;

import org.ijunfu.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/29 23:20
 * @version 1.0.0
 *
 */

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail getJobDetail() {
        return JobBuilder
                .newJob(MyQuartz.class)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger getTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        return TriggerBuilder
                .newTrigger()
                .forJob(getJobDetail())
                .withSchedule(scheduleBuilder)
                .build();
    }
}
