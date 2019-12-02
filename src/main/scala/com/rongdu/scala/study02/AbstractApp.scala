package com.rongdu.scala.study02

/**
  * @Description
  *             测试Scala的抽象类
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/11/26 16:59
  * @Since version 1.0.0
  */
object AbstractApp {
    def main(args: Array[String]): Unit = {
        var student = new Student2();

        println(student.name+"_"+student.age)
        student.speak()
    }
}

/**
  * 抽象类:类的一个或者多个方法没有完整的实现.(只有定义没有实现)
  * */
//定义一个抽象类
abstract class Person2{
    def speak;

    var name:String;
    val age:Int;
}

//定义一个抽象类的子类
class Student2 extends Person2 {
    override def speak(): Unit = {
        println("student2 speak.......")
    }

    override var name: String = "张三"
    override val age: Int = 20;
}


