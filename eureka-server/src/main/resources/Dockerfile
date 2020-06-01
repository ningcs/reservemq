# 环境
FROM  williamyeh/java8:latest
# 作者信息
MAINTAINER ningcs "923507613@qq.com"
# 将本地文件tmp挂载到容器
VOLUME /tmp
# 拷贝jar
ADD eureka-server-1.0.jar /app.jar
# 设置暴露的端口号
EXPOSE 8081
# 执行命令
ENTRYPOINT ["java","-jar","/app.jar"]
