package classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PoliceStation implements Serializable{ 
	private String name;
	private int numWorkers;
	private String address;
	private ArrayList<Workers> workers;
	private ArrayList<Detained> detained;
	private ArrayList<Vehicle> vehicles;
	private HashMap<Asignable, ArrayList<Detained>> hmWorDetai;
	private HashMap<Asignable, ArrayList<Vehicle>> hmWorVehi;

	

	

	public PoliceStation(String name, int numWorkers, String address, ArrayList<Workers> workers,
			ArrayList<Detained> detained, ArrayList<Vehicle> vehicles,
			HashMap<Asignable, ArrayList<Detained>> hmWorDetai, HashMap<Asignable, ArrayList<Vehicle>> hmWorVehi) {
		super();
		this.name = name;
		this.numWorkers = numWorkers;
		this.address = address;
		this.workers = new ArrayList<Workers>(workers);
		this.detained = new ArrayList<Detained>(detained);
		this.vehicles = new ArrayList<Vehicle>(vehicles);
		this.hmWorDetai = new HashMap<>(hmWorDetai);
		this.hmWorVehi = new HashMap<>(hmWorVehi);
	}
	public PoliceStation() {
		super();
		this.name = "";
		this.numWorkers = 0;
		this.address = "";
		this.workers = new ArrayList<Workers>();
		this.detained = new ArrayList<Detained>();
		this.vehicles = new ArrayList<Vehicle>();
		this.hmWorDetai = new HashMap<Asignable,ArrayList<Detained>>();
		this.hmWorVehi = new HashMap<Asignable, ArrayList<Vehicle>>();
		
	}
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the numWorkers
	 */
	public int getNumWorkers() {
		return numWorkers;
	}
	/**
	 * @param numWorkers the numWorkers to set
	 */
	public void setNumWorkers(int numWorkers) {
		this.numWorkers = numWorkers;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the workers
	 */
	public ArrayList<Workers> getWorkers() {
		return workers;
	}
	/**
	 * @param workers the workers to set
	 */
	public void setWorkers(ArrayList<Workers> workers) {
		this.workers = new ArrayList<Workers>(workers);
	}
	/**
	 * @return the detained
	 */
	public ArrayList<Detained> getDetained() {
		return detained;
	}
	/**
	 * @param detained the detained to set
	 */
	public void setDetained(ArrayList<Detained> detained) {
		this.detained = new ArrayList<Detained>(detained);
	}
	/**
	 * @return the vehicles
	 */
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = new ArrayList<Vehicle>(vehicles);
	}
	/**
	 * @return the hmWorDetai
	 */
	public HashMap<Asignable, ArrayList<Detained>> getHmWorDetai() {
		return hmWorDetai;
	}
	/**
	 * @param hmWorDetai the hmWorDetai to set
	 */
	public void setHmWorDetai(HashMap<Asignable, ArrayList<Detained>> hmWorDetai) {
		this.hmWorDetai = new HashMap<Asignable, ArrayList<Detained>>(hmWorDetai);
	}
	/**
	 * @return the hmWorVehi
	 */
	public HashMap<Asignable, ArrayList<Vehicle>> getHmWorVehi() {
		return hmWorVehi;
	}
	/**
	 * @param hmWorVehi the hmWorVehi to set
	 */
	public void setHmWorVehi(HashMap<Asignable, ArrayList<Vehicle>> hmWorVehi) {
		this.hmWorVehi = new HashMap<Asignable, ArrayList<Vehicle>>(hmWorVehi);
	}
	public void saveFile(String fileName) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
			
			PoliceStation police = (PoliceStation) ois.readObject();
			
			this.setAddress(police.getAddress());
			this.setDetained(police.getDetained());
			this.setName(police.getName());
			this.setWorkers(police.getWorkers());
			this.setVehicles(police.getVehicles());
			this.setHmWorDetai(police.getHmWorDetai());
			this.setHmWorVehi(police.getHmWorVehi());
			
			ois.close();
		} catch (IOException e) {
			System.out.println("Error accessing the file "+ fileName);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro reading de file" + fileName);
		}
	}

	@Override
	public String toString() {
		return "PoliceStation [name=" + name + ", numWorkers=" + numWorkers + ", address=" + address + ", workers="
				+ workers + ", detained=" + detained + ", vehicles=" + vehicles + "]";
	}

	

}