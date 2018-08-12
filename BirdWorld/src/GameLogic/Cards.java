package GameLogic;
public class Cards {
	
	private String birdName;
	private int[] attributes = new int[5];
	
	public Cards(String birdName, int[] attributes) {
		this.birdName = birdName;
		this.attributes = attributes;
	}
	
	public String getBirdName() {
		return birdName;
	}
}
