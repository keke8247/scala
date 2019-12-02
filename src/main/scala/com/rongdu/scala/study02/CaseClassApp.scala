package com.rongdu.scala.study02

/**
  * @Description
  *             验证 case 修饰的 class
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/11/26 17:33
  * @Since version 1.0.0
  */
object CaseClassApp {
    def main(args: Array[String]): Unit = {
        println(Dog("旺财").name)
    }
}

//case 修饰的class 在使用的时候 不需要new,主构造器中的参数也不需要用var/val修饰 可以直接获取到
//猜测:类似java中的 static 修饰的类.
case class Dog(name:String){

}
