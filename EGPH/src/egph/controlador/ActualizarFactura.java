package egph.controlador;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import egph.dao.CajeraDao;
import egph.modelos.Factura;




public class ActualizarFactura extends HttpServlet {
	   private CajeraDao cajeraDao;

	    public void init() {
	        cajeraDao = new CajeraDao();
	    }
	  
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		int id_cajera = Integer.parseInt(req.getParameter("id_cajera"));
        String nombre_cajera = req.getParameter("nombre_cajera");
        String nombre_cliente = req.getParameter("cliente");
        int codigo=Integer.parseInt(req.getParameter("cod"));
        String producto = req.getParameter("producto");
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));
        float precio = Float.parseFloat(req.getParameter("precio"));
	   double total=cantidad*precio;
		try {
		     Factura cj=new Factura();
		     cj.setId_cajera(id_cajera);
		     cj.setNombre_cajera(nombre_cajera);
		     cj.setNombre_cliente(nombre_cliente);
		     cj.setProducto(producto);
		     cj.setCantidad(cantidad);
		     cj.setPrecio(precio);
		     
		     cajeraDao.actualizarFacturas(cj, total, id);
			res.sendRedirect(req.getContextPath()+"/maincajera.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	        
	}

}