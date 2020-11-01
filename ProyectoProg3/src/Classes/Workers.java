package Classes;

public class Workers {
    public static int counter = 1;

    private int code;
    private String name;
    private String surname;
    private String gender;
    
	public Workers(int code, String name, String surname, String gender) {
		super();
		this.code = counter++;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
	}
	public Workers() {
		super();
		this.name = "";
		this.surname = "";
		this.gender = "";
	}
	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Workers number " + code + ". Name: " + name + " " + surname + ". Gender: " + gender + "]";
	}
    

}
