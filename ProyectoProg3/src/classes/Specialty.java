package classes;

//public enum Specialty {
//	DRIVER,DOCTOR,SECURITY
//
//}
public class Specialty {
public static enum SpecialtyEnum {
	DRIVER ("DRIVER"), 
	DOCTOR ("DOCTOR"), 
	SECURITY ("SECURITY");

	private final String specialty;

	private SpecialtyEnum(String s) {
		specialty = s;
	}

public boolean equalsName(String otherName){
return (otherName == null)? false:specialty.equals(otherName);
    }

    public String toString(){
       return specialty;
    }
  }
}