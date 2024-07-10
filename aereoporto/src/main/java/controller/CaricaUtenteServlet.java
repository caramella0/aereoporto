package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Passeggero;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.SQLException;

import dao.CaricaUtenteDao;

@WebServlet("/UpdateUtente")
public class CaricaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CaricaUtenteDao caricaUtenteDao;

	public void init() {
		caricaUtenteDao = new CaricaUtenteDao();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String flightNumber = request.getParameter("flightNumber");
		String destination = request.getParameter("destination");

		Passeggero passeggero = new Passeggero();

		passeggero.setFirstName(firstName);
		passeggero.setLastName(lastName);
		passeggero.setEmail(email);
		passeggero.setPhone(phone);
		passeggero.setFlightNumber(flightNumber);
		passeggero.setDestination(destination);
		
	 try {
		caricaUtenteDao.caricaUtente(passeggero);
	} catch (ConnectException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
