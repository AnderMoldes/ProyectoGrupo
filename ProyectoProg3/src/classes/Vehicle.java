package classes;

import java.util.ArrayList;
import java.util.List;

import classes.Brand.BrandEnum;
import classes.Colour.ColourEnum;

public class Vehicle {
	private static int counter = 1;
	private int licensePlate;
	private BrandEnum brand;
	private ColourEnum colour;
	private List<Workers> polices;

	public Vehicle(int licensePlate, BrandEnum brand, ColourEnum colour, ArrayList<Workers> polices) {
		super();
		this.licensePlate = counter++;
		this.brand = brand;
		this.colour = colour;
		this.polices = polices;
	}

	public Vehicle() {
		super();
		this.brand = BrandEnum.SEAT;
		this.colour = Colour.ColourEnum.BLACK;
		this.polices = new ArrayList<Workers>();
	}

	public int getLicensePlate() {
		return licensePlate;
	}

	public BrandEnum getBrand() {
		return brand;
	}

	public void setBrand(BrandEnum brand) {
		this.brand = brand;
	}

	public ColourEnum getColour() {
		return colour;
	}

	public void setColour(ColourEnum colour) {
		this.colour = colour;
	}

	public ArrayList<Workers> getPolices() {
		return (ArrayList<Workers>) polices;
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
