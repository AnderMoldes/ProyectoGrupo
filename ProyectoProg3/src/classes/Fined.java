package classes;

public class Fined extends Detained {
	private static int counter = 1;
	private int number;
	private String description;
	protected Country citizenship;
	private int payment;

	

	public Fined(String name, String lastName, int age, String gender, int number, String description, int payment,Country citizenship) {
		super(name, lastName, age, gender);
		this.number = number;
		this.description = description;
		this.payment = payment;
		this.citizenship= citizenship;
	}

	public Fined() {
		super();
		this.number = 0;
		this.description = "";
		this.payment = 0;
		this.citizenship= null;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
	public Country getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(Country citizenship) {
		this.citizenship = citizenship;
	}

	@Override
	public String toString() {
		return "Fined number: " + number + ". Description: " + description + ". Citizenship: " + citizenship
				+ ". Payment: " + payment + ". Identificative: " + identificative + ". Name: " + name + " " 
				+ lastName + ". Age: " + age + ". Gender: " + gender ;
	}
	


}
