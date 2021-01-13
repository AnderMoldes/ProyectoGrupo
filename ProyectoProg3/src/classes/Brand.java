package classes;

//public enum Brand {
//	SEAT,MITSUBISHI,NISSAN,RENAULT,PEUGEOT
//
//}
public class Brand {
public static enum BrandEnum {
	SEAT ("SEAT"), 
	MITSUBISHI ("MITSUBISHI"), 
	NISSAN ("NISSAN"),
	RENAULT ("RENAULT"),
	PEUGEOT ("PEUGEOT");

	private final String brand;

	private BrandEnum(String s) {
		brand = s;
	}

public boolean equalsName(String otherName){
return (otherName == null)? false:brand.equals(otherName);
    }

    public String toString(){
       return brand;
    }
  }
}
