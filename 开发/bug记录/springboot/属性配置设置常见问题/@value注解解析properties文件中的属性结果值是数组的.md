##### 1.文件属性值是数组时

```
   application.properties 文件属性值是数组时：

    skip.url = /login,/logout

```

##### 2.java 文件中 

```java
    @Value("#{'${skip.url}'.split(',')}")

    private List<String> urls;

```


