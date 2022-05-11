package Unity.Enemy;

import Item.Item;
import Item.Weapons.Weapon;
import Place.Place;
import Unity.Player;
import t_enum.Rarity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Devil extends Enemy {

	private final String NAME;

	public Devil(String name, List<Item> i, int w,  Rarity r){

		List<String> talk = new ArrayList<>();
		String talk1 = "Hahahahaha !";
		talk.add( talk1 );
		String talk2 = "Tu m'as l'air bien appétissant !";
		talk.add( talk2 );
		String talk3 = "Viens me retrouver dans la cave petit !";
		talk.add( talk3 );
		this.NAME = name;


		super.setDead( false );
		super.setHealth( super.getMAX_HEALTH() );
		super.setWallet( w );
		super.setItemList( i );
		super.setMyRarity( r );
		super.setTalking( talk );
		super.setCc_attack( super.myCC( r ) );
	}

	@Override
	public void print() {

	}

	@Override
	public <T extends Enemy> void attackEnemy(T e, Weapon w) {

	}

	@Override
	public void dead(Player p) {
		if(super.getHealth() == 0){
			System.out.println("Vous avez vaincu " + this.getNAME() + " !");
			super.setDead( true );
		}
	}

	public String getNAME() {
		return NAME;
	}
}