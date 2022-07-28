
### 开发环境部署

MySQL
```bash
$ mkdir -p /root/mysql/log
$ mkdir -p /root/mysql/data
$ mkdir -p /root/mysql/conf/

$ tee  /root/mysql/conf/my.cnf << EOF
[client]
default-character-set=utf8mb4

[mysqld]
character-set-server = utf8mb4
collation-server = utf8mb4_unicode_ci
init_connect='SET NAMES utf8mb4'
skip-character-set-client-handshake = true

[mysql]
default-character-set = utf8mb4
EOF

$ docker run -p 3306:3306 --name mysql \
-v /root/mysql/log:/var/log/mysql \
-v /root/mysql/data:/var/lib/mysql \
-v /root/mysql/conf/my.cnf:/etc/mysql/my.cnf \
-e MYSQL_ROOT_PASSWORD=admin.001 \
-d mysql:5.7 
```

Redis
```bash
$ mkdir -p /root/redis/data
$ mkdir -p /root/redis/conf

$ curl https://raw.githubusercontent.com/antirez/redis/4.0/redis.conf - O /root/redis/conf/redis.conf 

$ docker run -p 6379:6379 --name redis \
 -v /root/redis/data:/data \
 -v /root/redis/conf/redis.conf:/etc/redis/redis.conf \
 -d redis redis-server /etc/redis/redis.conf

```

Maven

配置阿里云
```xml
<mirrors>
    <mirror>
        <id>nexus-aliyun</id>
        <mirrorOf>central</mirrorOf>
        <name>Nexus aliyun</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </mirror>
</mirrors>
```
使用 JDK8 编译
```xml
<profiles>
    <profile>
    <id>jdk-1.8</id>
        <activation>
            <activeByDefault>true</activeByDefault>
            <jdk>1.8</jdk>
        </activation>
        <properties>
            <maven.compiler.source>1.8</maven.compiler.source>
            <maven.compiler.target>1.8</maven.compiler.target>
            <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
        </properties>
    </profile>
</profiles>
```

Idea Plugin

* lombok
* mybatis free

VSCode Plugin
* Vetur —— 语法高亮、智能感知、Emmet 等
  包含格式化功能， Alt+Shift+F （格式化全文），Ctrl+K Ctrl+F（格式化选中代码，两个 Ctrl
  需要同时按着）
* EsLint —— 语法纠错
* Auto Close Tag —— 自动闭合 HTML/XML 标签
* Auto Rename Tag —— 自动完成另一侧标签的同步修改
* JavaScript(ES6) code snippets — — ES6 语 法 智 能 提 示 以 及 快 速 输 入 ， 除 js 外 还 支
  持.ts，.jsx，.tsx，.html，.vue，省去了配置其支持各种包含 js 代码文件的时间
* HTML CSS Support —— 让 html 标签上写 class 智能提示当前项目所支持的样式
* HTML Snippets —— html 快速自动补全
* Open in browser —— 浏览器快速打开
* Live Server —— 以内嵌服务器方式打开
* Chinese (Simplified) Language Pack for Visual Studio Code ——


Nacos
```bash
$ docker run --name nacos -e MODE=standalone \ 
 -p 8848:8848 -p 9848:9848 、 
-d nacos/nacos-server:v2.0.4
```