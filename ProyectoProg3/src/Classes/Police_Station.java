package Classes;

public class Police_Station {
    private String name;
    private int workers;
    private String address;

    public Police_Station(String name, int workers, String address) {
        super();
        this.name = name;
        this.workers = workers;
        this.address = address;
    }
    public Police_Station() {
        super();
        this.name = "";
        this.workers = 0;
        this.address = "";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWorkers() {
        return workers;
    }
    public void setWorkers(int workers) {
        this.workers = workers;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Police_Station [name=" + name + ", workers=" + workers + ", address=" + address + "]";
    }





}