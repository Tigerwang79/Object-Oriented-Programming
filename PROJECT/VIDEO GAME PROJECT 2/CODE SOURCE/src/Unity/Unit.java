package Unity;

import Interface.Attack;
import Interface.Printable;
import Item.Item;
import Unity.Enemy.Enemy;

import java.util.ArrayList;
import java.util.List;

public abstract class Unit implements Attack, Printable {


	private final int MAX_HEALTH = 100;
	private int Health;
	private List<Item> ItemList = new ArrayList<Item>();
	private int Wallet;
	private boolean dead;


    /*Suppression d'un item dans notre liste*/
	public <T extends Item> void deleteItem(T e){
		ItemList.remove( e );
	}

	public int getWallet() {
		return Wallet;
	}

	public void setWallet(int wallet) {
		Wallet = wallet;
	}

	public List<Item> getItemList() {
		return ItemList;
	}

	public void setItemList(List<Item> itemList) {
		ItemList = itemList;
	}

	public int getHealth() {
		return Health;
	}

	public void setHealth(int health) {
		Health = health;
	}

	public int getMAX_HEALTH() {
		return MAX_HEALTH;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	@Override
	public void attackPlayer(Player p) {

	}
}