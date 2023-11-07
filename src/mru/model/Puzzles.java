package mru.model;

public class Puzzles extends Toy{

	private String puzzletype;

	public Puzzles(String serialNumber, String name, String brand, double price, int availableCount, int ageappropriate, String puzzletype){
		super( serialNumber, name,  brand, price, availableCount, ageappropriate);
		this.puzzletype = puzzletype;
	}

	public String getPuzzletype() {
		return puzzletype;
	}

	public void setPuzzletype(String puzzletype) {
		this.puzzletype = puzzletype;
	}
	
}
