package mru.model;


public class Figures extends Toy{
	
	private String classification;

	public Figures(String serialNumber, String name, String brand, double price, int availableCount, int ageappropriate, String classification){
		super( serialNumber, name,  brand, price, availableCount, ageappropriate);
		this.classification = classification;
	}
	
	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}
}