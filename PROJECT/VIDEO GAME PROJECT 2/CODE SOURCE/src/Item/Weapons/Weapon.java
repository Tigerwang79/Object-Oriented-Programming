package Item.Weapons;
import t_enum.Rarity;
import Item.Item;

public abstract class Weapon extends Item {

	private int damage;
	private Rarity myRarity;

	public int getDamage() {
		return damage;
	}



	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Rarity getMyRarity() {
		return myRarity;
	}

	public void setMyRarity(Rarity myRarity) {
		this.myRarity = myRarity;
	}


}