package com.rongdu.scala.study04

/**
  * @Description
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/11/29 15:51
  * @Since version 1.0.0
  */
object SetApp extends App {
    var set = Set(1,2,3,4,1,2,4);

    println(set) //set 不允许重复
    println(set.sum)
}
