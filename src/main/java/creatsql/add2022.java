package creatsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class add2022 {

	public static void main(String[] args) {
		 ResultSet rs = null;
         ResultSetMetaData rsmeta = null;
        try {
 			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master","sa", "777");
 			Statement stmt = con.createStatement();			
 			System.out.print("成功連結資料庫");

 
            String sql;
       	
        //A TYPE      
        
            
         
       	 
       	 
       //	 sql = "INSERT INTO TDog " +
	    //    "VALUES ('A002','天涯朝慕','0908776891','seven775207@gmail.com','犬類','5','20220214')";
       	 
       //	 stmt.executeUpdate(sql);
       	 
       	// sql = "INSERT INTO TDog " +
	    //    "VALUES ('A003','天涯咫尺','0908776891','seven775207@gmail.com','犬類','5','20220214')";
       	 
       	// stmt.executeUpdate(sql);
       	 
       	// sql = "INSERT INTO TDog " +
	   //     "VALUES ('A004','天涯明月刀','0908776891','seven775207@gmail.com','犬類','5','20220214')";
       	 
       //	 stmt.executeUpdate(sql);
       	 
       	// sql = "INSERT INTO TDog " +
	    //    "VALUES ('A005','慕蓉不復','0908776891','seven775207@gmail.com','犬類','5','20220214')";
       	 
       	// stmt.executeUpdate(sql);
       	 
       //	 sql = "INSERT INTO TDog " +
	   //     "VALUES ('A006','賣唱小生','0908776891','seven775207@gmail.com','犬類','5','20220214')";
       	 
       	// stmt.executeUpdate(sql);
       	 
       //	 sql = "INSERT INTO TDog " +
	   //     "VALUES ('A007','金曲男','0908776891','seven775207@gmail.com','犬類','5','20220214')";
       
      // 	 stmt.executeUpdate(sql);
       	 
    //   	 sql = "INSERT INTO TDog " +
	 //       "VALUES ('A008','高歌離別','0908776891','seven775207@gmail.com','犬類','5','20220214')";
       	 
      // 	 stmt.executeUpdate(sql);
       	 
       	// sql = "INSERT INTO TDog " +
	  //      "VALUES ('A009','離別鉤','0908776891','seven775207@gmail.com','犬類','5','20220214')";
       	 
      // 	 stmt.executeUpdate(sql);
       	 
      // 	 sql = "INSERT INTO TDog " +
	   //     "VALUES ('A010','絕情谷','0908776891','seven775207@gmail.com','犬類','5','20220214')";
       	 
       //	 stmt.executeUpdate(sql);
       	 
       //B   TYPE     
         sql = "INSERT INTO TDog " +
	        "VALUES ('B001','沈七七','0908776891','seven775207@gmail.com','犬類','5','20220214')";
    	 
    	 stmt.executeUpdate(sql);
    	 
    	 sql = "INSERT INTO TDog " +
	        "VALUES ('B002','天涯朝慕','0908776891','seven775207@gmail.com','犬類','5','20220214')";
    	 
    	 stmt.executeUpdate(sql);
    	 
    	 sql = "INSERT INTO TDog " +
	        "VALUES ('B003','天涯咫尺','0908776891','seven775207@gmail.com','犬類','5','20220214')";
    	 
    	 stmt.executeUpdate(sql);
    	 
    	 sql = "INSERT INTO TDog " +
	        "VALUES ('B004','天涯明月刀','0908776891','seven775207@gmail.com','犬類','5','20220214')";
    	 
    	 stmt.executeUpdate(sql);
    	 
    	 sql = "INSERT INTO TDog " +
	        "VALUES ('B005','慕蓉不復','0908776891','seven775207@gmail.com','犬類','5','20220214')";
    	 
    	 stmt.executeUpdate(sql);
    	 
    	 sql = "INSERT INTO TDog " +
	        "VALUES ('B006','賣唱小生','0908776891','seven775207@gmail.com','犬類','5','20220214')";
    	 
    	 stmt.executeUpdate(sql); 
       	 
       	 
       	 
       	 
       	 
       	 rs=stmt.executeQuery("select * from TDog ");
       	 while(rs.next()) {
                System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5)+rs.getString(6)+rs.getString(7)); // ID   줺 e
	
       	 
       	 }
       	
       	 con.close();
	}
	 catch (ClassNotFoundException e) {

           e.printStackTrace();
}
	 catch (SQLException e) {

           e.printStackTrace();

}
}
}