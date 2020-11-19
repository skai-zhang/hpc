# HPC 家庭私有云

## 启动方法

```
docker run -d -p 9000:9000 
              -e SPRING_PROFILES_ACTIVE=pro
              -v /var/run/docker.sock:/var/run/docker.sock 
              -v /data/hpc:/home/cnb/hpc
              --name HomePrivateCenter --restart=always hpc/hpc
```