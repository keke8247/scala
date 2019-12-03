package com.rongdu.scala.study06

import scala.util.Random

/**
  * @Description
  *             偏函数 : 被包括在花括号内,没有match的一组case语句
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/12/2 15:05
  * @Since version 1.0.0
  */
object PartitalFunctionApp extends App {
    //声明一个 开发语言数组
    var names = Array("java","c++","python","scala");
    //随机从数组中取一个值
    var name = names(Random.nextInt(names.length));

    //匹配name
    name match {
        case "java" => println("java")
        case "c++" => println("c++")
        case "python" => println("python")
        case _ => println("no match....") //没有匹配上的出口
    }

    //偏函数 必须返回PartitalFunction[String,String] ;第一个String是入参类型 第二个String是出参类型
    def sayNames:PartialFunction[String,String]={
        case "java" => "输入的是java"
        case "c++" => "输入的是c++"
        case "python" => "输入的是python"
        case _ => "输入的内容没有匹配到" //没有匹配上的出口
    }

    println(sayNames(name));
}
