```
动态 SQL 的另外一个常用的操作需求是对一个集合进行遍历，通常是在构建 IN 条件语句的时候。比如：
```

1. ##### 参数类型是list：

```xml
<select id="selectPostIn" parameterType="java.util.List" resultType="domain.blog.Post">
  SELECT 
    	 *
    FROM
          POST P
   WHERE 
          ID 
      IN
  <foreach item="item" index="index" collection="list" open="(" separator="," close=")">
        #{item}
  </foreach>
</select>

```

2. ##### 参数类型是数组：

```xml
<delete id="deletePhotoByArray" parameterType="java.lang.String">
          DELETE FROM t_areaphoto WHERE Id in
        <foreach collection="array" item="id" open="(" separator="," close=")">
            #{id}
        </foreach>
</delete>

```

3. ##### 参数类型是map：

```xml
Map<String,String[]> rooms = new HashMap<String, String[]>();

roomsId.put("roomsId",id);

//mapper接口

 int deleteRoomById(Map<String, String[]> rooms);

<delete id="deleteRoomById" parameterType="map">
        DELETE FROM t_room WHERE Id in
      <foreach collection="roomsId" index="index" item="item" open="(" separator=", "close=")">
          #{item}
      </foreach>
</delete>

```



```
foreach 元素的功能非常强大，它允许你指定一个集合，声明可以在元素体内使用的集合项（item）和索引（index）变量。它也允许你指定开头与结尾的字符串以及在迭代结果之间放置分隔符。这个元素是很智能的，因此它不会偶然地附加多余的分隔符。

注意 你可以将任何可迭代对象（如 List、Set 等）、Map 对象或者数组对象传递给 foreach 作为集合参数。当使用可迭代对象或者数组时，index 是当前迭代的次数，item 的值是本次迭代获取的元素。当使用 Map 对象（或者 Map.Entry 对象的集合）时，index 是键，item 是值。

```


