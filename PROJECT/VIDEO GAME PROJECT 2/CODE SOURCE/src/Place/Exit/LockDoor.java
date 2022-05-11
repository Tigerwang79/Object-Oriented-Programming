package Place.Exit;

import Item.Identity;
import Item.Key;

public class LockDoor extends Exit {

	private boolean locked;
	private Key myKey;

	public LockDoor(Key key) {
		super();
		this.myKey = key;
	}

	public void open(Key k) {
		super.open();
		unLock(k);
	}

	public void close(Key k) {
		super.close();
		lock(k);
	}


	public void lock(Key k) {
		if(!this.isState() && k == this.myKey){
			this.locked = true;
		}else{
			System.out.println("Attention tu ne peux pas la vérouiller, ta porte est ouverte");
		}
	}


	public void unLock(Key k) {
		if(!this.isState() && k == this.myKey){
			this.locked = false;
		}else{
			System.out.println("Attention ta porte est ouverte !");
		}
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Key getMyKey() {
		return myKey;
	}

	public void setMyKey(Key myKey) {
		this.myKey = myKey;
	}
}