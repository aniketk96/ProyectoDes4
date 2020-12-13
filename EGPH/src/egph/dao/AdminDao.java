package egph.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import egph.modelos.Admin;

public class AdminDao {
	 public String[] registrosAdmin(Admin cj) throws ClassNotFoundException {
	    	
	    	String usuario=cj.getUsuario();
	    	String pass=cj.getPass();
	    	 String SQL = "select * from administrador where usuario='"+usuario+"' and pass='"+pass+"'";
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
	    	               usuarioRs = rs.getString("usuario");
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
	    

}
