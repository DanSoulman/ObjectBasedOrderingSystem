
/**
 * @author Dan Coleman R00151926
 * @version 1.8
 * 07/Dec/2017
 */
public class OrderDetails {

	// ---------------------------------------
	// Attributes
	// ---------------------------------------
	private Product product; // The name of the product
	private int quantity; // The number of said product in stock

	// ---------------------------------------
	// Constructors
	// ---------------------------------------
	public OrderDetails(Product dProduct, int dQuantity) {
		this.product = dProduct;
		this.quantity = dQuantity;

	}

	// ---------------------------------------
	// Get Methods
	// ---------------------------------------
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	// ---------------------------------------
	// Set Methods
	// ---------------------------------------
	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// ---------------------------------------
	// Extra Functionality
	// --------------------------------------
	/*
	 * public String toString() { String details = ""; details += "Product :" +
	 * this.product.getName() + "\nhas a quantity of: " + this.quantity; //Moves the
	 * info on the product to a String return details; }
	 */
	public void print() {
		String details = new String();
		
		if(product instanceof Phone)
		details += "Make: " + (((Phone) this.product).getMake()) + "\nModel:" + (((Phone) this.product).getModel()) + "\nhas a quantity of: " + this.quantity;
		
		if(product instanceof TV)
			details += "Make: " + (((TV) this.product).getMake()) + "\nScreen Type: " + (((TV) this.product).getScreenType()) + "\nhas a quantity of: " + this.quantity;
			
		System.out.println(details);
	}
}