##### 1.使用场景：

```
 case when 除了可以使用到查询字段上，也可以放到where条件后台及order by 过滤结果集上面。
```

##### 2.代码示例：

```
SELECT 
        notice.id
        ,notice.title
        ,notice.content 
  FROM 
        d_notice_bulletin notice
 WHERE 
        notice.create_by = 'admin' 
   AND 
        CASE WHEN 
                    notice.title= 'test' 
             THEN 
                    notice.rowstate = 2
             ELSE 
                    notice.rowstate = 1 
              END 

```

