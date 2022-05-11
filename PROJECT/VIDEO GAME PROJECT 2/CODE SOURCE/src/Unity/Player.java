package Unity;

import Item.Food;
import Item.Chest;
import Item.Item;
import Item.Sedative;
import Item.Weapons.Weapon;
import Place.Place;
import Unity.Enemy.Enemy;
import Unity.NPC.Gardener;
import t_enum.Rarity;

import java.util.List;

public class Player extends Unit {

	private final String NAME;
	private int mentalHealth;
	private boolean attacked;
/*	private Place myPlace;*/
	private boolean itemHere;


	public Player(String name, List<Item> i, int w, Place p) {

		this.NAME = name;
		this.attacked = false;
		this.mentalHealth = super.getMAX_HEALTH();
/*		this.myPlace = p;*/

		super.setDead( false );
		super.setHealth( super.getMAX_HEALTH() );
		super.setWallet( w );
		super.setItemList( i );
	}


	@Override
	public void print() {
		System.out.println("Nom: " + getNAME());
		System.out.println("Attaked" + isAttacked());
		System.out.println("Vie:" + getHealth());
		System.out.println("Mental: " + getMentalHealth());
		System.out.println("Argent: " + getWallet());
		getItemList().forEach( item -> {
			item.print();
		} );

	}


	/*Récupération d'items d'un coffre*/
	public void takeItem(Chest c){
		if(c.isState()){
			System.out.println("Vous avez récupéré :");
			c.getItems().forEach( item -> {
				System.out.println("\t-" + item.getId().getName());
				this.getItemList().add( item );
				c.getItems().remove( item );
			} );
		}
	}

	/*Echange un item avec le jardinier*/
	public void gardenerExchange(Gardener g, Item i) {
		if (g.isTalkative()) {
			g.getItemList().forEach(item -> {
				if(i == item){
					System.out.println("\t-" + item.getId().getName());
					this.getItemList().add( item );
					g.getItemList().remove( item );
					int wallet =- item.getId().getValue();
					super.setWallet(wallet);
				}
			});
		}
	}

	/*SAvoir si le joueur à bien un objet en quesiton*/
	public boolean isItemHere(Item i){
		System.out.println(" Inventaire : \n");
		if(!this.itemHere) {
			System.out.println("Inventaire vide.");
		}
		else {
			this.getItemList().forEach( item -> {
			if(i == item){
				this.itemHere = true;
			}
		} );
		}
		return this.itemHere;
	}

	//Méthode restauration des HP, usage unique supprimé des items que possèdent le joueur
	public void restoreH(Food f){
		if(super.getHealth()+f.getHealth() > 100 ){
			super.setHealth( 100 );
		}else {
			super.setHealth( super.getHealth() + f.getHealth() );
		}
		super.deleteItem( f );
	}

	//Méthode restauration du Mental, usage unique supprimé des items que possèdent le joueur
	public void restoreMH(Sedative s){
		if(this.getMentalHealth() + s.getHealing() > 100){
				setMentalHealth( 100 );
		}else{
				this.setMentalHealth( this.getMentalHealth() + s.getHealing() );
		}
		super.deleteItem( s );
	}


	/*Retire de la santé mental*/
	public void painMH(int n){
		if(this.mentalHealth - n <=0){
			System.out.println("Vous êtes devenu fou, la maison à eu raison de vous. Par conséquence, le Démon vous a transformé en spectre");
			this.setDead( true );
			this.setMentalHealth( 0 );
		}else{

			setMentalHealth( this.mentalHealth - n );
		}
	}

	public int getMentalHealth() {
		return mentalHealth;
	}

	public void setMentalHealth(int mentalHealth) {
		this.mentalHealth = mentalHealth;
	}

	/* Cherche à savoir si le player peut ou pas attaquer un ennemi avec son arme */
	public boolean canAttak(Enemy e, Weapon w){
		if(e.getMyRarity() == Rarity.common && w.getMyRarity() == Rarity.common){
			this.attacked = true;
		}else if(e.getMyRarity() == Rarity.unusual && w.getMyRarity() == Rarity.unusual){
			this.attacked = true;
		}else if(e.getMyRarity() == Rarity.epic && w.getMyRarity() == Rarity.epic){
			this.attacked = true;
		}else if(e.getMyRarity() == Rarity.legendary && w.getMyRarity() == Rarity.legendary){
			this.attacked = true;
		}else if(e.getMyRarity() == Rarity.common && ( w.getMyRarity() == Rarity.common
				|| w.getMyRarity() == Rarity.unusual || w.getMyRarity() == Rarity.epic
				|| w.getMyRarity() == Rarity.legendary)){
			this.attacked = true;
		}else if(e.getMyRarity() == Rarity.unusual && ( w.getMyRarity() == Rarity.unusual
				|| w.getMyRarity() == Rarity.epic || w.getMyRarity() == Rarity.legendary)){
			this.attacked = true;
		}else if(e.getMyRarity() == Rarity.epic && (w.getMyRarity() == Rarity.epic || w.getMyRarity() == Rarity.legendary)){
			this.attacked = true;
		}else {
			this.attacked = false;
		}
		return this.attacked;
	}


	@Override
	public <T extends Enemy>void attackEnemy(T e, Weapon w) {
		if(canAttak( e, w )){

			if(e.getHealth()-w.getDamage() < 0){
				e.dead(this);

			}else {
				e.setHealth( w.getDamage() );

			}
			this.attacked = false;
		}
	}

	@Override
	public void aleaAttak(Player p) {

	}

/*
	public Place getMyPlace() {
		return this.myPlace;
	}

	public void setMyPlace(Place myPlace) {
		this.myPlace = myPlace;
	}*/

	public String getNAME() {
		return NAME;
	}

	public boolean isAttacked() {
		return attacked;
	}

	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}


	public boolean isItemHere() {
		return itemHere;
	}

	public void setItemHere(boolean itemHere) {
		this.itemHere = itemHere;
	}
}