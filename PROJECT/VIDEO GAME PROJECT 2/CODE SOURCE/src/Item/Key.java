package Item;

public class Key extends Item {

	private final String NAME;
	private final int ID;

	public Key(String n, int id) {
		this.NAME = n;
		this.ID = id;
	}

	public String getName() {
		return NAME;
	}

	public int getID() {
		return ID;
	}
}