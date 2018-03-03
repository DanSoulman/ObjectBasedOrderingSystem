import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Dan Coleman R00151926
 * @version 1.8 
 * 07/Dec/2017
 *  Based on Beatles.java
 */

public class ProductDb {
	final static Scanner kb = new Scanner(System.in);
	ArrayList<Product> productDB;
	// ---------------------------------------
	// Constructors
	// ---------------------------------------
	public ProductDb() {
		productDB = new ArrayList<Product>();
	}

	// ---------------------------------------
	// Get Methods
	// ---------------------------------------
	public ArrayList<Product> getDB() {
		return this.productDB;
	}
	
	// ---------------------------------------
	// Set Methods
	// ---------------------------------------

	// ---------------------------------------
	// Extra Functionality
	// --------------------------------------
	
	//--------------------------
	//Adding a Product
	//--------------------------
	/**
	 * Adds a product to the ArrayList productDb if it's not null
	 * 
	 */
	public void addProduct(Product product) {
		if (product != null) {
			this.productDB.add(product);
			System.out.println("Added new product to index " + this.productDB.indexOf(product));
			/*
			 * System.out.println("Input quantity of product: "); int quantity =
			 * kb.nextInt(); kb.nextLine();
			 */
		}

		else
			System.out.println("Null reference passed through"); //If there is no product prints a warning
	}
	
	//--------------------------
	//Remove a Product
	//--------------------------
	/**
	 * Removes a product from the list and compresses the list.
	 */
	public void removeProduct() {
		System.out.println("Put in the Product ID of the product you would like to remove");
		int ID = kb.nextInt();
		boolean check = false;
		for(int i = 0; i < productDB.size(); i++) {
			if(productDB.get(i).getID() == ID) {
				this.productDB.remove(i);
				System.out.println("Product removed!");
				check = true;
			}
		}
			
		if(check == false) {
			System.out.println("NOT FOUND");
		}
		kb.nextLine();
		
	}
	//--------------------------
	//Find by ID
	//--------------------------
	/**
	 * 
	 * @param id Unique ID to find Product by
	 * @return ret the product the user was looking for 
	 */
	public Product findByID(int id) {
		Product ret = null;
		
		for (int i = 0; i < productDB.size(); i++) {
			if (productDB.get(i) != null) {
				if (id == productDB.get(i).getID()) { //If it's not null and ID matches one of the unique ID's 
					System.out.println("Product found at index " + i);
					ret = productDB.get(i);
					break;
				}
			}
		}
		return ret;
	}
	//----------------------------------------------
	//Print All
	//----------------------------------------------
	/**
	 * prints all of the proucts in the database
	 */
	public void printAll() {
		for(int i = 0; i < productDB.size();i++) {
			if(productDB.get(i) instanceof Phone)
			((Phone) productDB.get(i)).print();
			
			else if(productDB.get(i) instanceof TV)
				((TV) productDB.get(i)).print();
		}
	}
	//----------------------------------------------
	//Print by ID
	//----------------------------------------------
/**
 * //It's the same as find byID but prints out more info
 * @param id Unique ID for a product 
 */
	public void printByID(int id) { 
		Product prod = findByID(id);
		prod.print();
	}
}
