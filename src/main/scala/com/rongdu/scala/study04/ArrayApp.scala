package com.rongdu.scala.study04

import scala.collection.mutable.ArrayBuffer

/**
  * @Description
  *             继承了APP以后 可以省略main函数,因为App作为一个入口类
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/11/29 15:10
  * @Since version 1.0.0
  */
object ArrayApp extends App {

    //定长数组Array  声明一个长度为5的字符串数组
    var array = new Array[String](5)
    println(array.length)
    //给array赋值
    array(1) = "testOne";
    //mkString(",") 把arry转换成String 用,分割元素
    println(array.mkString(","))

    //通过 object Array的 apply方法 声明一个数组.在apply方法里面new了一个array
    var array_apply = Array("scala","java","c++","python");
    println(array_apply.mkString(","))

    //声明一个可变长度的int型数组
    var arrayBuffer = new ArrayBuffer[Int]();
    arrayBuffer += 1;
    arrayBuffer += 2;
    arrayBuffer += 3;
    println(arrayBuffer.mkString(","))

    //也可以通过apply方法声明 ==> 1,2,3,4,5,6,7,8
    var arrayBuffer_apply = ArrayBuffer(1,2,3,4,5,6,7,8);
    //array的一些常规操作
    arrayBuffer_apply -= 3; //把 元素3删掉 ==> 1,2,4,5,6,7,8
    arrayBuffer_apply += 1; //在数组最后添加元素1 ==> 1,2,4,5,6,7,8,1
    arrayBuffer_apply -= 1; //有重复元素的时候 会把前面的删掉 ==> 2,4,5,6,7,8,1
    arrayBuffer_apply += (2,4,5,6); //一次添加多个元素 ==> 2,4,5,6,7,8,1,2,4,5,6
    arrayBuffer_apply ++= Array(10,11,12,13); //在结尾追加一个定长array的元素 ==> 2,4,5,6,7,8,1,2,4,5,6,10,11,12,13
    arrayBuffer_apply --= Array(3,3,5,6,5); //删除定长array中的元素 ==> 2,4,7,8,1,2,4,6,10,11,12,13

    //int型数组 可以直接通过sum方法求和
    println(arrayBuffer_apply.sum)
    //取最大值
    println(arrayBuffer_apply.max)

    println(arrayBuffer_apply.mkString(","))



    //mkString("<",",",">")把数组转成String ==> <1,2,3,4,5,6,7,8>
    var arrayStr = arrayBuffer_apply.mkString("<",",",">")
    println(arrayStr)
    println(arrayStr.getClass)

}
