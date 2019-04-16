#基础镜像
FROM registry.ly-sky.com:5000/library/centos-jdk:1.8.25

#作者
MAINTAINER yutianlong yutianlong@ly-sky.com

#执行命令，主要用来安装相关的软件
#RUN 


#添加文件
ADD gen-admin/target/gen-admin.jar /usr/local

RUN chmod u+x /usr/local/gen-admin.jar

#挂载目录到容器
#VOLUME ["/data"]

#环境变量设置
#ENV 

#开放端口
EXPOSE 7890

#启动时执行的命令
CMD ["/bin/bash"]

#启动时执行的命令
ENTRYPOINT ["java","-jar","/usr/local/gen-admin.jar"]