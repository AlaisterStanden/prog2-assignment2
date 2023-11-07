package mru.model;

public class Animals extends Toy{

	private String material;
	private String size;
	
	public Animals(String serialNumber, String name, String brand, double price, int availableCount, int ageappropriate, String material, String size){
		super( serialNumber, name,  brand, price, availableCount, ageappropriate);
		this.material=material;
		this.size=size;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
}