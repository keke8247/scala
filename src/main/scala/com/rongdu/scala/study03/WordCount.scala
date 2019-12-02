package com.rongdu.scala.study03

import scala.io.Source


/**
  * @Description
  *             使用Scala做一个WordCount
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/11/27 11:31
  * @Since version 1.0.0
  */
object WordCount {
    def main(args: Array[String]): Unit = {
        var wordCountUtil = new WordCountUtil("D:\\The_Man_of_Property.txt");
        wordCountUtil.wordCount();
    }
}


class WordCountUtil(val filePath:String){
    //把文章按行分割到List
    def readLines():List[String]={
        var lines = Source.fromFile(filePath).getLines().toList;
        return lines;
    }

    //分割句子变成单词,并返回一个分割成单词的List
    def splitLines(lines:List[String]):List[String]={
        var wordList : List[String] = null;

        //把每一行 都按照空格拆分
        var wordListArry : List[Array[String]]=  lines.map(line=>line.split(" "));

        //把拆分后的结果汇总成一个wordList
        wordList = wordListArry.flatten;

        return wordList
    }

    def wordCount(): Unit ={
        var lines = readLines(); //得到文章每一行的list

        //把行 按空格拆分 并组成 单词List
        var wordList = splitLines(lines);

        //把wordList 改装成 tuple(元组)结构 为每个单词计数为1
        var wordTupleList : List[(String,Int)] = wordList.map(word=>(word,1))

        //根据单词进行分组 得到Map行的数据结构(word,List((word,1),.....))
        var wordTupleMapList : Map[String,List[(String,Int)]] = wordTupleList.groupBy(wordT=>wordT._1);

        //统计word的次数 并转成List[]  mapValues() 是对 value 调用方法进行处理
        var wordCountList:List[(String,Int)] = wordTupleMapList.mapValues(tupleList=>tupleList.map(wordTuple=>wordTuple._2).sum).toList;

        //根据word出现次数 倒叙排序   sortWith(x,y) x,y 分别是wordCountArry里面的元素,取第二个(word次数)值进行比较
        wordCountList = wordCountList.sortWith((preWordTuple,sufWordTuple)=>preWordTuple._2 > sufWordTuple._2);

        //循环输出前100个出现次数最多的单词
        var num = 0;
        while (num < 100){
            println(wordCountList(num));
            num = num + 1;
        }
    }
}
