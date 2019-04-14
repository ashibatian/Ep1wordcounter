# actuator and security
## 使用actuator and security重构了wordcounter
### security
打开浏览器，在运行 \src\main\java\wordcounter\ApplicationStartup.java后，在导航栏输入http://localhost:8080/users/word?showmore=0，
其中word可以替换为你要查找的单词，showmore=1时显示详细信息，其他情况只显示单词个数。
进入登陆页面
默认用户名为"user"
密码为"password"
用户名密码均正确后即可查看答案
### actuator
打开浏览器，在运行 \src\main\java\wordcounter\ApplicationStartup.java后，在导航栏输入http://localhost:8080/actuator/info, 返回app信息，输入http://localhost:8080/actuator/health,返回健康信息（实际上只有 status）
