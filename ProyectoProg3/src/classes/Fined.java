package classes;

public class Fined extends Detained {
	private String description;
	protected Country citizenship;
	private int payment;

	

	public Fined(int identificative, String name, String lastName, int age, String gender, String description,
			Country citizenship, int payment) {
		super(identificative, name, lastName, age, gender);
		this.description = description;
		this.citizenship = citizenship;
		this.payment = payment;
	}

	public Fined() {
		super();
		this.description = "";
		this.payment = 0;
		this.citizenship= Country.Austria;
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
		return " Description: " + description + ". Citizenship: " + citizenship
				+ ". Payment: " + payment + ". Name: " + name + " " 
				+ lastName + ". Age: " + age + ". Gender: " + gender ;
	}
	


}
