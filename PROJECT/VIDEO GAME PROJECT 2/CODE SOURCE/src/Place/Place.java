package Place;

import Place.Exit.Exit;
import Interface.Printable;
import Item.Item;
import Item.Lighter;
import Item.Candle;
import Unity.Enemy.Spectre;
import Unity.Player;
import Unity.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Place implements Printable {

	private final String NAME;
	private List<Exit> ExitList = new ArrayList<>();
	private List<Item> ItemList = new ArrayList<Item>();
	private List<Unit> UnitList = new ArrayList<>();
	private String description;
	private boolean neighbor;
	private boolean playerHere;
	private boolean itemHere;
	private int lvlObscurity;


	public Place(String n, List<Item> i, List<Unit>  u, List<Exit> e, String d, int o) {
		this.NAME = n;
		this.ItemList = i;
		this.UnitList = u;
		this.ExitList = e;
		this.description = d;
		this.neighbor = false;
		this.playerHere = false;
		this.lvlObscurity = o;
	}

	public int checkObscurity(){
		AtomicReference<Player> p = null;
		this.getUnitList().forEach( unit -> {
			if (unit instanceof Player){
				p.set( (Player) unit );
			}
		} );
		p.get().getItemList().forEach( item -> {
			if(item instanceof Lighter){
				if(((Lighter) item).getLight()){
					this.lvlObscurity++;
				}else{
					this.lvlObscurity--;
				}
			}
		} );

		this.getItemList().forEach( item -> {
			if(item instanceof Candle){
				if(((Candle) item).isLight()){
					this.lvlObscurity++;
				}else{
					this.lvlObscurity--;
				}
			}
		} );


		return this.lvlObscurity;
	}

	public boolean isNeighbor(Place p) {

		this.neighbor = false;
		this.ExitList.forEach( exit -> {
			p.ExitList.forEach( exit1 -> {
				if(exit == exit1){
					this.neighbor = true;
				}

			} );
		} );
		return this.neighbor;
	}

	public boolean isItemHere(Item i){
		this.itemHere = false;
		this.getItemList().forEach( item -> {
			if(i == item){
				this.itemHere = true;
			}
		} );
		return this.itemHere;
	}

	public Exit getNeighbor(Place p){
		AtomicReference<Exit> e = new AtomicReference<>();
		if(this.ExitList != null){
			this.ExitList.forEach( exit -> {
				p.ExitList.forEach( exit1 -> {
					if(exit == exit1){
						e.set( exit );
					}

				} );
			} );
		}

		return e.get();
	}

	public Player getPlayer() {
		AtomicReference<Player> p = new AtomicReference<>();
		if(this.UnitList != null){
			this.UnitList.forEach( unit -> {
				if(unit instanceof Player){
					p.set( (Player) unit );
				}
			} );
		}

		return p.get();
	}
	public boolean isPlayerHere(){
		this.playerHere = false;


		if(this.getUnitList() != null){
			this.getUnitList().forEach( unit -> {
				if(unit instanceof  Player){
					this.playerHere = true;
				}
			} );
		}
		return this.playerHere;
	}

	@Override
	public void print() {
		System.out.println("\n" + this.getDescription() + "\n");
	}

	public String getNAME() {
		return NAME;
	}

	public List<Exit> getExitList() {
		return ExitList;
	}

	public void setExitList(List<Exit> exitList) {
		ExitList = exitList;
	}

	public List<Item> getItemList() {
		return ItemList;
	}

	public void setItemList(List<Item> itemList) {
		ItemList = itemList;
	}

	public List<Unit> getUnitList() {
		return UnitList;
	}

	public void setUnitList(List<Unit> unitList) {
		UnitList = unitList;
	}

	public String getDescription() {
		return this.description;
	}

	public boolean isNeighbor() {
		return neighbor;
	}

	public void setNeighbor(boolean neighbor) {
		this.neighbor = neighbor;
	}

	public void setPlayerHere(boolean playerHere) {
		this.playerHere = playerHere;
	}

	public int getLvlObscurity() {
		return lvlObscurity;
	}

	public void setLvlObscurity(int lvlObscurity) {
		this.lvlObscurity = lvlObscurity;
	}
}