package com.rongdu.scala.study06

import scala.io.Source
/**
  * @Description
  *             高阶版本wordCount
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/12/2 15:14
  * @Since version 1.0.0
  */
object WordCount_new extends App {

    def wordCount1: Unit ={
        //文章数据 按行读取到list
        var lines = Source.fromFile("D:\\The_Man_of_Property.txt").getLines().toList;

        //step 1: 把句子按照 空格分隔

        //step 3: 分组求和
        lines.map(_.split(" "))     //step 1: 把句子按照 空格分隔
            .flatMap(_.map(word=>(word,1))) //step 2: lines.flatMap 数据摊平,并逐个处理转成tuple(word,1)
            .groupBy(wordTuple=>wordTuple._1)   //根据word分组
            .mapValues(workKeyList=>workKeyList.map(wordCount=>wordCount._2).sum) //统计word出现次数
            .toList //转成List
            .sortWith((x,y)=>x._2>y._2) //并根据count排序
        println(lines.take(10).map(_.split(" ")).flatMap(_.map(word=>(word,1))).groupBy(wordTuple=>wordTuple._1).mapValues(workKeyList=>workKeyList.map(wordCount=>wordCount._2).sum).toList.sortWith((x,y)=>x._2>y._2));
    }
    wordCount1
}
