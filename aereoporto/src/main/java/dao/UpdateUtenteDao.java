package dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import resource.DBconn;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class UpdateUtenteDao
 */

@WebServlet("/UpdateUtente")

public class UpdateUtenteDao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUtenteDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			DBconn con = new DBconn();
			Connection aggiungi = con.getConnection();

			String nome = request.getParameter("firstName");
			String cognome = request.getParameter("lastName");
			String email = request.getParameter("email");
			String telefono = request.getParameter("phone");
			String numeroVolo = request.getParameter("flightNumber");
			String data = request.getParameter("date");
			String destinazione = request.getParameter("destination");

			String sql = "INSERT INTO prenotazioni (nome, cognome, email, telefono, numeroVolo, data, destinazione) VALUES (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = aggiungi.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, email);
			ps.setString(4, telefono);
			ps.setString(5, numeroVolo);
			ps.setString(6, data);
			ps.setString(7, destinazione);
			ps.execute();

			ps.executeUpdate();

			System.out.println("caricato");

			// Close database resources
			ps.close();
			con.closeConnection();

		} catch (SQLException e) {

		}

	}
}

//		
//		    // Recupera i dati dal modulo
//		    String firstName = request.getParameter("firstName");
//		    String lastName = request.getParameter("lastName");
//		    String email = request.getParameter("email");
//		    String phone = request.getParameter("phone");
//		    String flightNumber = request.getParameter("flightNumber");
//		    String date = request.getParameter("date");
//		    String destination = request.getParameter("destination");
//
//		    Connection conn = null;
//		    PreparedStatement stmt = null;
//		    try {
//		        // Connessione al database
//		        conn = DBConnection.getConnection();
//		        
//		        // Query SQL per inserire i dati
//		        String sql = "INSERT INTO prenotazioni (nome, cognome, email, telefono, numeroVolo, data, destinazione) VALUES (?, ?, ?, ?, ?, ?, ?)";
//        stmt = conn.prepareStatement(sql);
//		        stmt.setString(1, firstName);
//		        stmt.setString(2, lastName);
//		        stmt.setString(3, email);
//		        stmt.setString(4, phone);
//		        stmt.setString(5, flightNumber);
//		        stmt.setDate(6, Date.valueOf(date)); // Converti la stringa della data in java.sql.Date
//		        stmt.setString(7, destination);
//		        
//		        // Esegue l'istruzione
//		        stmt.executeUpdate();
//		        
//		        // Reindirizza alla pagina di conferma
//		        response.sendRedirect("index.jsp");
//		    } catch (Exception e) {
//		        e.printStackTrace();
//		    } finally {
//		        if (stmt != null) stmt.close();
//		        if (conn != null) conn.close();
//		    }
//		%>
//
//	}
