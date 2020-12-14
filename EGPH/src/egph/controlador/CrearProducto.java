package egph.controlador;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import egph.dao.InventarioDao;

import egph.modelos.Producto;

public class CrearProducto extends HttpServlet {
	   private InventarioDao inventarioDao;

	    public void init() {
	        inventarioDao = new InventarioDao();
	    }
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
       
		PrintWriter out=res.getWriter();
		 DecimalFormat df = new DecimalFormat("0.00");
		
		 String nombre=req.getParameter("nombre");
			float precio=Float.parseFloat(req.getParameter("precio"));
			int cantidad=Integer.parseInt(req.getParameter("cantidad"));
      
       Producto cj = new Producto();
        cj.setNombre(nombre);
        cj.setPrecio(precio);
        cj.setCantidad(cantidad);
      
        try {
           inventarioDao.crearProducto(cj);
           res.sendRedirect(req.getContextPath()+"/mainInventario.jsp");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
	     try {
	           ResultSet rs=inventarioDao.getProductos();
	           PrintWriter out=res.getWriter();
	           int idRs,cantidadRs;
	           String nameRs;
	           float precioRs;
	           out.println("<div>");
               out.println("<table border='1'>");
               out.println("<tr>");
               out.println("<th>Id</th>");
               out.println("<th>Nombre</th>");
               out.println("<th>Precio</th>");
               out.println("<th>Cantidad</th>");
	          while(rs.next()){
	               //Retrieve by column name
	                idRs  = rs.getInt("id_producto");
	               nameRs = rs.getString("nombre_producto");
	               precioRs = rs.getFloat("precio");
	               cantidadRs = rs.getInt("cantidad");
	               
                 
	               //Display values
	           
	               out.println("<tr>");
	               out.println("<td>"+idRs+"</td>");
	               out.println("<td>"+nameRs+"</td>");
	               out.println("<td>"+precioRs+"</td>");
	               out.println("<td>"+cantidadRs+"</td>");
	               out.println("</tr>");
	            }
	           out.println("</div>" );
	        	   
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	}


