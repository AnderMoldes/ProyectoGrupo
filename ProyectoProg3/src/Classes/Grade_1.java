package Classes;

public class Grade_1 extends Workers{
	
	private String especialidad;

	public Grade_1(int code, String name, String surname, String especialidad) {
		super(code, name, surname);
		this.especialidad = especialidad;
	}
	
	public Grade_1() {
		super();
		this.especialidad = "";
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Grade_1 [especialidad=" + especialidad + ", getEspecialidad()=" + getEspecialidad() + ", getCode()="
				+ getCode() + ", getName()=" + getName() + ", getSurname()=" + getSurname() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
}
