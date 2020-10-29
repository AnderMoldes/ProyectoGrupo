package Classes;

public class Workers {
    public static int counter = 1;

    private int code;
    private String name;
    private String surname;
    private Gender gender;
	public Workers(int code, String name, String surname, Gender gender) {
		super();
		this.code = counter++;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
	}
	public Workers() {
		super();
		this.code = 0;
		this.name = "";
		this.surname = "";
		this.gender = Gender.OTHER;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Workers number " + code + ". Name: " + name + " " + surname + ". Gender: " + gender + "]";
	}
    

}
