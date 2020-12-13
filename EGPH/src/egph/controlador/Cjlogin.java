package egph.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.parser.Cookie;

import egph.dao.CajeraDao;
import egph.modelos.Cajera;

public class Cjlogin extends HttpServlet {
	   private CajeraDao cajeraDao;

	    public void init() {
	        cajeraDao = new CajeraDao();
	    }
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		String usuario=req.getParameter("usuario");
		String pass=req.getParameter("pass");
		
		 Cajera cj = new Cajera();
	        cj.setUsuario(usuario);
	        cj.setPass(pass);
	        
	        try {
	           String[] user=cajeraDao.registrosCajera(cj);
	          
	           if(usuario.equals(user[0]) && pass.equals(user[1])) {
	        	   HttpSession session=req.getSession();
	        	   session.setAttribute("cname", user[0]);
	        	   session.setAttribute("cid", user[2]);
	        	   res.sendRedirect(req.getContextPath()+"/maincajera.jsp");
	           }else{
	        	   /*javax.servlet.http.Cookie[] cookies=req.getCookies();
	        	   
	        	   for(javax.servlet.http.Cookie c: cookies) {
	        		   if(c.getName().equals("contador")) {
	        			   int cont=Integer.parseInt(c.getValue());
	        		   }
	        	   }
	        	   int i=0;
	        	  javax.servlet.http.Cookie cookie=new Cookie();
	        	  res.addCookie(cookie);*/
	        	   res.sendRedirect(req.getContextPath()+"/loginCajera.jsp");
	           }
	           /*HttpSession session=req.getSession();  
	           session.setAttribute("uname",name);
	           session.setAttribute("uid", id);
	           res.sendRedirect(req.getContextPath()+"/maincajera.jsp");*/
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        
	}

}
