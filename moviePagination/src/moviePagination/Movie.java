package moviePagination;

public class Movie {
	private int id;
	private String name;
	private String description;
	private int year;
	
	public Movie(int id, String name, String description, int year) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.year = year;
	}
	
	public Movie(String name, String description, int year) {
		super();
		this.name = name;
		this.description = description;
		this.year = year;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d \n"
				+ "Nome: %s \n"
				+ "Descri??o: %s \n"
				+ "Ano: %d \n", this.id, this.name, this.description, this.year);
	}

}


