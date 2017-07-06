package service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
 
public class ConnectJDBC {
	public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
 
            System.out.println("成功加载MySQL驱动程序");
    
            String url = "jdbc:mysql://localhost:3306/datashow?useUnicode=true&characterEncoding=UTF8";
            con = DriverManager.getConnection(url,"root","qifei");
           
               System.out.println("成功连接数据库");
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return con ;
    }
	
	public static void close(Connection con){
		  try {
				con.close();
				   System.out.println("mysql：connection连接关闭");
			    } catch (SQLException e) {	e.printStackTrace();	}  
	}
 
  
	
	
	
	public static void main(String[] args){   	
    	 
		Connection conna=ConnectJDBC.getConnection();	
		 try {
			 
			PreparedStatement yc=conna.prepareStatement("select * from agriculturetoday where 1=1 limit 5");
			ResultSet	datas= yc.executeQuery();
	
		 while (datas.next()) {
			System.out.println(datas.getString(1));
			System.out.println(datas.getString(2));
			System.out.println(datas.getString(3));
			System.out.println(datas.getString(4));
			System.out.println(datas.getString(5));
		}
		 } catch (SQLException e) {	e.printStackTrace();	}
		 ConnectJDBC.close(conna);
    }
    
}
