# GIT常用命令参考

> 日期：2019-06-28
>
> 说明：参考工具



[TOC]

## 1.配置本地全局.gitignore

```properties
1.在本地用户目录下设置.ignore文件，此文件中写有你想忽略的内容 
C:\Users\administor**
  该文件通常和.gitconfig放在同一目录，新建 .gitignore_global 文件；
2.在Git的命令行里输入：
$ git config --global core.excludesfile ~/.gitignore_global
输入完成后，可打开.gitconfig文件，会发现里面自动添加了
eg:
   [core]
	excludesfile = C:/Users/guog/.gitignore_global
```

