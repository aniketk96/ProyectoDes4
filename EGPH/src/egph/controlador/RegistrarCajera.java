package egph.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import egph.dao.CajeraDao;
import egph.modelos.Cajera;

public class RegistrarCajera extends HttpServlet {
	   private CajeraDao cajeraDao;

	    public void init() {
	        cajeraDao = new CajeraDao();
	    }
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
       
		PrintWriter out=res.getWriter();
		
		String usuario = req.getParameter("usuario");
        String pass = req.getParameter("pass");
        
        Cajera cj = new Cajera();
        cj.setUsuario(usuario);
        cj.setPass(pass);
        
        try {
           cajeraDao.registrarCajera(cj);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        res.sendRedirect(req.getContextPath()+"/mainadmin.jsp");
	}

}
