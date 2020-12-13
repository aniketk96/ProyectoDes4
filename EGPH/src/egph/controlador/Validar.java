package egph.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validar extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String perfil=req.getParameter("perfil");
		
		PrintWriter out=res.getWriter();
		
		switch(perfil) {
		case "admin":
			res.sendRedirect(req.getContextPath()+"/login.jsp");
			break;
		case "cajera":
			res.sendRedirect(req.getContextPath()+"/loginCajera.jsp");
			break;
		case "inventario":
			res.sendRedirect(req.getContextPath()+"/loginInventario.jsp");
			break;
		}
	}
	
}
