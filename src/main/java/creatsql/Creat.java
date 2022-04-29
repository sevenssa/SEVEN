package creatsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Creat {
	public static void main(String[] args) {
//        try {
//        	 Class.forName("com.mysql.jdbc.Driver");
//    	     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/text", "root", "seven7777");
//    	     Statement st = con.createStatement(); 
//           System.out.println("成功連結 test_db 資料庫");
          try {
             
 			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master","sa", "777");
 			Statement st = con.createStatement();			
 			System.out.print("成功連結資料庫");
        
            
       //String sql  = "CREATE TABLE dog("
       //     		+  "pid VARCHAR(45) NOT NULL,"//Axxx認養  Bxxx棄養*
        //    		+ " type varchar(50),"       //  種類
          //  		+ "year  int(11) NOT NULL,"  //年紀
          //         + " status  varchar(50),"     //狀態                
            //        +"remake   varchar(50) not NULL) ";//備查
                     
             String sql="CREATE TABLE TDog("
					    + "pid VARCHAR(45) NOT NULL,"//認養表單ID
         		        + "name varchar(50)," //聯絡人
	            		+ "phone varchar(50)," //聯絡人電話
	                    + "mail varchar(50)," //聯絡人信箱	     
	                    + "animaltype varchar(50),"//寵物種類
	                    + "animaleage INT ,"//想認養寵物年齡
	                    + "date DATETIme ,"//填表單日期
	            		+ "PRIMARY KEY (pid))";//唯一
			
			           
            
       st.executeUpdate(sql);
       System.out.println("Created table in given database...");
     

 con.close();       // 關閉資料庫連線

        }

              catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

              catch (SQLException e) {

            e.printStackTrace();

        }

}
}


 
 
 
 