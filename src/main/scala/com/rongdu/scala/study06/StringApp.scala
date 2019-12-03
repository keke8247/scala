package com.rongdu.scala.study06

/**
  * @Description
  *             字符串高阶操作
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/12/2 11:19
  * @Since version 1.0.0
  */
object StringApp extends App {

    var hello = "hello: "
    var name = "Wade"

    //传统字符串拼接方式
    println(hello+name);

    //插词Interpolation 拼接,前面 加一个 s, 双引号内 通过$符引用变量
    println(s"$hello: $name");

    //多行字符串用法  """ """(输入两次双引号)可以保持字符串原貌
    var str =
        """
          |wocao duohag
          |keyi zhemegao
          |shizhende a  a ga
          |
          |gag
          |reg
          |e
        """.stripMargin
    println(str);
}
