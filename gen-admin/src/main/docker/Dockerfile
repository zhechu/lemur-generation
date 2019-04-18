#基础镜像
FROM 192.168.163.41:5000/library/centos-jdk:1.8.25

#作者
MAINTAINER lingyuwang ling-yu-wang@qq.com

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