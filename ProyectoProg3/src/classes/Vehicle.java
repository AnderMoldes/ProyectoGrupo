package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import classes.Brand.BrandEnum;
import classes.Colour.ColourEnum;

public class Vehicle implements Serializable {
//	private static int counter = 1;
//	private int licensePlate;
	private BrandEnum brand;
	private ColourEnum colour;
	private VehicleTypes vehicles;
	private List<Workers> polices;

	public Vehicle(/*int licensePlate,*/ BrandEnum brand, ColourEnum colour, /*ArrayList<Workers> polices,*/VehicleTypes vehicles) {
		super();
		//this.licensePlate = counter++;
		this.brand = brand;
		this.colour = colour;
		//this.polices = polices;
		this.vehicles = vehicles;
	}

	public Vehicle() {
		super();
		this.brand = BrandEnum.SEAT;
		this.colour = ColourEnum.BLACK;
	//	this.polices = new ArrayList<Workers>();
		this.vehicles = VehicleTypes.PATROLCAR;
	}
//
//	public int getLicensePlate() {
//		return licensePlate;
//	}

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
	public VehicleTypes getVehicleTypes() {
		return vehicles;
	}

	public void setVehicleTypes(VehicleTypes vehicles) {
		this.vehicles = vehicles;
	}

//	public ArrayList<Workers> getPolices() {
//		return (ArrayList<Workers>) polices;
//	}
//
//	public void setPolices(ArrayList<Workers> polices) {
//		this.polices = polices;
//	}
	

	@Override
	public String toString() {
		return "Brand: " + brand + ".  Colour: " + colour + ".   Vehicle Type: "+vehicles;
	}

}
