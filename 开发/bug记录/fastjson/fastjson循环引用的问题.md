##### 1.场景：

```
    项目中使用到了阿里巴巴的fastjson，返回的数据结构类型是集合，打比方有两条数据：

  第一条数据里面是[第一条，第二条],  第一条数据里面是[第二条],由于有重复引用的问题存在，将数据有JSONObject.toJSONString(restult)返回给前端时，

  第一条数据前端正常拿到并解析成功，第二条成了$Ref打头的，导致前端无法解析渲染页面数据。

```

##### 2.原因：

```
   阿里巴巴的fastjson支持循环引用，并且是缺省打开的，关闭会有很大可能导致循环引用时发生StackOverflowError异常。
```

##### 3.解决方法：

```
   关闭引用支持：当序列化后的JSON传输到浏览器或者其他语言中，这些json解析器不支持循环引用，从而导致数据丢失。

   你可以关闭fastjson的循环引用支持。关闭引用检测，还能够提升序列化时的性能。

```

      非全局关闭：JSON.toJSONString(obj, SerializerFeature.DisableCircularReferenceDetect);

官方wiki地址:   https://github.com/alibaba/fastjson/wiki/%E5%BE%AA%E7%8E%AF%E5%BC%95%E7%94%A8



