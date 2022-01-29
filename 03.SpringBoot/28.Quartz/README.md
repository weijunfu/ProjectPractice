# 定时任务

## 概念

### Job

工作（Job）用于定义具体执行的工作。

### JobDetail
工作明细（JobDetail）用于描述定时工作相关的信息。

### Trigger
触发器（Trigger）用于描述触发工作的规则，通常使用`cron`表达式定义调度规则。

### Scheduler
调度器（Scheduler）描述了工作明细与触发器的对应关系。

## 整合

### 1. 引入依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-quartz</artifactId>
</dependency>
```

### 2. 定义任务

```java
public class MyQuartz extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        System.out.println("run ...");
    }
}
```

### 3. 定义并绑定 JobDetail 和 Trigger

```java
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
```



## Spring Task

### 1. 开启定时任务
```java
@EnableScheduling       // 开启定时任务
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```

### 2. 设置定时执行的任务，并设定执行周期
```java
@Component
public class MyTask {

    @Scheduled(cron = "0/1 * * * * ?")
    public void print() {
        System.out.println("task run...   ");
    }
}
```

### 3. 任务配置
```yaml
spring:
  task:
    scheduling:
      pool:
        size: 10      # 线程池大小
      thread-name-prefix: sp_task_    # 线程前缀
      shutdown:
        await-termination: false  # 线程池关闭时，等待所有任务完成
        await-termination-period: 10s # 调度线程关闭之前，最大等待时间，确保最后一定关闭
```