链接:https://hub.docker.com/r/ashibatian/homework3/tags
1. tag:server eureka注册中心 docker run -p 8761:8761 -t ashibatian/homework3:server (右边端口号必须为8761) 
2 tag:function 登陆微服务 docker run -p 8762:8762 -t ashibatian/homework3:function (右边端口号必须为8762) 
3. tag:login 登陆微服务 docker run -p 8763:8763 -t ashibatian/homework3:login (右边端口号必须为8763) 
4. http://localhost:8762/login/?username=user&password=123456登陆
5. http://localhost:8762/user/word 查询(需要登陆)
