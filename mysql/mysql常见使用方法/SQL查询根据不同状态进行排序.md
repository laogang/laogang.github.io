##### 1.使用场景

```
   在业务场景中需要根据状态值的不同进行不同规则的排序，如按答复状态进行排序，未答复，已答复排序，未答复的再按提交时间倒序排，

  已答复的则按答复时间倒序排。

```

##### 2.代码示例​

```xml
select 
                op.title
                ,op.content
                ,resp.user_name 
        from 
                opinon              op
   left join   
                opinon_response     resp
          on      
			   op.id = resp.opinon_id
    order by     
                op.status
                ,case when
                              op.status = 1
                      then
                              op.last_update_time   end  desc
                ,case when
                              op.status = 2
                      then
                              resp.response_time      end  desc

```


​                