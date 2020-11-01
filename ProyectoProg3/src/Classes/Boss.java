package Classes;

public class Boss extends Workers{
	private int codeBoss;
	private String function;
	
	
	public Boss(int code, String name, String surname, String gender, int codeBoss, String function) {
		super(code, name, surname, gender);
		this.codeBoss = codeBoss;
		this.function = function;
	}
	
	public Boss() {
		super();
		this.codeBoss = 0;
		this.function = "";
	}

	public int getCodeBoss() {
		return codeBoss;
	}

	public void setCodeBoss(int codeBoss) {
		this.codeBoss = codeBoss;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	@Override
	public String toString() {
		return "Boss [codeBoss=" + codeBoss + ", function=" + function + ", getCode()=" + getCode() + ", getName()="
				+ getName() + ", getSurname()=" + getSurname() + ", getGender()=" + getGender() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
	

}
