package color;

public class TransparantColor extends Color {
	
	//Methods from a subclass are overWRITTEN, fields are just overRIDEN, but they still exist!
	
	public final int red; //--> This is an other field than the one in the super class (overriden, but field from Color does still exist!)
	public final int transparancy;
	
	public TransparantColor(int red, int green, int blue, int transparancy) {
		super(red, green, blue); //The first thing you have to do = initialize fields of super class
		this.red = red + 1;
		this.transparancy = transparancy;
	}
	
	@Override
	public String toString() {
		return "rgba(" + red + ", " + green + ", " + blue + ", " + transparancy + ")";
	}
	
	@Override
	public boolean equals(Object other) {
		return super.equals(other) &&
				((TransparantColor)other).transparancy == transparancy;
	}
}
