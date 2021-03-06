package moviePagination;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class moviePaginationApplication {
	
	public static void main(String[] args) throws SQLException {
		Scanner read = new Scanner(System.in);
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recoverConnection();
		
		MovieDAO movieDao = new MovieDAO(connection);
		
		int numberMovies;
		int numberPage;
		
		System.out.println("+------------ COMPASS LIBRARY ------------+ \n");
		System.out.println("Digite quantos filmes voc? deseja filtrar: ");
		numberMovies = Integer.parseInt(read.next());
		System.out.println("Digite qual p?gina voc? deseja acessar: ");
		numberPage = Integer.parseInt(read.next());
		
		List<Movie> listMovies = movieDao.pageItems(numberMovies, numberPage);
		listMovies.stream().forEach(lp -> System.out.println(lp));	
	}	
}
