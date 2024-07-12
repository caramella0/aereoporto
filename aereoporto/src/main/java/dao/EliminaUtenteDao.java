package dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import model.Passeggero;
import resource.DBconn;

public class EliminaUtenteDao {

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

}
