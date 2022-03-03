package moviePagination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection recoverConnection() throws SQLException{
		return DriverManager
				.getConnection("jdbc:mysql://localhost/movies_database?useTimezone=true&serverTimezone=UTC", "root", "root");
	}
}
