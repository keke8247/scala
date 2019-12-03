package com.rongdu.scala.study07

import java.io.File
import ImplicitAspect._

/**
  * @Description
  *             隐式转换功能测试
  *             例如:为Man 增加fly功能
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/12/3 14:45
  * @Since version 1.0.0
  */
object ImplicitApp extends App {

    //Man 没有fly的功能,可以通过隐式转换增强 把Man转成SuperMan 增加fly的功能
    val man = new Man("zhangsan");
    // man.fly; 此时还没有增强 man没有fly的方法.
    // 隐式转换 用implicit修饰 定义一个方法 把需要转换的类作为入参 增强后的类作为出参
//    implicit def man2SuperMan(man:Man)=new SuperMan(man.name);    //由于上面已近import了 这里不需要再次定义隐式转换了
    man.eat
    man.fly //此时Man就有了fly的功能

    var file = new File("D:\\testImplicit.txt")
    //此时file还没有read功能 需要增强
    //增强file
//    implicit def file2RichFile(file: File)=new RichFile(file);    //由于上面已近import了 这里不需要再次定义隐式转换了
    println(file.read)

}

//一个普通Man 没有superMan fly的功能
class Man(val name:String){
    def eat: Unit ={
        println(s"Man :[ $name ] eat.......")
    }
}

//一个SuperMan 有fly的功能
class SuperMan(val name:String){
    def fly: Unit ={
        println(s"SuperMan :[ $name ] fly.....")
    }
}


//做一个file的增强类 RichFile,增加read的功能
class RichFile(val file:File){
    def read: String ={
        scala.io.Source.fromFile(file.getPath).mkString
    }
}
