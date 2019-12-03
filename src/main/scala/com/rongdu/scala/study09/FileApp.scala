package com.rongdu.scala.study09

import scala.io.{Codec, Source}

/**
  * @Description
  *             scala操作文件
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/12/3 15:38
  * @Since version 1.0.0
  */
object FileApp {
    def main(args: Array[String]): Unit = {
        readLine
        readChar
        readNet
    }

    //load文件 按行读取
    def readLine: Unit ={
        var file = Source.fromFile("D:\\hello.txt")
        var lines = file.getLines()
        for (line <- lines){
            println(line)
        }
    }

    //按字符读取
    def readChar: Unit ={
        var file = Source.fromFile("D:\\hello.txt")(Codec.UTF8)

        for(c <- file){
            println(c)
        }
    }

    //读取网络数据
    def readNet: Unit ={
        var file = Source.fromURL("http://www.baidu.com");
        for(line <- file.getLines()){
            println(line)
        }
    }
}
