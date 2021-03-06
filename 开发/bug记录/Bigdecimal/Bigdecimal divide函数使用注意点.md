##### 1.api:    

```
divide

      public BigDecimal divide(BigDecimal divisor)返回一个 BigDecimal，其值为 (this / divisor)，其首选标度为 (this.scale() - divisor.scale())；如果无法表示准确的商值（因为它有无穷的十进制扩展），则抛出 ArithmeticException。 

```

     参数：
           divisor - 此 BigDecimal 要相除的值。 
     返回：
           this / divisor 
      抛出： 
           ArithmeticException - 如果准确的商值没有无穷的十进制扩展

#####  2.业务场景：

```
涉及金额类计算时使用Bigdecimal时，进行除法操作时需要考虑到除不尽这种情况。
```

#####   3.解决方法：

```
根据业务中金额类有效小数使用divide()重载方法解决。
```

        public BigDecimal divide(BigDecimal divisor,
                         int scale,
                         RoundingMode roundingMode)返回一个 BigDecimal，其值为 (this / divisor)，其标度为指定标度。如果必须执行舍入，以生成具有指定标度的结果，则应用指定的舍入模式。 
    
      参数：
          divisor - 此 BigDecimal 要除以的值。
          scale - 要返回的 BigDecimal 商的标度。
          roundingMode - 要应用的舍入模式。 
     返回：
          this / divisor 
     抛出： 
          ArithmeticException - 如果 divisor 为零，则 roundingMode==RoundingMode.UNNECESSARY 和指定的标度不足以准确地表示相除的结果。

