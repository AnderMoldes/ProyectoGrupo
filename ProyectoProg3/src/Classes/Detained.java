package Classes;

public class Detained {
	private String name;
	private String lastName;
	private int age;
	
	public Detained(String name, String lastName, int age) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}
	
	public Detained() {
		super();
		this.name = "";
		this.lastName = "";
		this.age = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Detained [name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	
	
}
