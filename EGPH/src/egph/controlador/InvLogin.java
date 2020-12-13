package egph.controlador;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import egph.dao.InventarioDao;
import egph.modelos.Inventario;

public class InvLogin extends HttpServlet {
	   private InventarioDao inventarioDao;

	    public void init() {
	        inventarioDao = new InventarioDao();
	    }
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		String usuario=req.getParameter("usuario");
		String pass=req.getParameter("pass");
		
		 Inventario cj = new Inventario();
	        cj.setUsuario(usuario);
	        cj.setPass(pass);
	        
	        try {
	           String[] user=inventarioDao.registrosInventario(cj);
	          
	           if(usuario.equals(user[0]) && pass.equals(user[1])) {
	        	   HttpSession session=req.getSession();
	        	   session.setAttribute("iname", user[0]);
	        	   session.setAttribute("iid", user[2]);
	        	   res.sendRedirect(req.getContextPath()+"/maininventario.jsp");
	           }else{
	        	   res.sendRedirect(req.getContextPath()+"/loginInventario.jsp");
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