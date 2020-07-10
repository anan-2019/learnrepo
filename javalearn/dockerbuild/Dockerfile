#指定基础镜像，在其上进行定制
FROM java:8

#维护者信息
MAINTAINER anan-2019

#设置时区
RUN echo "Asia/Shanghai" > /etc/timezone

#添加上下文目录下的target/*.jar 到容器里  待会用maven打包后就会有文件了
ADD target/*.jar dockerbuild-1.0-SNAPSHOT.jar

#声明运行时容器提供服务端口，这只是一个声明，在运行时并不会因为这个声明应用就会开启这个端口的服务
EXPOSE 8080

#指定容器启动程序及参数   <ENTRYPOINT> "<CMD>"
ENTRYPOINT ["java","-jar","dockerbuild-1.0-SNAPSHOT.jar"]