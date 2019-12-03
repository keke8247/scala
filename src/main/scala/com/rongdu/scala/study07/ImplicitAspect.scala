package com.rongdu.scala.study07

import java.io.File

/**
  * @Description
  *             把 隐式转换定义抽取出来  使用的时候直接引入即可.
  *             这样 在ImplicitApp里面直接引用就行.
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/12/3 15:00
  * @Since version 1.0.0
  */
object ImplicitAspect {
    implicit def man2SuperMan(man:Man)=new SuperMan(man.name);

    implicit def file2RichFile(file: File)=new RichFile(file);
}
