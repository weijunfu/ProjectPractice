# SpringBoot 项目

## 项目列表

+ [01.HelloWorld](./01.HelloWorld)
+ [02.Banner](./02.Banner)
+ [03.RESTful](./03.RESTful)
+ [04.Configuration](./04.Configuration)
+ [05.JUnit](./05.JUnit)
+ [06.MyBatis](./06.MyBatis)
+ [07.MyBatisPlus](./07.MyBatisPlus)
+ [08.Druid](./08.Druid)
+ [09.BookSystem](./09.BookSystem)

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