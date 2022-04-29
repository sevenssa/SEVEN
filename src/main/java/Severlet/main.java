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
 * Servlet implementation class main
 */
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String op = request.getParameter("op");
        if (op.equalsIgnoreCase("del")){
   		    DogDao.delete(id);//call CLASS  DogDao delete (id )
           // response.sendRedirect("ViewServlet"); 
         
   		}
     //   DogDao.delete(id);//call CLASS TeaDao delete (id )
        //TeaDao class實例化
        
        response.sendRedirect("ViewServlet");
		
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 response.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();
	        //取頁面輸入資料
	        
	        String id = request.getParameter("pid");
	        String name = request.getParameter("name");	        
	        String phone = request.getParameter("phone");
	        String mail = request.getParameter("mail");	        
	        String animaltype = request.getParameter("animaltype");
	        String animaleage1 = request.getParameter("animaleage");
	        int animaleage = Integer.parseInt(animaleage1);
	        String  date = request.getParameter("date");
	     
	        DOG e = new DOG();//實例化class tea
	        e.setAid(id) ;          
	          e.setAd_name(name);
	          e.setAd_phone(phone);
	          e.setAd_mail(mail);
	          e.setAd_animaltype(animaltype);
	          e.setAd_amimalage(animaleage);
	          e.setAd_date(date);
	         // e.setPrice(Integer.parseInt(price));
	         // e.setQty(Integer.parseInt(qty));
	        	                     //整個tea class 
	        int status = DogDao.save(e);//TeaDao class實例化
	        if (status > 0) {
	            out.print("<p>保存 信息記錄成功！</p>");
	            out.println("<a href='index.html'>新增功能</a>");  
	            //response.setCharacterEncoding("UTF-8");
	            //request.getRequestDispatcher("index.html").include(request, response);
	        } else {
	            out.println("對不起，保存失敗！");
	             }
	            out.close();
	      	   		}      
	   	  	    
	   	    
		
		
		
		
		
		
		
		
		
	 
}

