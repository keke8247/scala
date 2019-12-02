package com.rongdu.scala.study02

/**
  * @Description
  *             验证Scala的Apply 和 伴生类伴生对象
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/11/26 17:07
  * @Since version 1.0.0
  */
object ApplyApp {
    def main(args: Array[String]): Unit = {

        //-----------------
//        for(i <- 1.to(10)){
//            ApplyTest.incr()
//        }
//        println(ApplyTest.count) //10 说明Object本身就是一个单例对象
        //----------------

        var b = ApplyTest() //==> Object.apply()

        var c = new ApplyTest();
        println(c)
        c();
        // 类名() 调用的是 Object.apply()
        // 对象() 调用的是 class.apply()
    }
}


/**
  * 伴生类和伴生对象
  * 如果有一个class,还有一个和class同名的object
  * 那么就称这个object是这个class的伴生对象,class是这个object的伴生类
  */
class ApplyTest{
    def apply() = {
        println("class ApplyTest apply......")
    }
}

object ApplyTest{
    println("Object ApplyTest enter......")

    var count:Int = 0;

    def incr(): Unit ={
        count += 1;
    }

    //最佳实践:在Object的apply中 new一个对象.
    def apply() = {
        println("Object ApplyTest apply......")

        //在Object的apply中new class
        new ApplyTest;
    }

    println("Object ApplyTest leave......")
}
