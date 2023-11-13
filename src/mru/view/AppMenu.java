package mru.view;

import java.util.ArrayList;
import java.util.Scanner;

import mru.exceptions.MaxMinException;
import mru.exceptions.PriceException;
import mru.exceptions.ValidatePriceException;
import mru.exceptions.ValidateMaxMinException;
import mru.model.Animals;
import mru.model.BoardGames;
import mru.model.Figures;
import mru.model.Puzzles;
import mru.model.Toy;

public class AppMenu {
	
	Scanner input;
	public AppMenu() {
		input = new Scanner(System.in);
	}
	/**
	Displays the main menu for the user to choose from different options.
	@return the integer value of the user's chosen option
	*/
	public int showmainmenu() {
		while(true){
			System.out.println("*********************************************************");
			System.out.println("*            WELCOME TO TOY STORE COMPANY!              *");
			System.out.println("*********************************************************\n");
			System.out.println("\tHow May We Help You?\n");
			System.out.println("\t(1) Search Inventory and Purchase Toy");
			System.out.println("\t(2) Add New Toy");
			System.out.println("\t(3) Remove Toy");
			System.out.println("\t(4) Save & Exit\n");
			System.out.print("\tEnter Option:\n");
		
			String OptionStr = input.next();
			if (OptionStr.matches("\\d+")) {
				int Option=Integer.parseInt(OptionStr);
				if (Option >=1 && Option <=4 ){	
					return Option;
				}
			}
			System.out.println("That is not a valid option! Try again.\n");
		}	
	}
	/**

	Displays the submenu for the user to choose from different search options.
	@return the integer value of the user's chosen option
	*/
	public int showSubMenu() {
		while (true){
		System.out.println("\tFind toys with:\n");
		System.out.println("\t(1) Serial Number(SN)");
		System.out.println("\t(2) Toy Name");
		System.out.println("\t(3) type");
		System.out.println("\t(4) Back to Main menu");
		System.out.print("\tEnter Option:");
		String OptionStr = input.next();
		if (OptionStr.matches("\\d+")) {
			int Option=Integer.parseInt(OptionStr);
			if (Option >=1 && Option <=4 ){	
				return Option;
			}
		}
		System.out.println("That is not a valid option! Try again.\n");
	}	
}
	/**

	Asks the user to enter a serial number and returns it.
	@return a string of the user's entered serial number
	*/
	public String getSerialNumber(){
		System.out.print("Enter a Serial Number:\n");
		String SN = input.next();
		return SN;
	}
	/**

	Displays a message to the user informing them that their input is not valid and waits for them to press enter to continue.
	*/
	public void notValid(){
		System.out.print("Not a valid input, Press Enter... \n");
		input.nextLine();
		input.nextLine();

	}
	/**

	Asks the user to enter a toy name and returns it.
	@return a string of the user's entered toy name
	*/
	public String getToyName(){
		System.out.print("Enter Toy Name:");
		String name = input.next();
		return name;
	}
	/**

	Asks the user to enter a toy type and returns it.
	@return a string of the user's entered toy type
	*/
	public String getType(){
	    System.out.print("Enter a type:\n");
	    input.nextLine();  // Add this line to capture the newline character from previous input
	    String type = input.nextLine();  // Use nextLine instead of next to capture the whole input line
	    return type;
	}
	/**

	Prints a list of toys to the console for the user to view.
	@param toys an ArrayList of Toys objects to be printed to the console
	*/
	public void printToys(ArrayList<Toy> toys){
		String c = this.getClass().getName();
		c = c.replaceAll("model.", "");
		for(int n=0; n<toys.size(); n++){
			System.out.printf("(%d) %s\n",n +1 , toys.get(n).formatToScreen());
		}
	}
	/**
	A method to prompt the user to enter the option number of a toy they want to purchase,
	and check if the selected toy is available for purchase.
	@param toys an ArrayList of Toys objects
	@return the selected Toys object if it's available for purchase, null otherwise
	*/
	public Toy PurchaseListIndex(ArrayList<Toy> toys){
		System.out.print("Enter option number to purchase:");

		String optionStr = input.next();
		if (!optionStr.matches("\\d+")){
			System.out.print("This option is invalid:\n");
			System.out.println("Press Enter to continue...");
			input.nextLine();
			input.nextLine();
			return null;
		}
		int option=Integer.parseInt(optionStr);
		int index = option -1;
		if (option<1 || option>toys.size()){
			System.out.print("This option is invalid:\n");
			return null;
		}
		Toy selectedtoy = toys.get(index);
		if (selectedtoy.getAvailableCount()<1){
			System.out.print("This toy is out of stock:");
			return null;
		}
		return selectedtoy;
	}
	/**
	A method to prompt the user to enter the serial number of a toy they want to remove,
	and validate the input.
	@return a String representing the serial number of the toy to be removed
	*/
	public String removetoy(){
		while (true) {
			System.out.print("Enter a Serial Number:");
		
			String serialNumber = input.next();
			if (serialNumber.matches("\\d{10}")) {
					return serialNumber;
			}	
			System.out.println("Error: Invalid Serial Number. Please enter a 10-digit integer.");
		
		}
	}
	/**
	A method to print a message informing the user that the item was removed
	*/
	public void toyRemoved() {
		System.out.println("Item Removed!\n");
		System.out.println("Press Enter to continue...");
		input.nextLine();
		input.nextLine();
	}
	/**
	A method to print a message informing the user that the item was not found
	*/
	public void noItem() {
		System.out.println("Item Not Found\n");
		System.out.println("Press Enter to continue...");
		input.nextLine();
		input.nextLine();
	}
	/**
	A method to prompt the user if they want to remove a specific toy, and validate the input.
	@param t the Toys object to be removed
	@return a String representing the user's choice to remove the toy or not
	*/
	public String toyToRemove(Toy t){
		System.out.print("This Item Found:\n");
		System.out.print(t.formatToScreen());
		while (true){
			System.out.print("\n Do you want to remove it (Y/N)?");
			String option = input.next().toLowerCase();
			if (option.equals("y") || option.equals("n")){
				return option;
			}
		}
	}


	public Toy addnewtoy() {
			input = new Scanner(System.in);
			// Prompt user for serial number
			String serialNumber="";
			while (true) {
				System.out.println("Enter Serial Number (10 digits): ");
				serialNumber = input.next();
			if (serialNumber.matches("\\d{10}")) {
					break;
			}	 else {
			System.out.println("Error: Invalid Serial Number. Please enter a 10-digit integer.");
			}
			}
			// Prompt user for toy name
			System.out.println("Enter Toy Name: ");
			String toyName=input.next();
			// Prompt user for toy brand
			System.out.println("Enter Toy Brand: ");
			String toyBrand=input.next();
			// Prompt user for toy price
			double toyPrice = 0.0;
			while(true){
				System.out.println("Enter Toy Price: ");
				String toyPriceStr = input.next();
				if (toyPriceStr.matches("([0-9]*[.])?[0-9]+")) {
				
				try {
					toyPrice = Double.parseDouble(toyPriceStr);
					ValidatePriceException.Validate(toyPrice);
					break;
				} catch (PriceException e) {
					
					System.out.println(e.getMessage());
				}
				break;
			}
			}
			// Prompt user for available count
			int availableCount = 0;
			while (true) {
					System.out.println("Enter Available Count: ");
					String inp = input.next();
					if (inp.matches("\\d+")) {
					availableCount = Integer.parseInt(inp);
						break;
					} else {
						System.out.println("Error: Invalid Available Count. Please enter a non-negative integer.");
					}
			}
			// Prompt user for appropriate age
			int appropriateAge = 0;
			while (true) {
				System.out.println("Enter Appropriate Age: ");
				String inp = input.next();
				if (inp.matches("\\d+")) {
				appropriateAge = Integer.parseInt(inp);
				break;
				} else {
					System.out.println("Error: Invalid Appropriate Age. Please enter a non-negative integer.");
				}
			}
			
			char firstchar = serialNumber.charAt(0);
			if (firstchar == '0' || firstchar == '1') { 
				System.out.println("Enter classification: Action, Doll, or Historic");
				String classification=input.next();
				Figures t = new Figures(serialNumber,toyName,toyBrand,toyPrice,availableCount,appropriateAge,classification);
				return t;
			}
			if (firstchar == '2' || firstchar == '3') { 
				System.out.println("Enter material type:");
				String material=input.next();
				System.out.println("Enter size: Small, Medium, or Large");
				String size=input.next();
				Animals t = new Animals(serialNumber,toyName,toyBrand,toyPrice,availableCount,appropriateAge,material,size);
				return t;
			}
			if (firstchar == '4' || firstchar == '5' || firstchar == '6') {
				System.out.println("Enter puzzle-type: Mechanical, Cryptic, Logic, Trivia, or Riddle");
				String puzzletype=input.next();
				Puzzles t = new Puzzles(serialNumber,toyName,toyBrand,toyPrice,availableCount,appropriateAge,puzzletype);
				return t;
			}
			if (firstchar == '7' || firstchar == '8' || firstchar == '9') {
					// Prompt user for minimum number of players
				int minPlayers = 0;
				int maxPlayers = 0;
				while (true) {
					System.out.println("Enter Minimum Number of Players: ");
					String inp = input.next();
					if (inp.matches("\\d+")) {
						minPlayers = Integer.parseInt(inp);
							
					
					// Prompt user for maximum number of players
					System.out.println("Enter Maximum Number of Players: ");
					String inpt = input.next();
					maxPlayers = Integer.parseInt(inpt);
					try {
						ValidateMaxMinException.Validate(maxPlayers, minPlayers);
					} catch (MaxMinException e) {
						System.out.println(e.getMessage());
					}
						break;
				}
				}
					// Prompt user for designer names
					System.out.println("Enter Designer Names (use ',' to separate the names if there is more than one): ");

					String designerNames=input.next();
					// Print confirmation message
					BoardGames t = new BoardGames(serialNumber,toyName,toyBrand,toyPrice,availableCount,appropriateAge, maxPlayers,minPlayers,designerNames);
					return t;
			}
		
		return null;
		}
		/*
		Displays a message indicating that a new toy has been successfully added.
		Waits for user input before continuing.
		*/
		public void ToyAddedMessgae() {
			System.out.println("New Toy Added!");
			System.out.println("Press Enter to continue...");
			input.nextLine();
			input.nextLine();
		}
		public void purchaseComplete() {
			System.out.println("The Transaction Successfully Completed!\n");
			System.out.println("Press Enter to continue...");
			input.nextLine();
			input.nextLine();
		}

	
}
/*
Displays a message indicating that a new toy has been successfully added.
Waits for user input before continuing.
*/
