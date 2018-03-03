import java.util.Scanner;
import java.util.ArrayList;
/**
 * @author Dan Coleman R00151926
 * @version 1.3 
 * 7/Dec/2017
 *Based on Beatles.java
 */
//Used Beatles.java for help 
public class Order {
	final static Scanner kb = new Scanner(System.in);
	ArrayList<OrderDetails> orderList; //Declares the ArrayList OrderList


	// ---------------------------------------
	// Constructors
	// ---------------------------------------
	public Order() {
		orderList = new ArrayList<OrderDetails>(); //Creates new List
	}
	
		// ---------------------------------------
		// Get Methods
		// ---------------------------------------
		public ArrayList<OrderDetails> getOrder() {
			return this.orderList;
		}
		
		// ---------------------------------------
		// Set Methods
		// ---------------------------------------

		// ---------------------------------------
		// Extra Functionality
		// --------------------------------------
	
	public void addProduct(Product product, int quantity) {
		OrderDetails od = new OrderDetails(product, quantity);
		this.orderList.add(od);
		System.out.println("Added new product to index " + (this.orderList.size()-1) + " with quantity of: " + quantity);
	}
	
	public void printAll() {
		for(int i = 0; i < orderList.size(); i++) {
			orderList.get(i).print();
		}
	}
	
}