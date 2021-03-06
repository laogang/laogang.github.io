##### Feign的源码实现的过程如下：

```
1. 首先通过@EnableFeignCleints注解开启FeignCleint
2. 根据Feign的规则实现接口，并加@FeignCleint注解
3. 程序启动后，会进行包扫描，扫描所有的@ FeignCleint的注解的类，并将这些信息注入到ioc容器中。
4. 当接口的方法被调用，通过jdk的代理，来生成具体的RequesTemplate
5. RequesTemplate再生成Request
6. Request交给Client去处理，其中Client可以是HttpUrlConnection、HttpClient也可以是Okhttp
7. 最后Client被封装到LoadBalanceClient类，这个类结合类Ribbon做到了负载均衡。

```

##### 参考资料：

https://blog.de-swaef.eu/the-netflix-stack-using-spring-boot-part-3-feign/

https://github.com/OpenFeign/feign

```
Feign是自带断路器的，在D版本的Spring Cloud中，它没有默认打开。需要在配置文件中配置打开它，在配置文件加以下代码：

feign.hystrix.enabled=true
```


