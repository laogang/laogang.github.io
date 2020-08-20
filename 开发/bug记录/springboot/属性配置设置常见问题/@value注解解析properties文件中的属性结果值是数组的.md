##### 1.文件属性值是数组时

```yml
    application.properties 文件属性值是数组时：

    skip.url = /login,/logout   #这个位置用逗号隔开会被自动默认为数组形式

```

##### 2.java 文件中 

```java
    @Value("#{'${skip.url}'.split(',')}")
    private List<String> urls;

    @Value("${skip.url}")
    private String[] urls;

```


