# Intellij IDEA�������òο�

> ���ڣ�2019-05-16
>
> ˵�����ο�����

[TOC]

## 1.Intellij IDEA�ļ��޸���ʾ�Ǻ�

```properties
Eclipse���ļ��޸ĺ�û�б���ǰ�ļ��������Ǻ���ʾ��IntelljJ IDEAĬ��û����ʾ�����ǿ���ͨ�������������

Settings -> Editor -> General -> Editor Tabs: Check "Mark modified tabs with asterisk"
```

## 2.IntelliJ IDEA����Tabsʵ��ͬʱ�򿪶���ļ��ҷ�����ʾ

```properties
IDEA Ĭ�ϵ��ļ��򿪺� Tabs Placement �� None������ͨ�������������
Window -> Editor Tabs -> Tabs Placement: Top
```

## 3.Intellij IDEA�Զ������Ч import �� �����Ч import �Ŀ�ݼ�

```properties
��ݼ�  
ctrl+alt+o
�Զ���������÷���
File -> Settings -> Editor -> General -> Auto Import -Java����ѡoptimize imports on the fly��
�ڵ�ǰ��Ŀ�»��Զ������Ч��import�������������ʱ�Զ�����ġ�
```

## 4.Intellij IDEA����git

```properties
idea��û�м��ɰ汾������ʱ Version Control �ǽ��õģ�����ͨ���������ü���git
1. Settings -> Version Control -> Git  ��� Path to Git executable     **\cmd\git.exe (���尲װ·��)������� Test ȷ���Ƿ�װ�ɹ���
2. ��VCS �����õ�ǰ��Ŀʹ�ð汾�������ߡ�
VCS -> Enable Version Control Integration  ����ѡ��Git��
������ɺ����Ҽ�ȷ���Ƿ���Gitѡ�


```

## 5.Intellij IDEA��������ƶ��������Զ���ʾJavadoc�ĵ� 

```properties
File -> Settings -> Editor -> General -> ��ѡ Show quick documentation on mouse move 
Ҳ������ delay ��ʱʱ��
```

## 6.Intellij IDEA�ÿ�ݼ��Զ��������л�id

```properties
��̳���Serializable�ӿ�֮��ʹ��alt+enter��ݼ��Զ��������л�id 

File -> Settings -> Editor -> Inspections -> serialization issues��ѡ��ͼ�е�ѡ�serializable class without ��serialVersionUID��
```

## 7.Intellij IDEA����java�ļ�ģ��

```properties
File -> Settings -> Editor -> File and Code Templates  ѡ�� Includes Tab�µ� File Header

/**  
  * @version 1.0.0  
  * @author: guog
  * @date  ${DATE} ${TIME}
  * @description
  */ 
```

