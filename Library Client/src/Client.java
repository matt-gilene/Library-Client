
public class Client {
	
	public static final String[] DATA_NAMES = {"Name", "Age"};
	
	String name;
	int age;
	
	public Client(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Client() {
		this("", 0);
	}
	
	public Object[] asArray() {
		return new Object[] {name, age};
	}
}
