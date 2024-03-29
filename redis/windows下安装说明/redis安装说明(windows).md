# redis安装说明

[TOC]

## 1.安装说明：

```
  由于redis 官网只提供Linux版本的下载，只能在GitHub上下载；

  GitHub的下载地址： https://github.com/MSOpenTech/redis/tags

```

## 2.安装步骤：

```
   下载下来解压到本地后由cmd 进入到redis 安装目录下，执行以下命令，确认redis是否安装成功 redis-server redis.windows.conf
```

## 3.设置redis服务：

```
   1.由于上面虽然启动了redis，但是只要一关闭cmd窗口，redis就会消失。所以要把redis设置成windows下的服务。

   2.执行如下命令  redis-server –-service-install redis.windows-service.conf –-loglevel verbose 
没有报错，刷新下 “我的电脑”-“管理”-“服务” 列表，会发现多了一个 Redis 服务。

```

## 4.常用的redis服务命令：

```
 卸载服务：redis-server –-service-uninstall

 开启服务：redis-server –-service-start

 停止服务：redis-server –-service-stop

```

##  5.redi官网:  

```http
  中文网： http://www.redis.cn
  英文网： https://www.redis.io
  
  ps: 一般redis英文网站版本更新比中文版本快
```

