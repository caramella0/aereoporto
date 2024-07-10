package resource;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class DBconn {

    private Connection connessione;

    public Connection getConnection() throws ConnectException, CommunicationsException, SQLException {
        try {
            if (connessione == null) {
            	
                MysqlDataSource dataSource = new MysqlDataSource();
                dataSource.setServerName("127.0.0.1");
                dataSource.setPortNumber(3306);
                dataSource.setPassword("root");
                dataSource.setUser("root");
                dataSource.setDatabaseName("aereo");
                dataSource.setServerTimezone("UTC");
                connessione = dataSource.getConnection();
                System.out.println("Connessione al database stabilita con successo.");
            }
        } catch (CommunicationsException e) {
            System.err.println("Errore di comunicazione: impossibile connettersi al server.");
            throw e; // Rilancia l'eccezione per la gestione a livello superiore
        } catch (SQLException e) {
            System.err.println("Errore SQL: " + e.getMessage());
            throw e; // Rilancia l'eccezione per la gestione a livello superiore
        }
        return connessione;
    }

    public void closeConnection() {
        if (connessione != null) {
            try {
                connessione.close();
                System.out.println("Connessione al database chiusa con successo.");
            } catch (SQLException e) {
                System.err.println("Errore durante la chiusura della connessione: " + e.getMessage());
            }
        }
    }
}
