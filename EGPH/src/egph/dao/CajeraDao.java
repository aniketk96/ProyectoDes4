package egph.dao;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import egph.modelos.Cajera;
import egph.modelos.Factura;;

public class CajeraDao {

    public int registrarCajera(Cajera cj) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO cajera" +
            "  (usuario_cajera, pass) VALUES " +
            " (?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/egph_kanurkar_garrido", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, cj.getUsuario());
            preparedStatement.setString(2, cj.getPass());


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    public String[] registrosCajera(Cajera cj) throws ClassNotFoundException {
    	
    	String usuario=cj.getUsuario();
    	String pass=cj.getPass();
    	 String SQL = "select * from cajera where usuario_cajera='"+usuario+"' and pass='"+pass+"'";
    	 String[] user = new String[3];
         String idRs=null;
         String usuarioRs=null;
         String passRs=null;
    	        String result = null;

    	        Class.forName("com.mysql.jdbc.Driver");

    	        try (Connection connection = DriverManager
    	            .getConnection("jdbc:mysql://localhost:3306/egph_kanurkar_garrido", "root", "");

    	            // Step 2:Create a statement using connection object
    	            PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
    	            
                    //preparedStatement.setString(1,usuario);
                    //preparedStatement.setString(2, pass);
    	        	
    	            System.out.println(preparedStatement);
    	            
    	            ResultSet rs =preparedStatement.executeQuery(SQL);

    	            // Extract data from result set
    	            
    	            while(rs.next()){
    	               //Retrieve by column name
    	                idRs  = rs.getString("id");
    	               usuarioRs = rs.getString("usuario_cajera");
    	               passRs = rs.getString("pass");
    	               
                     
    	               //Display values
    	               System.out.println("ID: " + idRs );
    	               System.out.println(", usuario: " + usuarioRs);
    	               System.out.println(", pass: " + passRs );
    	            }
    	               
    	            user[0]= usuarioRs;
    	            user[1]=passRs;
    	            user[2]=idRs;
    	           
    	        } 
    	        
    	        catch (SQLException e) {
    	            // process sql exception
    	            printSQLException(e);
    	        }
    	        
    	       return user;
    	     
    	   
    	    }

    public int crearFactura(Factura cj) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO factura" +
            "  (id_cajera,nombre_cajera,nombre_cliente,producto,cantidad,precio,total) VALUES " +
            " (? ,? ,? ,? ,? ,?,?);";

        int result = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/egph_kanurkar_garrido", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, cj.getId_cajera());
            preparedStatement.setString(2, cj.getNombre_cajera());
            preparedStatement.setString(3, cj.getNombre_cliente());
            preparedStatement.setString(4, cj.getProducto());
            preparedStatement.setInt(5, cj.getCantidad());
            preparedStatement.setFloat(6, cj.getPrecio());
            Float total=cj.getPrecio()*cj.getCantidad();
            preparedStatement.setFloat(7, total);
           

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    
    public ResultSet getFacturas() throws ClassNotFoundException, SQLException {
    	
   	 String SQL = "select * from factura";
   	
   	

   	        Class.forName("com.mysql.jdbc.Driver");

   	        Connection connection = DriverManager
   	            .getConnection("jdbc:mysql://localhost:3306/egph_kanurkar_garrido", "root", "");

   	            // Step 2:Create a statement using connection object
   	            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
   	            
                 
   	        	
   	            System.out.println(preparedStatement);
   	            
   	             ResultSet rs =preparedStatement.executeQuery(SQL);
   	             
   	              return rs;
   	          }
    
}