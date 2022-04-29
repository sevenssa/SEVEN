package Severlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DogDao.DogDao;
import beandao.DOG;
/**
 * Servlet implementation class EditServlet
 */
 
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<h1>更新訂單信息</h1>");
	        String sid = request.getParameter("id");
	       
	         
	        DOG e = DogDao.getTeaById(sid);//參數
	        //TeaDao class  實例化  link  TeaDao.getEmployeeById(id);
	        out.print("<form action='EditServlet' method='post'>");//轉到下段程式中'EditServlet' method='post'
	        out.print("<table>");
	       
	        out.print("<tr><td></td><td><input type='hidden' name='pid' value='" + e.getAid() + "'/></td></tr>");//用e.點出選擇項目
	        
	        out.print("<tr><td>聯絡人:</td><td><input type='text' name='name' value='" + e.getAd_name() + "'/></td></tr>");//用e.點出選擇項目
	        out.print("<tr><td>聯絡人電話:</td><td><input type='text' name='phone' value='" + e.getAd_phone()+ "'/></td></tr>");//用e.點出選擇項目
	        out.print("<tr><td>聯絡人信箱:</td><td><input type='text' name='mail' value='" + e.getAd_mail()+ "'/></td></tr>");//用e.點出選擇項目
	        out.print("<tr><td>寵物種類:</td><td><input type='text' name='animaltype' value='" + e.getAd_animaltype()+ "'/></td></tr>");//用e.點出選擇項目
	        out.print("<tr><td>想認養寵物年齡:</td><td><input type='text' name='animaleage' value='" + e.getAd_amimalage()+ "'/></td></tr>");//用e.點出選擇項目
	        out.print("<tr><td>填表單日期:</td><td><input type='text' name='date' value='" + e.getAd_date()+ "'/></td></tr>");//用e.點出選擇項目
	             
	        out.print("<tr><td colspan='2'><input type='submit' value='編輯&保存'/></td></tr>");
	        out.print("</table>");
	        out.print("</form>");
	 
	        out.close();
	    }
	    // 收集表單信息並將修改更新到數據庫
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	         	 
	    	    response.setCharacterEncoding("UTF-8");
		        response.setContentType("text/html;charset=UTF-8");
		        request.setCharacterEncoding("UTF-8");
		        PrintWriter out = response.getWriter();
	        //取得上段值
	        String sid = request.getParameter("pid"); //用request.點出選擇項目
	         String name = request.getParameter("name"); //用request.點出選擇項目
	        String phone = request.getParameter("phone"); //用request.點出選擇項目
	        
	        String mail = request.getParameter("mail");//用request.點出選擇項目
	        String animaltype = request.getParameter("animaltype");
	        String animaleage = request.getParameter("animaleage");
	        int aminlage1 =  Integer.parseInt(animaleage);
	        String date = request.getParameter("date");
	        
	        
	        //更正後寫入bean 
	        DOG e = new DOG();
	        e.setAid(sid);//用e.點出選擇項目
	        e.setAd_name(name);//用e.點出選擇項目
	        e.setAd_phone(phone);//用e.點出選擇項目
	        e.setAd_mail(mail);//用e.點出選擇項目
	        e.setAd_animaltype(animaltype);             
	        e.setAd_amimalage(aminlage1);
	        e.setAd_date(date);
	        //執行DAO 回傳成功與否
	        int status = DogDao.update(e);
	        if (status > 0) {
	            response.sendRedirect("ViewServlet");
	        } else {
	            out.println("對不起更新信息失敗！");
	        }
	        out.close();
	    }
	}	