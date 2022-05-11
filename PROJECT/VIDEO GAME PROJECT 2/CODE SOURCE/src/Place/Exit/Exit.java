package Place.Exit;

import Interface.Printable;
import Item.Identity;

public class Exit implements Printable {

	protected boolean state;


	public Exit() {

		close();
	}

	public void open(){
		this.state = true;
	}

	public void close(){
		this.state = false;
	}

	@Override
	public void print() {

	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}


}