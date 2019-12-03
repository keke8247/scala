package com.rongdu.scala.study07

import java.sql.{Connection, DriverManager, Statement}

/**
  * @Description
  * @Author wangdk,wangdk@erongdu.com
  * @CreatTime 2019/12/3 15:51
  * @Since version 1.0.0
  */
object MysqlApp {
    def main(args: Array[String]): Unit = {
        var driver ="com.mysql.jdbc.Driver";
        var url = "jdbc:mysql://localhost:3306/test";
        var username = "root";
        var password = "abc123"

        var connection : Connection = null;
        var statement : Statement = null;
        try{
            //初始化驱动 (单机情况下 不写也行,分布式情况下需要写.)
            classOf[com.mysql.jdbc.Driver]
            //建立连接
            var connection = DriverManager.getConnection(url,username,password);

            //创建statement 执行sql
            var statement = connection.createStatement();

            var resultSet = statement.executeQuery("select * from test_t limit 20");

            //迭代输出
            while (resultSet.next()){
                var userId = resultSet.getString("user_id");
                var orderId = resultSet.getString("order_id");

                println(s"$userId $orderId")
            }
        }catch {
            case e:Exception => e.printStackTrace()
        }finally {
            if(statement!=null){
                statement.close()
            }
            if(connection != null){
                connection.close()
            }
        }

    }
}
