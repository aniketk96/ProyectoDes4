package egph.controlador;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import egph.dao.InventarioDao;




public class ActualizarProductos extends HttpServlet {
	   private InventarioDao inventarioDao;

	    public void init() {
	        inventarioDao = new InventarioDao();
	    }
	  
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		int codigo=Integer.parseInt(req.getParameter("cod"));
		int cantidad=Integer.parseInt(req.getParameter("cantidad"));
		int total=0;
		try {
			ResultSet rs=inventarioDao.getCantidad(codigo);
			while(rs.next()) {
				 total=rs.getInt("cantidad")+cantidad;
			}
			
			inventarioDao.addProducto(total, codigo);
			res.sendRedirect(req.getContextPath()+"/mainInventario.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	        
	}

}