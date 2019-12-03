package com.rongdu.scala.study07

import java.io.{FileInputStream, InputStreamReader}

import scala.xml.XML

/**
  * @Description
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/12/3 16:13
  * @Since version 1.0.0
  */
object XmlApp {
    def main(args: Array[String]): Unit = {
//        loadXml();
        readXmlAttr();
    }

    def loadXml(): Unit ={
        //one
//        var xml = XML.load(this.getClass.getClassLoader.getResource("test.xml"))
//        println(xml)

        //two
        var xml = XML.load(new FileInputStream("F:\\idea\\scala-study\\src\\main\\resources\\test.xml"))
        println(xml)

        //three
        var xml_T = XML.load(new InputStreamReader(new FileInputStream("F:\\idea\\scala-study\\src\\main\\resources\\test.xml")))
        println(xml_T)

    }

    def readXmlAttr(): Unit ={
        var xml = XML.load(this.getClass.getClassLoader.getResource("product.xml"))
//        println(xml)
        // head下面的property
        var propertys = xml \"head" \"property"
        for (property <- propertys){
            println(property)
        }

        // 所有的property
        var allProperty = xml \\ "property";
        for (property <- allProperty){
            println(property)
        }

        // head下面的property的name 第一种写法
        var headPropertyName = (xml \"head" \"property").map(_ \ "@name")
        for (name <- headPropertyName){
            println(name)
        }

        // head下面的property的name 第二种写法
        var headPropertyNameTwo = xml \"head" \"property" \\"@name"
        for (name <- headPropertyNameTwo){
            println(name)
        }

        //id = div2 的div
        var div2 = (xml \\ "div").filter(x=>x.attribute("id").exists(_.text.equals("div2")))
        for (div <- div2){
            println(div)
        }

        //id = div3 的div
        var div3 = (xml \\"div").filter(x=>(x \"@id").text.equals("div3"))
        for (div <- div3){
            println(div)
        }

        //head下的property下的所有内容 不需要key 只要value
        (xml \ "head" \"property").map(x=>(x \ "@name",x.text,x \"@required")).foreach(println)


    }
}
