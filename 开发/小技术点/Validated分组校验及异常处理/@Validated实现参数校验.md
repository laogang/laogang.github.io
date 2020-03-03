# Validated注解实现参数校验



[TOC]

## 1. 总体说明

```
springmvc 工程中对请求参数的校验可以使用@Validated注解和Javax.vlidation.*提供的注解组合起来进行校验，使用全局异常捕获Validated校验不通过抛出的MehthodArgumentNotValidException异常。
```

## 2. @Validated分组校验

```
@Validated 支持对对象参数属性进行分组校验，使我们的校验根据不同的业务场景更灵活易使用。
```

## 3. @Valid 支持嵌套对象校验

```
单独在Controller层对restful接口方法对象使用@Valiated注解并不能同时对嵌套的对象里面的属性有校验效果，这里可以在@Validated对象嵌套的对象上面加上@Valid注解就可以支持嵌套对象校验。
```

## 4. 全局统一捕获处理校验失败异常

```
校验不通过会由BindingResult封装异常信息从而抛出MehthodArgumentNotValidException异常，参数话异常在开发中多作为业务异常处理，这里进行捕获以统一格式返回给前端展示。
```

