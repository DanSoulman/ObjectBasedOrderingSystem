import java.util.ArrayList;

/**
 * @author Dan Coleman R00151926
 * @version 1.8 
 * 7/Dec/2017
 */

public class Customer {
	ArrayList<Order> order;
	

	// ---------------------------------------
	// Attributes
	// ---------------------------------------
	private String name; // name of a product
	private String address;// Description of a product
	private static int count;
	private int id; 
	// ---------------------------------------
	// Constructors
	// ---------------------------------------
	public Customer(String customerName, String customerAddress) { 
		this.name = customerName;
		this.address = customerAddress;
		
		order = new ArrayList<Order>();
		count++;
		id = count;
	}
	
	// ---------------------------------------
	// Get Methods
	// ---------------------------------------
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	
	public Order getOrder(int i) {
		
		return order.get(i);
	}
	
	public void addOrder(Order order) {
		this.order.add(order);
	}

	// ---------------------------------------
	// Set Methods
	// ---------------------------------------
	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

	// ---------------------------------------
	// Extra Functionality
	// --------------------------------------
	/*public String toString() {
	String string = "";
	string += "Name: " + this.name + "\nAddress" + this.address  ; //Adds lecturers name and ID to info String
	return string;
	}*/
	
	/**
	 * Prints out the list for each order
	 */
	public void printOrders() {
		
		for(int i = 0; i < order.size(); i++) {
			System.out.println("Order " + (i + 1));
			order.get(i).printAll();
		}
	}
	
}
