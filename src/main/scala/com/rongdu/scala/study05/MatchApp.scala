package com.rongdu.scala.study05

import scala.util.Random

/**
  * @Description
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/11/29 16:26
  * @Since version 1.0.0
  */
object MatchApp extends App {

    //声明一个 开发语言数组
    var names = Array("java","c++","python","scala");
    //随机从数组中取一个值
    var name = names(Random.nextInt(names.length));

    //匹配name
    name match {
        case "java" => println("java")
        case "c++" => println("c++")
        case "python" => println("python")
        case _ => println("no match....") //没有匹配上的出口
    }

    //双重过滤测试
    def judgeGrade(name:String,grage:String): Unit ={
        grage match {
            case "A" => println("Excellent...");
            case "B" => println("good...");
            case "C" => println("just so so...");
            case _ if(name == "lisi") => println(name +", you are a good boy but you need work harder...");//grage 没有匹配到 并且name==lisi
            case _ => println("you need work hader");
        }
    }

    judgeGrade("zhangsan","A");
    judgeGrade("lisi","D");
    judgeGrade("wangwu","D");

    //对数组的模式匹配
    def greeting(array:Array[String]): Unit ={
        array match {
            //匹配只有 zhangsan一个元素的数组
            case Array("zhangsan") => println("Hi: zhangsan");
            //匹配有两个元素的数组
            case Array(x,y) => println("Hi: "+x+", "+y);
            //匹配以 zhangsan开头 后面任意多个元素的数组
            case Array("zhangsan",_*) => println("Hi zhangsan and other friends...");
            case _ => println("Hi: ererybody");
        }
    }

    greeting(Array("zhangsan"));
    greeting(Array("lisi","wangwu"));
    greeting(Array("zhangsan","lisi","wangwu"));
    greeting(Array("lisi","zhangsan","wangwu"));

    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

    //对List的模式匹配
    def greeting(list:List[String]): Unit ={
        list match {
            //匹配只有 zhangsan一个元素的List
            case "zhangsan" :: Nil => println("Hi: zhangsan");
            //匹配有两个元素的List
            case x::y::Nil => println("Hi: "+x+", "+y);
            //匹配以 zhangsan开头 后面任意多个元素的List
            case "zhangsan" :: tail => println("Hi zhangsan and other friends...");
            case _ => println("Hi: ererybody");
        }
    }

    greeting(List("zhangsan"));
    greeting(List("lisi","wangwu"));
    greeting(List("zhangsan","lisi","wangwu"));
    greeting(List("lisi","zhangsan","wangwu"));

    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

    //根据参数类型匹配
    def matchType(obj:Any): Unit ={
        obj match {
            case i:Int => println("Int");
            case s:String => println("String");
            case map:Map[_,_]=>map.foreach(println);
            case _ => println("other type");
        }
    }

    matchType("TestString");
    matchType(1);
    matchType(Map("mapKey"->"mapValue"));
    matchType(Array());

    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

    //根据 case class匹配
    def caseclassMatch(person:Person): Unit ={
        person match {
            case CTO(name,floor) => println("CTO name is:"+ name+" floor is "+floor);
            case Employee(name,floor) => println("Employee is:"+ name+" floor is "+floor);
            case Other(name) => println("Other.....");
        }
    }

    caseclassMatch(CTO("张三",20));
    caseclassMatch(Employee("李四",2));
    caseclassMatch(Other("王五"));

    class Person;
    case class CTO(name:String,floor:Int) extends Person;
    case class Employee(name:String,floor:Int) extends Person;
    case class Other(name:String) extends Person;
}
