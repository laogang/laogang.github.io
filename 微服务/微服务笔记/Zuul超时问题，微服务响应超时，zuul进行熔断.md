如果要为通过Zuul代理的请求配置套接字超时和读取超时，则有两种选择，具体取决于您的配置：

    如果Zuul使用服务发现，则需要使用ribbon.ReadTimeout和ribbon.SocketTimeout功能区属性配置这些超时;
    如果您通过指定URL配置了Zuul路由，则需要使用 zuul.host.connect-timeout-millis和zuul.host.socket-timeout-millis。 

    如果你在zuul配置了熔断fallback的话，熔断超时也要配置，不然如果你配置的ribbon超时时间大于熔断的超时，那么会先走熔断，相当于你配的ribbon超时就
不生效了。 
熔断超时是这样的： 
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds: 60000 
default代表默认

ps：单位均为毫秒
  
官网文档地址：http://cloud.spring.io/spring-cloud-netflix/single/spring-cloud-netflix.html#_zuul_timeouts
