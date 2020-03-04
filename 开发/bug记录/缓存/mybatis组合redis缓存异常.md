####  mybaits 组合redis缓存异常

##### 1.错误信息：

```
   org.apache.ibatis.executor.ExecutorException: Cannot get Configuration as configuration factory was not set
```

#####  2.报错场景：

```
在使用mybatis 一对多标签并将查询结果放到redis缓存中，连续调用查询接口出现如上错误。
```

#####  3.错误原因：

```
项目里面 mybatis-config.xml文件里面 属性 “cacheEnabled” 设置的 true

   通过查找资料发现mybatis官方的答复以下任意一种情况都会抛出如上异常：

   一.延迟加载已启用。

   二.未设置configurationFactory。

   三.具有延迟加载属性的对象被序列化，并且在反序列化后调用其延迟加载属性。

   具体解释见：     https://github.com/mybatis/mybatis-3/issues/936

```

#####   4.解决办法：

```
  一对多标签查询标签里设置  “fetchType” 属性 为 “eager” 来覆盖 “lazyLoadingEnabled” 关闭延迟加载。

   标签使用方法地址：    http://www.mybatis.org/mybatis-3/zh/configuration.html#settings     

```


​        

