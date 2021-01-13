package classes;

//public enum Colour {
//	RED,BLUE,BLACK,WHITE,GREEN,GOLD,GREY
//
//}
public class Colour {
public static enum ColourEnum {
	RED ("RED"), 
	BLUE ("BLUE"), 
	BLACK ("BLACK"),
	WHITE ("WHITE"),
	GREEN ("GREEN"),
	GOLD("GOLD"),
	GREY("GREY");

	private final String colour;

	private ColourEnum(String s) {
		colour = s;
	}

public boolean equalsName(String otherName){
return (otherName == null)? false:colour.equals(otherName);
    }

    public String toString(){
       return colour;
    }
  }
}
