package mru.model;

public class BoardGames extends Toy{

	
	private int maxPlayers;
	private int minPlayers;
	private String designer;
	
	public BoardGames(String serialNumber, String name, String brand, double price, int availableCount, int ageappropriate, int maxPlayers, int minPlayers, String designer){
		super( serialNumber, name,  brand, price, availableCount, ageappropriate);
		this.maxPlayers=maxPlayers;
		this.minPlayers=minPlayers;
		this.designer=designer;
	}
	public int getMinPlayers() {
		return minPlayers;
	}
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}
	public int getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
	}
}
