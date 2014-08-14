
public class Book {
	
	public static final String[] DATA_NAMES = {"Title", "Summary"};
	
	private String title;
	private String summary;
	
	public Book() {
		this("","");
	}
	
	public Book(String title, String summary) {
		this.title = title;
		this.summary = summary;
	}
	
	public Object[] asArray() {
		return new Object[] {title, summary};
	}
	
}
