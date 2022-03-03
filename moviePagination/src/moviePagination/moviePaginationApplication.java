package moviePagination;

import java.sql.Connection;
import java.sql.SQLException;

public class moviePaginationApplication {
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recoverConnection();
		
		MovieDAO movieDao = new MovieDAO(connection);
		
		Movie m1 = new Movie("Panico", "Filme de terror brabo dos brabos, o 1 � o melhor", 1996);
		movieDao.add(m1);
	}	
}
