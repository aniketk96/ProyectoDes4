package egph.controlador;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import egph.dao.CajeraDao;
import egph.dao.InventarioDao;
import egph.modelos.Cajera;
import egph.modelos.Factura;

public class CrearFactura extends HttpServlet {
	   private CajeraDao cajeraDao;
	   private InventarioDao inventarioDao;
	    public void init() {
	        cajeraDao = new CajeraDao();
	        inventarioDao = new InventarioDao();
	    }
		   

		
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
       
		PrintWriter out=res.getWriter();
		 DecimalFormat df = new DecimalFormat("0.00");
		
		int id_cajera = Integer.parseInt(req.getParameter("id_cajera"));
        String nombre_cajera = req.getParameter("nombre_cajera");
        String nombre_cliente = req.getParameter("cliente");
        int codigo=Integer.parseInt(req.getParameter("cod"));
        String producto = req.getParameter("producto");
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));
        float precio = Float.parseFloat(req.getParameter("precio"));
      int total=0;
        
       Factura cj = new Factura();
        cj.setId_cajera(id_cajera);
        cj.setNombre_cajera(nombre_cajera);
        cj.setNombre_cliente(nombre_cliente);
        cj.setProducto(producto);
        cj.setCantidad(cantidad);
        cj.setPrecio(precio);
        
        try {ResultSet rs=inventarioDao.getCantidad(codigo);
		while(rs.next()) {
			 total=rs.getInt("cantidad")-cantidad;
		}
		inventarioDao.addProducto(total, codigo);
           cajeraDao.crearFactura(cj);
           res.sendRedirect(req.getContextPath()+"/maincajera.jsp");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
	}

}
