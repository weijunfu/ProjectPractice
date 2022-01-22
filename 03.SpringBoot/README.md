# SpringBoot 项目

## 项目列表

+ [01.快速创建SpringBoot项目](./01.HelloWorld)
+ [02.SpringBoot中Banner相关配置](./02.Banner)
+ [03.REST风格&RESTful](./03.RESTful)
+ [04.SpringBoot相关配置](./04.Configuration)
+ [05.单元测试](./05.JUnit)
+ [06.整合MyBatis](./06.MyBatis)
+ [07.整合Mybatis Plus](./07.MyBatisPlus)
+ [08.整合Druid](./08.Druid)
+ [09.项目实战图书管理系统](./09.BookSystem)
+ [10.基于Yaml实现单文件的多环境配置](./10.MultiEnvWithSingletonFile)
+ [11.基于Yaml实现多文件多环境配置](./11.MultiEnvWithFilesForYaml)
+ [12.基于Properties实现多文件多环境配置](./12.MultiEnvWithFilesForProperties)
+ [13.多环境配置的分组管理](./13.MultiEnvWithGroup)
+ [14.Maven兼容SpringBoot多环境](./14.MuitiEnvWithMaven)
+ [15.日志的简单应用](./15.Log)
+ [16.热部署](./16.hotDeploy)
+ [17.配置的高级应用](./17.ConfigurationProperties)
+ [18.测试应用](./18.test)
+ [19.业务层回滚 & 随机数应用](./19.test-rollback)

# 扩展

## Windows操作系统端口被占用解决方案

```shell

# 查询端口
netstat -ano

# 查询指定端口
netstat -ano | findstr "<str>"

# 查询80端口
netstat -ano | findstr "80"

# 根据进程 PID查询进程名称
tasklist | findstr "1024"

# 杀死指定进程
taskkill /F /PID "1024"

# 根据进程名称杀死任务
taskkill -f -t -im "java.exe"

```


## Linux 操作系统后台启动Jar

```shell
nohup java -jar *.jar > serve.log 2>&1 &
```


## Linux 操作系统杀死线程
```shell
# 查找 运行的jar
ps aux | grep "java -jar"

# 杀死 线程
kill -9 1024      # 1024 为线程ID
```

## Jar运行时配置临时属性

格式：
```shell
java -jar *.jar --key=value
```

例如：
```shell
java -jar *.jar --server.port=80
```