package dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public boolean eliminaUtente(Passeggero passeggero) throws ConnectException, CommunicationsException, SQLException {

		String sqlUtente = "DROP INTO aereo.passeggero WHERE id=?";

		DBconn conn = new DBconn();
		Connection connection = conn.getConnection();
		PreparedStatement ps = connection.prepareStatement(sqlUtente);

		boolean rowDeleted = ps.executeUpdate() > 0;

		connection.close();
		conn.closeConnection();
		ps.close();

		return rowDeleted;

	}

	public List<Passeggero> listaTuttiPasseggero() throws SQLException, ConnectException {
		
		List<Passeggero> listaPasseggero = new ArrayList<>();

		String sqlUtente = "SELECT * FROM aereo.passeggero";

		DBconn conn = new DBconn();
		Statement statement = (Statement) conn.getConnection();
		ResultSet resultSet = statement.executeQuery(sqlUtente);

		while (resultSet.next()) {
			String firstName = resultSet.getString("nome");
			String flightNumber = resultSet.getString("numero_volo");
			
			Passeggero passeggero2 = new Passeggero(firstName, flightNumber);
			listaPasseggero.add(passeggero2);
		}

		resultSet.close();
		statement.close();

		return listaTuttiPasseggero();
	}

	private void printSQLException(SQLException ex) {

		for (Throwable e : ex) {
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
