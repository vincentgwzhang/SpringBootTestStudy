这是一个 SpringBoot 做测试得所有各个层面的例子


How to release to beanstalk:
1, 修改 pom.xml 文件，修改 JDK 编译目标
2, 修改服务器端口设置
3, 打包 Web 工程
4, 部署到 AWS Elastic Beanstalk
5, 动作确认

```bash
# 打包 Docker 镜像, 本地运行
# docker pull amazoncorretto:17.0.2
$ docker build -t vincentgwzhang/springboot-web:latest .
$ docker image ls
$ docker run --rm --name springboot-web -p 8080:5000 vincentgwzhang/springboot-web:latest

# 推送 Docker 镜像到 DockerHub
$ docker push vincentgwzhang/springboot-web:latest
>https://hub.docker.com/u/vincentgwzhang

# 在 EC2 上运行 Docker 容器
$ sudo docker pull vincentgwzhang/springboot-web:latest
$ sudo docker image ls
$ sudo docker run --rm --name springboot-web -p 80:5000 vincentgwzhang/springboot-web:latest
```