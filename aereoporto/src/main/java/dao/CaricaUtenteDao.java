package dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import model.Passeggero;
import resource.DBconn;

public class CaricaUtenteDao {

	public int caricaUtente(Passeggero passeggero) throws ConnectException, CommunicationsException, SQLException {
		
		String sqlUtente = "INSERT INTO aereo.passeggero ( nome, cognome, email, telefono, destinazione, numero_volo) VALUES (?,?,?,?,?,?)";
		
		int result = 0;
		
		DBconn conn = new DBconn();
		Connection connection = conn.getConnection();
		
		PreparedStatement ps = connection.prepareStatement(sqlUtente);
		
		ps.setString(1, passeggero.getFirstName());
		ps.setString(2, passeggero.getLastName());
		ps.setString(3, passeggero.getEmail());
		ps.setString(4, passeggero.getPhone());
		ps.setString(5, passeggero.getFlightNumber());
		ps.setString(6, passeggero.getDestination());
		
		
		result = ps.executeUpdate();
		connection.close();
		conn.closeConnection();
		ps.close();
		
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
}
