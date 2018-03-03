/**
 * @author Dan Coleman R00151926
 * @version 1.3 
 * 7/Nov/2017
 */
public class Product {
	

		// ---------------------------------------
		// Attributes
		// ---------------------------------------
		private String name; //name of product type
		private String description;//Description of a product
		private double price;//Price of a product
		private static int IDcount=0;//Each ID increments the counter by one
		private int ID; //Unique ID of a product
		
		// ---------------------------------------
		// Constructors
		// ---------------------------------------
		@SuppressWarnings("static-access")
		public Product(String pName, String pDescription, double pPrice){
			this.name = pName;
			this.description = pDescription;
			this.price = pPrice;
			this.IDcount += 1;
			this.ID = IDcount;
		}
		
		// ---------------------------------------
		// Get Methods
		// ---------------------------------------
		public String getName() {
			return this.name; //returns current name
		}
		
		public String getDescription() {
			return this.description; //returns current description
		}
		
		
		public double getPrice(){
			return this.price;//returns current Price
		}
		
		public int getID() {
			return this.ID; //returns current ID
		} 
		
	
		
		// ---------------------------------------
		// Set Methods
		// ---------------------------------------
		public void setName(String name){
			this.name = name;
		}
		
		public void setDescription(String description){
			this.description = description;
		}
		
		public void setPrice(double price){
			this.price = price;
		}
		
		
		//---------------------------------------
		//Extra Functionality 
		//--------------------------------------
		public String toString() {
			String product = "";
			product += "Name: " + this.name + "\nDescription: " + this.description + "\nPrice: €" + this.price; //Adds lecturers name and ID to info String
			return product;
			}
		
		public void print(){
			System.out.println(toString()); //Prints toString
		}
}
