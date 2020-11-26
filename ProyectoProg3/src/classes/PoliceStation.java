package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PoliceStation implements Serializable{ 
	private String name;
	private int numWorkers;
	private String address;
	private List<Workers> workers;
	private List<Detained> detained;

	public PoliceStation(String name, int numWorkers, String address, ArrayList<Workers> workers,
			ArrayList<Detained> detained) {
		super();
		this.name = name;
		this.numWorkers = numWorkers;
		this.address = address;
		this.workers = new ArrayList<Workers>(workers);
		this.detained = new ArrayList<Detained>(detained);
	}

	public PoliceStation() {
		super();
		this.name = "";
		this.numWorkers = 0;
		this.address = "";
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

	public ArrayList<Workers> getWorkers() {
		return (ArrayList<Workers>) workers;
	}

	public void setWorkers(ArrayList<Workers> workers) {
		this.workers = new ArrayList<Workers>(workers);
	}

	public ArrayList<Detained> getDetained() {
		return (ArrayList<Detained>) detained;
	}

	public void setDetained(ArrayList<Detained> detained) {
		this.detained = new ArrayList<Detained>(detained);;
	}

	@Override
	public String toString() {
		return "Police_Station [name=" + name + ", numWorkers=" + numWorkers + ", address=" + address + ", , workers=" + workers + ", detained=" + detained + "]";
	}

}