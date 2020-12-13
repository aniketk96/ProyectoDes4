package egph.controlador;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Adlogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String usuario=req.getParameter("usuario");
		String pass=req.getParameter("pass");
		PrintWriter out=res.getWriter();
		out.print(usuario + pass);
		if(usuario.equals("aniket") && pass.equals("aniket")) {
			
			HttpSession session=req.getSession();
			session.setAttribute("uname", usuario);
			session.setAttribute("uid", 1);
				res.sendRedirect(req.getContextPath()+"/mainadmin.jsp");
			
		}else {
			res.sendRedirect(req.getContextPath()+"/login.jsp");
			
		}
		
		
	}
	
}
