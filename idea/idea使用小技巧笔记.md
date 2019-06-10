# Intellij IDEA常用设置参考

> 日期：2019-05-16
>
> 说明：参考工具

[TOC]

## 1.Intellij IDEA文件修改提示星号

```properties
Eclipse中文件修改后没有保存前文件都会有星号提示，IntelljJ IDEA默认没有提示，但是可以通过如下设置完成

Settings -> Editor -> General -> Editor Tabs: Check "Mark modified tabs with asterisk"
```

## 2.IntelliJ IDEA设置Tabs实现同时打开多个文件且分行显示

```properties
IDEA 默认的文件打开后 Tabs Placement 是 None，可以通过如下设置完成
Window -> Editor Tabs -> Tabs Placement: Top
```

## 3.Intellij IDEA自动清除无效 import 和 清除无效 import 的快捷键

```properties
快捷键  
ctrl+alt+o
自动清除的配置方法
File -> Settings -> Editor -> General -> Auto Import -Java，勾选optimize imports on the fly，
在当前项目下会自动清除无效的import，而且这个是随时自动清除的。
```

## 4.Intellij IDEA配置git

```properties
idea在没有集成版本管理工具时 Version Control 是禁用的，可以通过如下设置集成git
1. Settings -> Version Control -> Git  添加 Path to Git executable     **\cmd\git.exe (具体安装路径)，并点击 Test 确认是否安装成功。
2. 在VCS 下设置当前项目使用版本关联工具。
VCS -> Enable Version Control Integration  下拉选择Git，
设置完成后在右键确认是否有Git选项。


```

