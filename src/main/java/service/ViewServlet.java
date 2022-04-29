package service;


 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;//model xml
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DogDao.DogDao;
import beandao.DOG;
 

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>添加資料</a>");  
        out.println("<h1>資 料</h1>");  

        List<DOG> list=DogDao.getAllTea();  
        //out.print(list);
        out.print("<table border='1' width='100%'");  
       
        out.print("<tr> <th>編號</th> <th>客戶</th> <th>電話</th> <th>電郵</th> <th>日期</th> <th>操作</th></tr>");  
        
        for(DOG e:list){  //用 e. 即有選項 getAid()
         out.print("<tr><td>"+e.getAid()+"</td><td>"+e.getAd_name()+"</td><td>"+e.getAd_phone()+"</td><td>"+e.getAd_mail()+"</td><td>"+e.getAd_date()
         +"</td><td><a href='EditServlet?id="+e.getAid()+"'>編輯</a> | <a href='main?id="+e.getAid()+"&op=del' onClick=\"return confirm('確定要刪除嗎？')\">刪除</a></td></tr>");  
        }  
        out.print("</table>");  
        
        //用 e. 即有選項 getAid() ?id="+ e.getAId()  
        //<a href='/ATEST2/DELSER?id="+ book.getId()+"&op=del'>delete BUTTON </a>"  
        out.print("</table>");  
        out.close();  
    }
}