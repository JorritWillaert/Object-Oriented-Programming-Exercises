package color;

public class Color {
	
	//Values between 0 and 255
	public final int red, green, blue;
	
	public Color(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public int getHue() {
		throw new RuntimeException("Not yet implemented.");
	}
	
	public int getValue() {
		throw new RuntimeException("Not yet implemented.");
	}
	
	public int getSaturation() {
		throw new RuntimeException("Not yet implemented.");
	}
	
	@Override
	public String toString() {
		return "rgb(" + red + ", " + green + ", " + blue + ")";
	}
	
	@Override
	public boolean equals(Object other) {
		return other.getClass() == this.getClass() && 
				((Color)other).red == red &&
				((Color)other).green == green &&
				((Color)other).blue == blue;
	}
}
