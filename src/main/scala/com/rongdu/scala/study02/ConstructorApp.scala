package com.rongdu.scala.study02

/**
  * @Description
  *             验证Scala的构造器
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/11/26 16:12
  * @Since version 1.0.0
  */
object ConstructorApp {
    def main(args: Array[String]): Unit = {
        var people = new People("张三",30)
        people.gender = "男"
        println(people.name + " : " + people.age + " : " + people.gender)

        var people2 = new People("李四",32,"女");
        println(people2.name + " : " + people2.age + " : " + people2.gender)

        //创建子类对象的时候 会先调用父类的构造方法
        var student = new Student("王五",22,"计算机")
        println(student.name+"_"+student.age+"_"+student.major)

        println(student.toString())
    }
}

//主构造器 跟在类后面 构造器面的参数 必须用var或者val修饰 否者people.name 获取不到.应该是 定义为private了
class People(var name:String,var age:Int){
    println("People Constructor is enter......")

    //声明一个变量 性别 使用占位符
    var gender:String = _

    //声明一个附属构造器
    def this(name:String,age:Int,gender:String){
        this(name,age);//附属构造器 第一行 必须调用 主构造器或者其他附属构造器
        this.gender = gender;
    }

    println("People Constructor is leave......")
}

//子类Student 继承父类People
//name,age 是从父类继承过来的 不需要使用var/val修饰,子类特有的属性 必须使用var/val修饰 否者外部访问不到
class Student(name:String,age:Int,var major:String)extends People(name:String,age:Int){
    println("Student Constructor is enter......")

    //使用override修饰 重写父类的方法或者属性
    override def toString: String = "this is Student override method"

    println("Student Constructor is leave......")
}
