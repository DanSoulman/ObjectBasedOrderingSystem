import java.util.InputMismatchException;
import java.util.*;

public class Test {
	final static Scanner kb = new Scanner(System.in);
	static ProductDb pDatabase = new ProductDb();
	static ArrayList<Customer> customerList = new ArrayList<Customer>();

	public static void main(String[] args) {

		// ------------------------------------------------------------------
		// ArrayLists + Attributes
		// ------------------------------------------------------------------

		boolean exit = false; // Allows user to exit menu and terminate program
		// -----------------------------------------------------------------
		// Menu
		// -----------------------------------------------------------------
		while (exit == false) {
			System.out.println("1. Create New Phone");
			System.out.println("2. Search for a product by supplying the productid");
			System.out.println("3. Display all products");
			System.out.println("4. Order Products");
			System.out.println("5. Display all orders");
			System.out.println("6. Exit");

			int choice = newVerifyNum();
			kb.nextLine();
			switch (choice) {

			case 1:
				printTitle("Create New Phone:");
				addPhone();
				break;
			case 2:
				printTitle("Search for a product by supplying the productid:");
				searchID();
				break;
			case 3:
				printTitle("Display all products:");
				printDatabase();
				break;
			case 4:
				printTitle("Order Products:");
				addOrder();
				break;
			case 5:
				printTitle("Display all orders:");
				displayAllOrders();
				break;
			case 6:
				System.out.println("Exiting...");
				// Exits the program.
				exit = true;
				break;
			default:
				System.out.println("Please enter a number between 1 and 6 (inclusive)");
			}
			System.out.println("\nPress Return to continue");
			kb.nextLine();
		}

	}

	// -------------------------------------------------------
	// Menu Methods
	// -------------------------------------------------------
	/**
	 * Prints the title card, featuring users name.
	 * 
	 * @param name
	 *            Name of the menu.
	 */
	private static void printTitle(String name) {
		System.out.println(name);
		System.out.println("-------------------------\n");
	}

	// -------------------------------------------------------
	// Verification Methods
	// -------------------------------------------------------
	/**
	 * Verifies my strings
	 * @param prompt Question to user
	 * @param prompt2 Error message
	 * @return value: Whatever String was needed
	 */
	private static String stringInput(String prompt, String prompt2) {
		String value;
		System.out.println(prompt);
		value = kb.nextLine();
		while (value.isEmpty()) {
			System.out.println(prompt2);
			value = kb.nextLine();
		}

		return value;

	}
/**
 * My original verify Num, used in my project until I made a better one, due to strict deadline I didn't replace all use of this 
 * @param param What the num must be higher than to pass
 * @param prompt The question asked to user
 * @return returns the num
 */
	private static int verifyNum(int param, String prompt) {
		int start = -1; // Auto caught on the InputMismatch unless changed
		System.out.println(prompt);
		do {
			try {
				start = kb.nextInt();
			}

			catch (InputMismatchException e) { // Catches incorrect Data type
				System.out.println("Please enter a numeric character");
				kb.next();
			}
			if (start < param) {
				System.out.println("Enter a number greater than or equal to " + param);
			}
		} while (start < param);

		return start;
	}
//Improved version
	private static int newVerifyNum() {

		int input = -1;
		boolean verify = false;

		do {
			verify = true;
			try {

				input = kb.nextInt();

			} catch (InputMismatchException e) {
				kb.nextLine();
				verify = false;
				System.out.println("Enter an int");
			}
		} while (verify == false);

		return input;
	}
	
	/* REDUNDANT!!!!
	//Validates that menu isn't a string
	private static int menuValidator() {
		boolean verify = false;
		int input = -1;
		do {
			verify = true;
			try {
				input = kb.nextInt();
				

			} catch (InputMismatchException e) {
				kb.nextLine();
				verify = false;
				System.out.println("Enter an int");
			}
		} while (verify == false);

		return input;
	}*/
	

	// -------------------------------------------------------
	// Case 1 Methods
	// -------------------------------------------------------
	private static void addPhone() {
		String make;
		String model;
		String description;
		double price = -1;
		int storage = -1;
		//Sets and Verifies each variable
		make = stringInput("Please Input make", "Error, Empty String");
		model = stringInput("Please Input model", "Error, Empty String");
		description = stringInput("Please Input description", "Error, Empty String");
		price = verifyNum(0, "Please Input Price");
		storage = verifyNum(0, "Please Input Storage (in GB)");
		//Adds product to Database
		pDatabase.addProduct(new Phone(make, model, description, price, storage));
	}
	// -------------------------------------------------------
	// Case 2 Methods
	// -------------------------------------------------------

	private static void searchID() {
		System.out.println("Find by ID");
		System.out.println("Enter product ID (ID starts at 1");
		int id = kb.nextInt();
		pDatabase.printByID(id);
	}

	// -------------------------------------------------------
	// Case 3 Methods
	// -------------------------------------------------------
	private static void printDatabase() {
		pDatabase.printAll();
	}

	// -------------------------------------------------------
	// Case 4 Methods
	// -------------------------------------------------------
	private static void addOrder() {
		//Attributes
		int input;
		int id;
		int quantity;
		String name;
		String address;
		boolean verify = false;
		// ArrayLists
		Customer cust = null;
		Order ord = null;
		//OrderDetails ordDet = null;
		
		Product genericStorage = null;
		// Variables 
		name = stringInput("Enter customer name", "ERROR STRING CANNOT BE EMPTY");
		address = stringInput("Enter customer address", "ERROR STRING CANNOT BE EMPTY");
		cust = new Customer(name, address);
		ord = new Order();
		do {
			verify = false;
			System.out.println("Enter the product ID for the product you wish to order");
			id = -1;//Forced into verifier at least once
			while (id < 1)
				id = newVerifyNum();

			System.out.println("Enter the quantity you wish to order");
			quantity = -1;
			while (quantity < 1)
				quantity = newVerifyNum();

			genericStorage = pDatabase.findByID(id); //Temporary Storage

			ord.addProduct(genericStorage, quantity);

			System.out.println("Add another order?\n1. Yes\n2. No");
			input = -1;
			while (input < 1 || input > 2)
				input = newVerifyNum();

			if (input == 2) {
				verify = true;
				cust.addOrder(ord);
				customerList.add(cust);
			}
		} while (verify == false);

		// -------------------------------------------------------
		// Case 5 Methods
		// -------------------------------------------------------

	}

	private static void displayAllOrders() {
		String name = new String();

		//Customer cust = null;
		

		name = stringInput("Enter name of customer", "ERROR EMPTY STRING EMPTY STRING");

		for (int i = 0; i < customerList.size(); i++) {
			if (name.equals(customerList.get(i).getName())) {
				customerList.get(i).printOrders();
				break;
			}
		}
	}
}
