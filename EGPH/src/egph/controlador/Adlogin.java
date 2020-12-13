package egph.controlador;


import java.io.IOException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import egph.dao.AdminDao;

import egph.modelos.Admin;


public class Adlogin extends HttpServlet {
	   private AdminDao adminDao;

	    public void init() {
	        adminDao = new AdminDao();
	    }
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		String usuario=req.getParameter("usuario");
		String pass=req.getParameter("pass");
		
		 Admin cj = new Admin();
	        cj.setUsuario(usuario);
	        cj.setPass(pass);
	        
	        try {
	           String[] user=adminDao.registrosAdmin(cj);
	          
	           if(usuario.equals(user[0]) && pass.equals(user[1])) {
	        	   HttpSession session=req.getSession();
	        	   session.setAttribute("uname", user[0]);
	        	   session.setAttribute("uid", user[2]);
	        	   res.sendRedirect(req.getContextPath()+"/mainadmin.jsp");
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
	        	   res.sendRedirect(req.getContextPath()+"/login.jsp");
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
