package Item;

import Interface.Printable;

public abstract class Item implements Printable {



	private Identity id;


	@Override
	public void print() {
		System.out.println("Nom " + getId().getName() );
		System.out.println("Description" + getId().getDescription());
	}
	public Identity getId() {
		return id;
	}

	public void setId(Identity id) {
		this.id = id;
	}

}