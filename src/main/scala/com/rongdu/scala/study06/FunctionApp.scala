package com.rongdu.scala.study06

/**
  * @Description
  *             匿名函数操作:函数可以命名 也可以不命名
  *             定义方式:
  *             (参数值:参数类型)=>方法体
  *             可以把 匿名函数 赋值给一个变量/常量 或者一个 方法
  *
  *             curryint 颗粒化函数
  *
  *             高阶函数
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/12/2 11:26
  * @Since version 1.0.0
  */
object FunctionApp extends App {

    //start  匿名函数 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //把匿名函数 赋值给addOne
    var addOne = (x:Int)=>{
        x+1;
    }
    println(addOne(10)) //调用

    //把匿名函数 赋值给一个函数
    def add = (x:Int,y:Int)=>{
        x + y;
    }
    println(add(1,3))   //调用
    //end  匿名函数 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //start  currying函数 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //把原本一个函数的的参数拆开放在不同括号里  old() == new_currying() 两者等效  调用方式如下
    def old(x:Int,y:Int): Int ={
        x+y
    }

    println(old(1,4));

    def new_currying(x:Int)(y:Int): Int ={
        x + y;
    }
    println(new_currying(1)(4))

    //end  currying函数 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //start  高阶函数 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //map filter reduce take
    var list = List(1,2,3,4,5,6,7,8);

    //map:逐个去操作集合中的每个元素
    list.map((x:Int)=>x+1).foreach(println); //每个元素+1 (全称写法,可以简写)

    //x类型 scala可以推导出来(根据list的类型),可以省略掉,还可以进一步省略
    list.map((x)=>x+1).foreach(println);

    //如果x的值 是一个括号也可以省略,如果是tuple类型 括号不能省略.还可以进一步使用通配符
    list.map(x=>x+1).foreach(println);

    //map中的(x=>x+1) 可以 使用通配符(_+1),只有x=>x 这种可以使用通配符
    list.map(_+1).foreach(println);

    //filter 过滤器 把list元素中>3的过滤出来.
    list.filter(_>3).foreach(println)

    //reduce 一次传入list中相邻的两个元素  before 和 after, 可以简化成通配符写法
    println(list.reduce((before:Int,after:Int)=>before+after));
    println(list.reduce(_+_));

    //reduceLeft 从左往右操作. ((((((1-2)-3)-4)-5)-6)-7)-8 = -34
    println(list.reduceLeft(_-_));
    //reduceRight 从右往左操作 1-(2-(3-(4-(5-(6-(7-8)))))) = -4
    println(list.reduceRight(_-_));

    //fold 颗粒化传参  把1 也加入计算 1+1+2+3+4+5+6+7+8=37
    println(list.fold(1)(_+_));
    //foldLeft 把0放入左边参与计算  (((((((0-1)-2)-3)-4)-5)-6)-7)-8 = -36
    println(list.foldLeft(0)(_-_));
    //foldRight 把0放到最右边参与计算 1-(2-(3-(4-(5-(6-(7-(8-0))))))) = -4
    println(list.foldRight(0)(_-_));
    //end  高阶函数 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    println("List最大值:"+ list.max+" ,最小值: "+ list.min+",求和: "+list.sum)

    println("List的前4个元素: "+list.take(4))

    // List[List[Int]] = List(List(1, 2), List(3, 4), List(5, 6))
    var listTwo = List(List(1,2),List(3,4),List(5,6));

    // List[Int] = List(1, 2, 3, 4, 5, 6) 把list中的元素 摊平到一个list中
    listTwo.flatten

    //把listTwo 中每一个元素 *2,原始写法,有两层List 所以需要分别调用map
    print("把listTwo 中每一个元素 *2,原始写法"+ listTwo.map(lists=>lists.map(_*2)));

    //flatMap 效果等价于 ==> 先 flatten 再map
    print("把listTwo 中每一个元素 *2,使用flatMap方法"+ listTwo.flatMap(_.map(_*2)));

}
