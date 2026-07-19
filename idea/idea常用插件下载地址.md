# idea常用插件下载地址

> 日期: 2021-05-27
>
> 说明：参考工具

[TOC]



### 1. .ignore

```
地址：https://plugins.jetbrains.com/plugin/7495--ignore

生成各种ignore文件，一键创建git ignore文件的模板，免得自己去写 

步骤：安装好插件后，选中工程项目，右键-> new -> *.gitignore file -> .gitignore file(Git) 
->依次输入关键字 java -> 勾选 Languages,frameworks下 java；输入关键字 jet -> 勾选 Global templates下JetBrains -> 点击Generate生成.gitignore文件。

```

### 2. lombok

```
地址：https://plugins.jetbrains.com/plugin/6317-lombok-plugin

支持lombok的各种注解，从此不用写getter setter这些 可以把注解还原为原本的java代码 非常方便
```

### 3. p3c

```
地址：https://plugins.jetbrains.com/plugin/10046-alibaba-java-coding-guidelines

阿里巴巴出品的java代码规范插件

可以扫描整个项目 找到不规范的地方 并且大部分可以自动修复

更多可看: https://github.com/alibaba/p3c/tree/master/idea-plugin
```

### 4. GsonFormat

```
地址：https://plugins.jetbrains.com/plugin/7654-gsonformat

一键根据json文本生成java类 非常方便

步骤：安装好插件后，在一个新建的空类中{}内 -> alt + s  -> 粘贴json内容 -> setting 可进行特殊化设置 ->
 ok 可修改字段类型。
```

### 5. Maven Helper

```
地址：https://plugins.jetbrains.com/plugin/7179-maven-helper

一键查看maven依赖，查看冲突的依赖，一键进行exclude依赖

对于大型项目 非常方便
```

### 6. VisualVM Launcher

```
地址：https://plugins.jetbrains.com/plugin/7115-visualvm-launcher

运行java程序的时候启动visualvm，方便查看jvm的情况 比如堆内存大小的分配

某个对象占用了多大的内存，jvm调优必备工具
```

### 7. MyBatisCodeHelperPro

```
地址：https://plugins.jetbrains.com/plugin/9837-mybatiscodehelperpro

mybatis代码自动生成插件，大部分单表操作的代码可自动生成 减少重复劳动 大幅提升效率

https://www.cnblogs.com/quzhongren/p/11050880.html
```

### 8. Translation  源码翻译插件

```
在 IDEA 插件市场（Settings > Plugins）中搜索 Translation 即可安装
```

### 9.RestfulTool2

```
RestfulTool2 是一款专为 IDEA 等 IDE 打造的 RESTful 服务开发辅助工具集，常被开发者用来替代 Postman 进行简单的接口调试。它主要支持 Spring 体系（Spring MVC/Spring Boot）和 JAX-RS 规范。
安装方式：在 IDEA 中打开 Settings -> Plugins -> Marketplace，搜索 RestfulTool 或 RestfulToolkit 进行安装并重启即可。

常用快捷键：
全局 URL 查找定位：Ctrl + Alt + / 或 Ctrl + Alt + N。
格式化 JSON 数据：Windows 为 Ctrl + Enter，Mac 为 Command + Enter。

如果你使用的是 IDEA 2024.2 及以上版本，安装官方原版 RESTFul-Tool 可能会遇到无法使用的问题。针对这一情况，有以下几种解决方案：
手动修改插件包：下载 RestfulTool2-2024.5.12.819.zip 插件包，解压后修改内部 plugin.xml 文件中的 idea-version 属性（去掉 until-build 限制），重新打包后再导入 IDEA 即可正常使用。
注意快捷键冲突：重新安装或修改插件包后，部分快捷键可能会发生变化（例如全局查找可能变成 Ctrl + Alt + \），建议在设置中重新检查并绑定快捷键。
K2 模式限制：高版本 IDEA 如果开启了 K2 模式，该插件目前不兼容，需要关闭 K2 模式才能正常启动。

四、 同类插件对比建议
如果你觉得 RestfulTool 功能过于基础，也可以考虑以下替代方案：
RestfulBox：RestfulTool 的增强版，额外支持导出 Swagger 文档、本地 Mock 服务和更完善的 HTTP 测试。
EasyApi / Apidog / Apifox：适合中大型项目和团队协作，提供一站式的 API 管理、文档同步、自动化测试和云端协作功能。
```

