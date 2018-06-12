### tomcat-redis-session-manager

> Tomcat 利用 Redis 实现 Session 共享

#### 使用步骤

1. 查看使用的tomcat版本，checkout对应分支代码，使用maven进行打包

2. 将打好的jar包连同 src/main/lib 目录下的两个jar包一共三个jar包上传至tomcat的lib目录下

3. 修改 TOMCAT_BASE/conf 目录下的 context.xml 文件
````
<Valve className="com.orangefunction.tomcat.redissessions.RedisSessionHandlerValve" />
<Manager className="com.orangefunction.tomcat.redissessions.RedisSessionManager"
         host="redis_host"
         port="6379"
         database="0"
         password="redis_password"
         maxInactiveInterval="60" />
````