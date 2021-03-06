package moviePagination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
	private Connection connection;
	
	public MovieDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Movie> pageItems(int numberMovies, int numberPage) throws SQLException{
		
		List<Movie> movies = new ArrayList<Movie>();
		
		int numberTotalMovies = 20;
		
		int numberTotalPages = (int) Math.ceil((double) numberTotalMovies/numberMovies);
		
		int end = numberMovies * numberPage;
		int start = (end - numberMovies) + 1;
		
		if(numberPage > numberTotalPages) {
			System.out.println("P?gina vazia, tente novamente outra p?gina!");
		}else {
			System.out.println("\n" +"========================= P?gina " + numberPage + " ========================= \n");
			while(start <= end && start <= numberTotalMovies) {
				String sql = "select * from movies where id in(" + start + ");";
				
				try(PreparedStatement pstm = connection.prepareStatement(sql)){
					pstm.execute();
					try(ResultSet rst = pstm.getResultSet()){
						while(rst.next()) {
							Movie movie =
									new Movie(rst.getInt(1), 
											rst.getString(2), 
											rst.getString(3), 
											rst.getInt(4));
							movies.add(movie);
						}
					}
				}
				start++;
			}
		}
		return movies;
	}
	
}
