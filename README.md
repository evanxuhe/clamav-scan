clamav-scan
# 概述
基于[clamav](http://www.clamav.net/)杀毒引擎的在线文件杀毒应用

基于[clamav-client](https://github.com/solita/clamav-java)与Springboot开发
SpringBoot版本2.1.2

#安装clamd并开启TCP链接
```telnet 114.116.12.13 3310```

输入PING
返回PONG
则连接成功

> 在服务器上安装clamd客户端，开启TCP连接 监听3310端口
clamd本质是socket通信，因而文件较大时clamd服务端及客户端超时时间加长



# 测试
- IDEA选中该目录的pom.xml文件导入项目  
- application-dev.yml中host-name填写clamd的tcp地址  
- postman上传samples文件中的EICAR文件，其中包含了病毒样本代码测试(本身无毒)

POST localhost:8866/scan/file   
类型为form file字段添加上传的文件EICAR  
返回结果：  
```stream: Eicar-Test-Signature FOUND ```

控制台打印日志  
```文件[EICAR]查杀花费[912ms] 大小[68]Bytes 结果为[stream: Eicar-Test-Signature FOUND ]```
#未来计划
加入杀毒日志
整合fastdfs存储


# 联系作者
evanxuhe@163.com


