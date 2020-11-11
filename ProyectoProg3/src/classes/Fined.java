package classes;

public class Fined extends Detained {
	private static int counter = 1;
	private int number;
	private String description;

	private double payment;

	

	public Fined(String name, String lastName, int age, String gender, int number, String description, double payment) {
		super(name, lastName, age, gender);
		this.number = number;
		this.description = description;
		this.payment = payment;
	}

	public Fined() {
		super();
		this.number = 0;
		this.description = "";
		this.payment = 0.0;
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

	public void setPayment(double payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Fined number " + number + "Why is he/she fined? " + description + " Payment: " + payment;
	}

}
