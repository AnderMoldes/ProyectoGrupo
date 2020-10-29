package Classes;

import java.util.ArrayList;

public class Police_Station {
	private String name;
	private int numWorkers;
	private String address;
	private ArrayList<Boss> boss;
	private ArrayList<Workers> workers;
	private ArrayList<Detained> detained;

	public Police_Station(String name, int numWorkers, String address, ArrayList<Boss> boss, ArrayList<Workers> workers,
			ArrayList<Detained> detained) {
		super();
		this.name = name;
		this.numWorkers = numWorkers;
		this.address = address;
		this.boss = new ArrayList<Boss>(boss);
		this.workers = new ArrayList<Workers>(workers);
		this.detained = new ArrayList<Detained>(detained);
	}

	public Police_Station() {
		super();
		this.name = "";
		this.numWorkers = 0;
		this.address = "";
		this.boss = new ArrayList<Boss>();
		this.workers = new ArrayList<Workers>();
		this.detained = new ArrayList<Detained>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumWorkers() {
		return numWorkers;
	}

	public void setNumWorkers(int numWorkers) {
		this.numWorkers = numWorkers;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Boss> getBoss() {
		return boss;
	}

	public void setBoss(ArrayList<Boss> boss) {
		this.boss = new ArrayList<Boss>(boss);
	}

	public ArrayList<Workers> getWorkers() {
		return workers;
	}

	public void setWorkers(ArrayList<Workers> workers) {
		this.workers = new ArrayList<Workers>(workers);
	}

	public ArrayList<Detained> getDetained() {
		return detained;
	}

	public void setDetained(ArrayList<Detained> detained) {
		this.detained = new ArrayList<Detained>(detained);;
	}

	@Override
	public String toString() {
		return "Police_Station [name=" + name + ", numWorkers=" + numWorkers + ", address=" + address + ", boss=" + boss
				+ ", workers=" + workers + ", detained=" + detained + "]";
	}

}