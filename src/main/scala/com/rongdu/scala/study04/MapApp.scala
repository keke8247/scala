package com.rongdu.scala.study04


/**
  * @Description
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/11/29 15:56
  * @Since version 1.0.0
  */
object MapApp extends App {

    var map = scala.collection.mutable.HashMap[String,Int]();

    map.put("java",10)
    map.put("scala",8);

    println(map.map(entry => entry._2).toArray.sum)

    println(map)

}
