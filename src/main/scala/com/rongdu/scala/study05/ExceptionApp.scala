package com.rongdu.scala.study05

/**
  * @Description
  *             scala异常处理
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/11/29 17:06
  * @Since version 1.0.0
  */
object ExceptionApp extends App{

    try{
        var i = 10/0; //0不能做分母  肯定会抛异常
    }catch {
        //匹配异常的类型  做对应的处理
        case e:ArithmeticException => println("0不能做分母....");
        case e:Exception => println(e.getMessage)
    }finally {
        //一般在这里做一些释放资源的操作.比如做IO处理的时候 关闭流,数据库处理的时候 释放连接
    }
}
