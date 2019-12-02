package com.rongdu.scala.study01

/**
  * @Description
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/11/26 15:22
  * @Since version 1.0.0
  */
object Study01 {


    //有参数 有返回
    def max(x: Int, y: Int):Int = {
        if(x>y){
            return x
        }else{
            return y
        }
    }

    //有参数 无返回 Unit
    def add(x: Int,y: Int): Unit ={
        println(x+y)
    }

    //无参数 无返回
    def sayHello(): Unit ={
        println("Hello...")
    }

    //方法体 就一句,无参数方法,基本的返回类型 scala可以自动推导出来  可以省略为如下写法
    def three = 1+2;

    def main(args: Array[String]): Unit = {
        //        println("Hello world....")
        //
        //        println(max(5,3))
        //
        //        add(1,4)
        //
        //        //无参函数两种调用方式
        //        sayHello()
        //        sayHello
        //
        //        println(three)


        // 1 to 10 等同于 1.to(10) 一个 1到10的左闭右闭区间 Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        println(1.to(10));

        // 1.to(10,2) 一个1到10 增长步长为2的左闭右闭区间 Range(1, 3, 5, 7, 9)
        println(1.to(10,2))

        //Range(1,10) 一个1到10 增长步长为1的左闭右开区间  Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
        println(Range(1,10));

        //1.until(10) 一个1到10 增长步长为1的左闭右开区间 Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
        println(1.until(10))

        //循环打印 10以内的奇数
        for(i <- 1.to(10,2)){
            print(i+" ,")
        }

        //循环打印 10以内的奇数 可以直接把if条件放在for循环括号里
        for(i <- 1.to(10) if i % 2 != 0){
            println(i)
        }

        val courses = Array("Hadoop","Strom","Hive","Spark","Scala")

        for(course <- courses){
            println(course)
        }

        //类似java里面的lambda 编程方式  遍历courses 得到里面的元素 course
        // => 就是将左边的course 作用上一个函数 编程另外一个结果
        // println() 就是作用到course的函数.
        courses.foreach(course => println(course))

        //while循环
        var (num,sum) = (100,0);
        while(num > 0){
            sum += num
            num = num -1
        }
        println(sum)
    }
}
