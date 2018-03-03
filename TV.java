/**
 * @author Dan Coleman R00151926
 * @version 1.3 7/Dec/2017
 * Unused in test build as not in doc
 */
public class TV extends Product {

	// ---------------------------------------
	// Attributes
	// ---------------------------------------
	private String make; // Make for TV (E.g Samsung)
	private byte screenSize; // Screen Size in inches
	private String screenType; // Type of Tv (E.g Plasma, LCD, LED)
	private boolean capable3D; // Is the Television capable of 3D
	private final static String NAME = "TV"; // Name is always set to TV

	// ---------------------------------------
	// Constructors
	// ---------------------------------------
	public TV(String description, double price, String make, byte size, String type, boolean threeD) {
		super(NAME, description, price);
		this.make = make;
		this.screenSize = size;
		this.screenType = type;
		this.capable3D = threeD;
	}

	// ---------------------------------------
	// Get Methods
	// ---------------------------------------
	public String getMake() {
		return make;
	}

	public byte getScreenSize() {
		return screenSize;
	}

	public String getScreenType() {
		return screenType;
	}

	public boolean getCapalbe3D() {
		return capable3D;
	}

	// ---------------------------------------
	// Set Methods
	// ---------------------------------------
	public void setMake(String make) {
		this.make = make;
	}

	public void setScreenSize(byte screenSize) {
		this.screenSize = screenSize;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}

	public void setCapable3D(boolean capable3d) {
		capable3D = capable3d;
	}

	// ---------------------------------------
	// Extra Functionality
	// --------------------------------------
	public void print() {
		super.print();

		System.out.println("Make: " + this.make + "\nScreen Size: " + this.screenSize + "\"\nScreen Type: "
				+ this.screenType + "\nProduct ID: " + this.getID());
	}

}
