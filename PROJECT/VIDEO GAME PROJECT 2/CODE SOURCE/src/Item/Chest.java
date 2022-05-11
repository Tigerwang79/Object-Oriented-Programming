package Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chest extends Item {

	protected boolean state;
	private boolean locked;
	private List<Item> items = new ArrayList<Item>();
	private Key myKey;

	public Chest(Key key, List<Item> i, Identity id) {
		super.setId( id );
		this.myKey = key;
		close(myKey);
		this.items = i;
	}

	public void open(Key k) {
		if(this.myKey == k) {
			unLock( k );
			this.state = true;
			System.out.println("Inventaire du coffre : " );
			items.forEach( item -> {
				System.out.println("\t-"+ item.getId().getName() + "\n" + item.getId().getDescription());
			} );
		}else {
			System.out.println("Clé incorrete, impossible d'ouvrir la porte !");
		}
	}

	public void close(Key k){
		if(k == this.myKey){
			lock( k );
			this.state = false;
		}else{
			this.state = false;
			System.out.println("Impossible de vérouiller la porte, clé incorrecte, la porte se ferme simplement !");
		}
	}

	public void lock(Key k) {
		if(!this.isState() && k == this.myKey){
			this.locked = true;
		}else{
			System.out.println("Attention tu ne peux pas la vérrouiller, ta porte est ouverte");
		}
	}

	public void unLock(Key k) {
		if(!this.isState() && k == this.myKey){
			this.locked = false;
		}else{
			System.out.println("Attention ta porte est ouverte !");
		}
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Key getMyKey() {
		return myKey;
	}

	public void setMyKey(Key myKey) {
		this.myKey = myKey;
	}
}