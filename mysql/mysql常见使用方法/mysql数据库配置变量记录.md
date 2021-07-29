# mysql数据库配置变量

## 查看数据库数据存放路径

~~~shell
SHOW GLOBAL VARIABLES LIKE '%datadir%';
~~~

## linux/windows环境下mysql默认配置

~~~shell
1、Linux下MySQL安装完后是默认：区分表名的大小写，不区分列名的大小写；

2、用root帐号登录后，在/etc/my.cnf 中的[mysqld]后添加添加lower_case_table_names=1，重启MYSQL服务（service mysqld restart），这时已设置成功：不区分表名的大小写；
 lower_case_table_names参数详解：  0：区分大小写，1：不区分大小写

3、MySQL在Linux下数据库名、表名、列名、别名大小写规则是这样的：

1、数据库名与表名是严格区分大小写的；

2、表的别名是严格区分大小写的；

3、列名与列的别名在所有的情况下均是忽略大小写的；

4、变量名也是严格区分大小写的；

MySQL在Windows下都不区分大小写。

~~~

