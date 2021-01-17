package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import classes.Brand.BrandEnum;
import classes.Colour.ColourEnum;

public class Vehicle implements Serializable {
	private String licensePlate;
	private BrandEnum brand;
	private ColourEnum colour;
	private VehicleTypes vehicles;

	public Vehicle(BrandEnum brand, ColourEnum colour, VehicleTypes vehicles,String licensePlate) {
		super();
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.colour = colour;
		this.vehicles = vehicles;
	}

	public Vehicle() {
		super();
		this.brand = BrandEnum.SEAT;
		this.colour = ColourEnum.BLACK;
		this.vehicles = VehicleTypes.PATROLCAR;
		this.licensePlate = "";
	}
	
	

	/**
	 * @return the licensePlate
	 */
	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * @param licensePlate the licensePlate to set
	 */
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
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
	public VehicleTypes getVehicleTypes() {
		return vehicles;
	}

	public void setVehicleTypes(VehicleTypes vehicles) {
		this.vehicles = vehicles;
	}

	

	@Override
	public String toString() {
		return "Brand: " + brand + ".  Colour: " + colour + ".   Vehicle Type: "+vehicles+". License Plate: "+licensePlate;
	}

}
