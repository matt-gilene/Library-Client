import java.util.ArrayList;


public class Client {
	
	public static final String[] DATA_NAMES = {"Name", "Age", "# Checked Out"};
	
	private String name;
	private int age;
	private ArrayList<Book> books;
	
	
	public Client(String name, int age) {
		this.name = name;
		this.age = age;
		this.books = new ArrayList<Book>();
	}
	
	public Client() {
		this("", 0);
	}
	
	public int bookCount() {
		return books.size();
	}
	
	public Book getBook(int i) {
		return books.get(i);
	}
	
	public Object[] asArray() {
		return new Object[] {name, age, books.size()};
	}
}
