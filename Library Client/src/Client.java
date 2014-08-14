import java.awt.print.Book;
import java.util.ArrayList;


public class Client {
	
	public static final String[] DATA_NAMES = {"Name", "Age"};
	
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
	
	public Object[] asArray() {
		return new Object[] {name, age, books.size()};
	}
}
