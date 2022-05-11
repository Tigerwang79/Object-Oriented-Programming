package Game;

import Item.Item;
import Item.Weapons.ColtSAA45;
import Place.Exit.LockDoor;
import Place.Exit.Exit;
import Place.Exit.MagicDoor;
import Place.Place;
import Unity.Enemy.Devil;
import Unity.Enemy.Spectre;
import Unity.Player;
import Item.MagicTablet;
import Item.Sedative;
import Item.Food;
import Item.Flashlight;
import Item.Chest;
import Item.Key;
import Item.Candle;
import Item.Battery;
import Item.Lighter;
import Item.SilverBullet;

import Item.Key;

import java.util.List;

public class Interaction {

	/************************************************	ACTIONS POSSIBLE POUR JOUER	*************************************************/
	public void go(Place dest, Place src) {

		if(src.isNeighbor(dest)){

			Exit e = src.getNeighbor( dest );

			if(e instanceof LockDoor){
				if(((LockDoor) e).isLocked()){

					src.getPlayer().getItemList().forEach( item -> {
						if(item == ((LockDoor) e).getMyKey()){
							System.out.println("Vous possédez la clé pour rentrer dans la pièce, Vous l'utilisez pour entrer dans " + dest.getNAME() +".");
							((LockDoor) e).open( ((Key) item) );
							src.getPlayer().getItemList().remove( item );
							src.getUnitList().remove( src.getPlayer() );
							dest.getUnitList().add( src.getPlayer() );

						}else {
							System.out.println("Vous ne pouvez pas accéder à cette pièce: " + dest.getNAME());
							System.out.println("Une clé est requise: " + ((LockDoor) e).getMyKey().getName());
						}
					} );
				}
			}else if(e instanceof MagicDoor){
				src.getPlayer().getItemList().forEach( item -> {
					if(item == ((MagicDoor) e).getMyTablet()){
						((MagicDoor) e).open((MagicTablet) item);
						System.out.println("La tablette à ouvert la porte, vous y entrez.");
						src.getUnitList().remove( src.getPlayer() );
						src.getPlayer().getItemList().remove( item );
						dest.getUnitList().add( src.getPlayer() );
					}else{
						System.out.println("Il semble qu'un objet sois requis pour entrer dans cette pièce.");
					}
				} );
			}else{
				if(!(e.isState())){
					e.open();
					System.out.println("La porte était fermée, vous l'ouvrez et entrez dans la pièce " + dest.getNAME() + ".");
					src.getUnitList().remove( src.getPlayer() );
					dest.getUnitList().add( src.getPlayer() );
				}
			}
		}

	}

	public void help() {
		System.out.println("Voici les actions que vous pouvez effectuer");
		System.out.println("\t-GO [Location], permet de se rendre dans un lieu");
		System.out.println("\t-LOOK [Place], Découvre le lieu dans lequel vous êtes");
		System.out.println("\t-USE [Item] ?[Item], utiliser 1 ou 2 deux objets pour effectuer une action");
		System.out.println("\t-TAKE [Item], Récupère l'objet présent dans la pièce");
		System.out.println("\t-GARDENER, se rendre directement auprès du jardinier");
	}


	public void look(List<Place> lp, Place p) {
		System.out.println("Voici les ennemis qui rodent: ");
		p.getUnitList().forEach( unit -> {
			if(unit instanceof Spectre){
				System.out.println("\t-" + ((Spectre) unit).getNAME());
			}else if(unit instanceof Devil){
				System.out.println("\t-" + ((Devil) unit).getNAME());
			}
		} );
		System.out.println("Sortie disponible:");
		lp.forEach( place -> {
			if(place.isNeighbor(p)){
				System.out.println("\t-"+place.getNAME());
			}
		} );
		System.out.println("Objets se trouvant dans la pièce.");
		p.getItemList().forEach( item -> {
			System.out.println("\t-" + item.getId().getName() + ": " + item.getId().getDescription());
		} );



	}

	public void take(Item i, Place src){
		if(src.isItemHere( i )){
			System.out.println("Vous avez récupéré " + i.getId().getName());
			src.getPlayer().getItemList().add( i );
			src.getItemList().remove( i );
		}
	}

	public void quit() {
		System.exit( 0 );
	}

	public void use(Item i1, Item i2, Place src) {
		if(i2 == null){
			if(i1 instanceof Sedative){
				src.getPlayer().restoreMH( (Sedative) i1 );
			}else if(i1 instanceof Food){
				src.getPlayer().restoreH( (Food) i1 );
			}else if (i1 instanceof Flashlight){
				if(((Flashlight) i1).isActivate()){
					((Flashlight) i1).turnOff();
					System.out.println("Lampe torche éteinte");
				}else {
					((Flashlight) i1).turnOn();
					System.out.println("Lampe torche Allumé");
				}
			}
		}else if(  (src.isItemHere( i1 ) || src.getPlayer().isItemHere( i1 )) &&  (src.isItemHere( i2 ) || src.getPlayer().isItemHere( i2 )) ){
			if(i1 instanceof Flashlight && i2 instanceof Battery){
				((Flashlight) i1).changeBattery( (Battery) i2 );
				src.getPlayer().getItemList().remove( i2 );
			}else if(i1 instanceof Chest && i2 instanceof Key){
				((Chest) i1).open( (Key) i2 );
				src.getPlayer().getItemList().remove( i2 );
				src.getPlayer().takeItem( (Chest) i1 );
			}else if(i1 instanceof Lighter && i2 instanceof Battery){
				((Lighter) i1).changeBattery( (Battery) i2 );
				src.getPlayer().getItemList().remove( i2 );
			}else if(i1 instanceof ColtSAA45 && i2 instanceof SilverBullet){
				((ColtSAA45) i1).reload( (SilverBullet) i2 );
				src.getPlayer().getItemList().remove( (SilverBullet) i2 );
			}
		}

	}

	public void gardener(Place dest, Place src) {
		System.out.println("Vous vous redirigez vers le jardinier.");
		go( dest, src );
	}

	public void inventaire(Place src){
		src.getPlayer().getItemList().forEach( item -> {
			item.print();
		} );
	}

}