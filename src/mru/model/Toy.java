package mru.model;

public abstract class Toy {
	protected String serialNumber;
	protected String name;
	protected String brand;
	private double price;
	private int availableCount;
	private int ageAppropriate;
	
	public Toy(String serialNumber, String name, String brand, double price, int availableCount, int ageappropriate) {
		this.serialNumber = serialNumber;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availableCount = availableCount;
		this.ageAppropriate = ageappropriate;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailableCount() {
		return availableCount;
	}
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	public int getAgeAppropriate() {
		return ageAppropriate;
	}
	public void setAgeAppropriate(int ageappropriate) {
		this.ageAppropriate = ageappropriate;
	}
	/**
	A method to format the Toy object properties to a readable string for display on the screen
	@return a formatted string with the toy's properties
	*/
    public String formatToScreen(){
		String c = this.getClass().getName();
		c = c.replaceAll("model.", "");
		if (this instanceof  Animals){
			Animals a = (Animals) this;
			return "category:" +c+ ", SerialNumber:"+serialNumber+", Name:"+name+", Brands:" +brand+", Price:" +price+", Available Count:" +availableCount+", Age Appropriate:" +ageAppropriate+", Material:"+a.getMaterial()+", Size:"+a.getSize();
		}
		if (this instanceof BoardGames){
			BoardGames b = (BoardGames) this;
			return "category:" +c+ ", SerialNumber:"+serialNumber+", Name:"+name+", Brands:" +brand+", Price:" +price+", Available Count:" +availableCount+", Age Appropriate:" +ageAppropriate+"; Number of min Players:"+b.getMinPlayers()+"; Number of max Players:"+b.getMaxPlayers()+"; Designer:"+b.getDesigner();
		}
		if (this instanceof Figures){
			Figures f = (Figures) this;
			return "category:" +c+ ", SerialNumber:"+serialNumber+", Name:"+name+", Brands:" +brand+", Price:" +price+", Available Count:" +availableCount+", Age Appropriate:" +ageAppropriate+"; Classification:"+f.getClassification();
		}
		if (this instanceof Puzzles){
			Puzzles p = (Puzzles) this;
			return "category:" +c+ ", SerialNumber:"+serialNumber+", Name:"+name+", Brands:" +brand+", Price:" +price+", Available Count:" +availableCount+", Age Appropriate:" +ageAppropriate+"; Puzzle Type:"+p.getPuzzletype();
		}
		return "type invalid";
	}
	/**
	A method to format the Toy object properties to a string for writing to a file
	@return a formatted string with the toy's properties
	*/
	public String formatToFile(){
		if (this instanceof Animals){
			Animals a = (Animals) this;
			return serialNumber+";" +name+ ";" +brand+ ";" +price+ ";" +availableCount+ ";" +ageAppropriate+";"+a.getMaterial()+";"+a.getSize();
		}
		if (this instanceof BoardGames){
			BoardGames b = (BoardGames) this;
			return serialNumber+";" +name+ ";" +brand+ ";" +price+ ";" +availableCount+ ";" +ageAppropriate+";"+b.getMinPlayers()+"-"+b.getMaxPlayers()+";"+b.getDesigner();
		}
		if (this instanceof Figures){
			Figures f = (Figures) this;
			return serialNumber+";" +name+ ";" +brand+ ";" +price+ ";" +availableCount+ ";" +ageAppropriate+";"+f.getClassification();
		}
		if (this instanceof Puzzles){
			Puzzles p = (Puzzles) this;
			return serialNumber+";" +name+ ";" +brand+ ";" +price+ ";" +availableCount+ ";" +ageAppropriate+";"+p.getPuzzletype();
		}
		return "type invalid";
	}
}
