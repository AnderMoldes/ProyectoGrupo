package classes;

import java.util.ArrayList;

public class Vehicle {
	private static int counter = 1;
	private int licensePlate;
	private Brand brand;
	private Colour colour;
	private ArrayList<Workers> polices;

	public Vehicle(int licensePlate, Brand brand, Colour colour, ArrayList<Workers> polices) {
		super();
		this.licensePlate = counter++;
		this.brand = brand;
		this.colour = colour;
		this.polices = polices;
	}

	public Vehicle() {
		super();
		this.brand = Brand.SEAT;
		this.colour = Colour.BLACK;
		this.polices = new ArrayList<Workers>();
	}

	public int getLicensePlate() {
		return licensePlate;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public ArrayList<Workers> getPolices() {
		return polices;
	}

	public void setPolices(ArrayList<Workers> polices) {
		this.polices = polices;
	}

	@Override
	public String toString() {
		return "Vehicle number " + licensePlate + " Brand: " + brand + " Colour" + colour + " Polices in the vehicle: "
				+ polices;
	}

}
