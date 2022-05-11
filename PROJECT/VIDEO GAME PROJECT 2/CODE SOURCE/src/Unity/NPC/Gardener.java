package Unity.NPC;

import Item.Item;
import Item.MagicTablet;
import Item.Weapons.Weapon;
import Unity.Enemy.Enemy;
import Unity.Player;
import Unity.Unit;

import java.util.*;

public class Gardener extends Npc {

	private final String NAME;
	protected boolean talkative;
	private List<Item> secretItem = new ArrayList<Item>();

	public Gardener(String name, List<Item> i, List<Item> secretItem,int wa, Weapon we) {
		this.NAME = name;
		this.talkative = false;
		this.secretItem = secretItem;
		super.setDead(false);
		super.setHealth(super.getMAX_HEALTH());
		super.setWallet(wa);
		super.setItemList(i);
		super.setWeapon(we);
		super.setCc_attack(100);
	}

	//Affichage des items à vendre
	public void exchange() {
		if (this.isTalkative()) {
			System.out.println("Voici quelques articles en ma possession : ");
			super.getItemList().forEach( item -> {
				System.out.println("\t-"+ item.getId().getName() + item.getId().getValue() + "\n" + item.getId().getDescription());
				Scanner sc = new Scanner(System.in);
				System.out.println("Indique moi le nom de l'article qui t'intéresse : ");
				String answer = sc.next();
				if (answer.equals( item.getId().getName())) {
					if (super.getWallet() >= item.getId().getValue()) {
						System.out.println("Voici ton article.");
						System.out.println("\t" + item.getId().getName() + item.getId().getValue() + "\n" + item.getId().getDescription());
					}else {
						System.out.println("Tu n'as pas assez d'argent pour pouvoir acheter cet article !");
					}
				} else {
					System.out.println("Je ne possède pas cet article sur moi.");
				}
			} );
		}
	}

	/**
	 * 
	 * @param Items
	 */
	public void craft(int Items) {
	}

	@Override
	public void print() {

	}




	public String getNAME() {
		return NAME;
	}

	public boolean isTalkative() {
		return talkative;
	}



	@Override
	public void dead(Player p) {
		if(super.getHealth() == 0){
			System.out.println("Vous avez vaincu " + this.getNAME() + " !");
			super.setDead( true );
		}
	}

	public void setTalkative(boolean talkative) {
		this.talkative = talkative;
	}

	public List<Item> getSecretItem() {
		return secretItem;
	}

	public void setSecretItem(List<Item> secretItem) {
		this.secretItem = secretItem;
	}

	@Override
	public <T extends Enemy> void attackEnemy(T e, Weapon w) {

	}
}