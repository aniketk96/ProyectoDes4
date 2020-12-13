package egph.controlador;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import egph.dao.InventarioDao;
import egph.modelos.Inventario;

public class RegistrarInventario extends HttpServlet {
	   private InventarioDao inventarioDao;

	    public void init() {
	        inventarioDao = new InventarioDao();
	    }
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
       
		PrintWriter out=res.getWriter();
		
		String usuario = req.getParameter("usuario");
        String pass = req.getParameter("pass");
        
        Inventario cj = new Inventario();
        cj.setUsuario(usuario);
        cj.setPass(pass);
        
        try {
           inventarioDao.registrarInventario(cj);
           res.sendRedirect(req.getContextPath()+"/mainadmin.jsp");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       
	}

}