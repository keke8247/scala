package com.rongdu.scala.study02

/**
  * @Description
  *     面向对象
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/11/26 15:36
  * @Since version 1.0.0
  */
object SimpleObjectApp {
    def main(args: Array[String]): Unit = {
        //使用Person类  声明Person对象 scala中的变量只有var 修饰
        var person = new Person();
        println(person.eat())

        //为name赋值
        person.name="韦德"
        println(person.eat("热狗"))

        person.watchFootball("热火")

        person.printInfo()
    }
}

//定义一个类 Person
class Person{
    //声明一个属性 name,scala会自动为该属性生成隐式的 getter/setter方法
    var name:String = _ //_是占位符的概念.

    //声明一个常量 age=30, 不允许修改,scala只会为常量生成 getter方法
    val age:Int = 30

    //声明一个私有变量 只能类内部使用  不能在类外部通过person.hobby的方式访问
    private [this] var hobby = "篮球"

    //声明一个吃饭的方法 需要传一个参数food food默认为hanbao
    def eat(food : String = "hanbao"):String ={
        name + " is eating "+ food
    }

    def watchFootball(team : String): Unit ={
        println(name +"is watching football of "+team)
    }

    def printInfo(): Unit ={
        println(name + " like" +hobby)
    }
}
