package DogDao;
import java.util.*;

import beandao.DOG;

import java.sql.*;


public class  DogDao{
	  
public static Connection getConnection() {
    Connection con  = null;
    try {
//    	Class.forName("com.mysql.jdbc.Driver");
//	     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/text", "root", "seven7777");
//	     Statement st = con.createStatement(); 
//         System.out.println("成功連結 test_db 資料庫");
        
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master","sa", "777");
		Statement st = con.createStatement();			
		System.out.print("成功連結資料庫");

        
    } catch (Exception e) {
        System.out.println(e);
    }
    return con;
}
//新增段方法
public static int save(DOG e) { 
    int status = 0;
    try {
        Connection con = DogDao.getConnection();//上一段註冊成功連結
        String sql = "INSERT INTO  TDog  (pid,name,phone,mail,animaltype,animaleage,date) values (?,?,?,?,?,?,?)";
        //新增        
        PreparedStatement ps = con.prepareStatement(sql);
        //取出DOG  BEAN  用 GET  放進 上面順序問號中 
        ps.setString(1, e.getAid());//用 e. 即有選項 getAid()        
        ps.setString(2, e.getAd_name());//用 e. 即有選項 getAd_name()
        ps.setString(3, e.getAd_phone());//用 e. 即有選項 .getAd_phone()
        ps.setString(4, e.getAd_mail());// 
        ps.setString(5, e.getAd_animaltype()); 
        ps.setInt(6, e.getAd_amimalage());
        ps.setString(7, e.getAd_date());
       //執行語法  
        status = ps.executeUpdate();//RETURN CODE  status 用法增加 判斷新增成功與否

        con.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return status;
}

// 更正方法
public static int update(DOG e) {
    int status = 0;//RETURN CODE  status 用法增加 判斷新增成功與否
    try {
         
        Connection con = DogDao.getConnection();//上一段註冊成功連結
        String sql = "UPDATE  TDog  SET name=?,  phone=?,mail=?,animaltype=?,animaleage=?,date=? where pid=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, e.getAd_name());//用 e. 即有選項 getAd_name()
        ps.setString(2, e.getAd_phone());//用 e. 即有選項 .getAd_phone()
        ps.setString(3, e.getAd_mail());// 
        ps.setString(4, e.getAd_animaltype()); 
        ps.setInt(5, e.getAd_amimalage());
        ps.setString(6, e.getAd_date());
                 
        ps.setString(7, e.getAid());

        status = ps.executeUpdate();

        con.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return status;
}
//刪除段方法
public static int delete(String id) {//頁面傳進來id
    int status = 0;//RETURN CODE  status 用法增加 判斷新增成功與否
    try {
        
        Connection con = DogDao.getConnection();//上一段註冊成功連結
        String sql = "DELETE FROM TDog WHERE pid=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);//頁面傳進來
        status = ps.executeUpdate();

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return status;
}
//查詢單筆方法
public static DOG getTeaById(String id) {
	DOG e = new DOG();

    try {
    	
        
       	Connection con = DogDao.getConnection();//上一段註冊成功連結.
        String sql = "SELECT * FROM TDog WHERE pid=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        //讀sql 資料寫bean 
        if (rs.next()) {
              e.setAid(rs.getString("pid")) ;//用 e. 即有選項 setAid()
              e.setAd_name(rs.getString("name"));//用 e. 即有選項 .getAd_phone()
	          e.setAd_phone(rs.getString("phone"));
	          e.setAd_mail(rs.getString("mail"));
	          e.setAd_animaltype(rs.getString("animaltype"));
	          e.setAd_amimalage(rs.getInt("animaleage"));
	          e.setAd_date(rs.getString("date"));
        
            
        }
        con.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return e;
}
//查詢全部方法需耍用LIST 集合
public static List<DOG> getAllTea() {
    List<DOG> list = new ArrayList<DOG>();

    try {
        String sql = "SELECT * FROM TDog  ORDER BY Pid DESC";
        Connection con = DogDao.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        	DOG e = new DOG();
        	 //讀sql 資料寫bean 
        	  e.setAid(rs.getString("pid")) ;//用 e. 即有選項 setAid()
              e.setAd_name(rs.getString("name"));//用 e. 即有選項 .getAd_phone()
	          e.setAd_phone(rs.getString("phone"));
	          e.setAd_mail(rs.getString("mail"));
	          e.setAd_animaltype(rs.getString("animaltype"));
	          e.setAd_amimalage(rs.getInt("animaleage"));
	          e.setAd_date(rs.getString("date"));
       
             //dog bean 寫入集合中 
          
              list.add(e);
        }
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;//回傳list 集合
}
}