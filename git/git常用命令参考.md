# GIT常用命令参考

> 日期：2019-06-28
>
> 说明：参考工具

## 

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



## 2.修改commit信息

```properties
修改commit信息主要有这几种情况
1.刚刚commit，还没有push，使用git commit --amend;
在vi界面修改commit信息并保存生效，可以通过git log 查看修改后的commit信息，最后git push提交。

2.刚刚push，要修改最近一个push的commit信息，使用git commit --amend；
同上。

3.修改历史push的commit信息，使用git rebase -i HEAD~n【其中的n为记录数】，进入编辑界面
需要修改的那个将 pick 改成 edit，保存并退出；再次查看git log，选中的已经变成最新的提交；
git commit --amend 后编辑信息，保存并退出；再次查看log，查看仓库状态，根据提示使用
git rebase --continue，最后git push提交。

注意：
其中1、2两种情况的修改方式是一样的，但是git log的记录是不同的
第三种方式也是把需要修改的记录调整为最新的提交，然后使用2的方式修改
```

