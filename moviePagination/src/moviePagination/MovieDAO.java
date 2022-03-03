package moviePagination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieDAO {
	private Connection connection;
	
	public MovieDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void add(Movie movie) throws SQLException {
		String sql = "INSERT INTO MOVIES (NAME, DESCRIPTION, YEAR) VALUES (?, ? , ?)";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, movie.getName());
			pstm.setString(2, movie.getDescription());
			pstm.setInt(3, movie.getYear());
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getGeneratedKeys()){
				while(rst.next()){
					movie.setId(rst.getInt(1));
				}
			}
		}
	}
	
}
