/**
 * @author Dan Coleman R00151926
 * @version 1.3 
 * 7/Dec/2017
 */
public class Phone extends Product{
	
	// ---------------------------------------
	// Attributes
	// ---------------------------------------
	private String make; //Make for phone (E.g Samsung)
	private String model;//Model for phone (E.g Galaxy X)
	private int storage;//Gigabytes of storage
	private final static String NAME = "Phone"; //Each Phone used the name "PHONE" as make and Model are more important
	 
	
	// ---------------------------------------
	// Constructors
	// ---------------------------------------
	public Phone(String phoneMake, String productModel, String description, double price, int phoneStorage ){
		super(NAME, description, price);
		this.make =phoneMake;
		this.model =productModel;
		this.storage =phoneStorage;
	}
	

	// ---------------------------------------
	// Get Methods
	// ---------------------------------------
	public int getStorage() {
		return storage;
	}

	public String getModel() {
		return model;
	}
	
	public String getMake() {
		return make;
	}
	
	// ---------------------------------------
	// Set Methods
	// ---------------------------------------
	public void setStorage(byte storage) {
		this.storage = storage;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setMake(String make) {
		this.make = make;
	}
	
	//---------------------------------------
	//Extra Functionality 
	//--------------------------------------
	public void print(){
		super.print();
		
		System.out.println("Make: " + this.make + "\nModel: " + this.model
				+ "\nStorage: " + this.storage + "GB\nProduct ID:" + this.getID()); 
	}
	
}