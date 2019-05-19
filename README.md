# 一、jxc_system
一个进销存系统，spring boot+easyUI开发，系统可以进行二次开发
# 二、mysql安装部署文档
## 1、mysql下载地址：
mysql5.7：https://dev.mysql.com/get/Downloads/MySQL-5.7/mysql-5.7.26-winx64.zip
## **2、mysql安装**
### 以管理员身份打开 cmd 命令行工具，切换目录：

cd C:\web\mysql-8.0.11\bin
### 初始化数据库：

mysqld --initialize --console
### 执行完成后，会输出 root 用户的初始默认密码，如：

...
2018-04-20T02:35:05.464644Z 5 [Note] [MY-010454] [Server] A temporary password is generated for root@localhost: APWCY5ws&hjQ
...
APWCY5ws&hjQ 就是初始密码，后续登录需要用到，你也可以在登陆后修改密码。

### 输入以下安装命令：

mysqld install
### 启动输入以下命令开启服务即可：

net start mysql
注意: 在 5.7 需要初始化 data 目录：

cd C:\web\mysql-8.0.11\bin 
mysqld --initialize-insecure 
初始化后再运行 net start mysql 即可启动 mysql。

登录 MySQL
当 MySQL 服务已经运行时, 我们可以通过 MySQL 自带的客户端工具登录到 MySQL 数据库中, 首先打开命令提示符, 输入以下格式的命名:
mysql -u 用户名 -p
## **3、mysql修改默认密码**

首先安装后，执行任何指令都会提示：

ERROR 1820 (HY000): You must reset your password using ALTER USER statement before executing this statement.
可以用以下指令修改你密码为 123456。

ALTER USER 'root'@'localhost' IDENTIFIED BY '123456' PASSWORD EXPIRE NEVER;
之后使用以下指令刷新权限：

flush privileges;
注意指令末尾的分号。

退出后重新登陆。
## **4、mysql添加用户并授权**

MySQL5.7 mysql.user表没有password字段改 authentication_string；

### 一. 创建用户:
命令:CREATE USER 'username'@'host' IDENTIFIED BY 'password';

例子: CREATE USER 'dog'@'localhost' IDENTIFIED BY '123456';

        CREATE USER 'dog2'@'localhost' IDENTIFIED BY '';

PS：username - 你将创建的用户名,

host - 指定该用户在哪个主机上可以登陆，此处的"localhost"，是指该用户只能在本地登录，不能在另外一台机器上远程登录，如果想远程登录的话，将"localhost"改为"%"，表示在任何一台电脑上都可以登录;也可以指定某台机器可以远程登录;

password - 该用户的登陆密码,密码可以为空,如果为空则该用户可以不需要密码登陆服务器。

### 二.授权:
命令:GRANT privileges ON databasename.tablename TO 'username'@'host'

PS: privileges - 用户的操作权限,如SELECT , INSERT , UPDATE 等(详细列表见该文最后面).如果要授予所的权限则使用ALL.;databasename - 数据库名,tablename-表名,如果要授予该用户对所有数据库和表的相应操作权限则可用*表示, 如*.*.

例子: GRANT SELECT, INSERT ON mq.* TO 'dog'@'localhost';

### **三.创建用户同时授权**
mysql> grant all privileges on mq.* to test@localhost identified by '1234';
Query OK, 0 rows affected, 1 warning (0.00 sec)

mysql> flush privileges;
Query OK, 0 rows affected (0.01 sec)

PS:必须执行flush privileges; 

否则登录时提示：ERROR 1045 (28000): Access denied for user 'user'@'localhost' (using password: YES ) 

 

### 四.设置与更改用户密码
命令:SET PASSWORD FOR 'username'@'host' = PASSWORD('newpassword');

例子: SET PASSWORD FOR 'dog2'@'localhost' = PASSWORD("dog");

### 五.撤销用户权限
      命令: REVOKE privilege ON databasename.tablename FROM 'username'@'host';

     说明: privilege, databasename, tablename - 同授权部分.

      例子: REVOKE SELECT ON mq.* FROM 'dog2'@'localhost';

PS: 假如你在给用户'dog'@'localhost''授权的时候是这样的(或类似的):GRANT SELECT ON test.user TO 'dog'@'localhost', 则在使用REVOKE SELECT ON *.* FROM 'dog'@'localhost';命令并不能撤销该用户对test数据库中user表的SELECT 操作.相反,如果授权使用的是GRANT SELECT ON *.* TO 'dog'@'localhost';则REVOKE SELECT ON test.user FROM 'dog'@'localhost';命令也不能撤销该用户对test数据库中user表的Select 权限.

      具体信息可以用命令SHOW GRANTS FOR 'dog'@'localhost'; 查看.

### 六.删除用户
      命令: DROP USER 'username'@'host';

### 七.查看用户的授权
mysql> show grants for dog@localhost;
+---------------------------------------------+
| Grants for dog@localhost |
+---------------------------------------------+
| GRANT USAGE ON *.* TO 'dog'@'localhost' |
| GRANT INSERT ON `mq`.* TO 'dog'@'localhost' |
+---------------------------------------------+
2 rows in set (0.00 sec)

PS:GRANT USAGE:mysql usage权限就是空权限，默认create user的权限，只能连库，啥也不能干