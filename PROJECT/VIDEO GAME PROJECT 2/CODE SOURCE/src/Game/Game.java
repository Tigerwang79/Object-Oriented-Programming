package Game;
import Item.*;
import Item.Item;
import Item.Key;
import Item.Weapons.*;
import Place.Exit.Exit;
import Place.Exit.LockDoor;
import Place.Place;
import Unity.Enemy.Devil;
import Unity.Enemy.Enemy;
import Unity.Enemy.Spectre;
import Unity.NPC.Gardener;
import Unity.Player;
import Unity.Unit;
import t_enum.Rarity;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Game {

	private List<Place> placeList = new ArrayList<Place>();
	private Interaction myInteraction;


	public Game(Interaction interactions){
		initPlaceList( this.placeList, garden, vestibule, couloir2, salon );
		this.myInteraction = interactions;
	}

/************************************************	initialistaion des elements du jeux	*************************************************/
	/******************************	KEYS	*********************************/
	private final Key  keyVS = new Key("Clé pour se rendre à l'escalier", 0);
	private final Key  keyC2C1 = new Key("Clé pour se rendre au Couloir 1", 1);
	private final Key  keyC2C3 = new Key("Clé pour se rendre au Couloir 3", 2);
	private final Key  keySpecial1 = new Key("Clé pour ouvrir toutes les portes de la cuisine", 3);
	private final Key  keyC1SM = new Key("Clé pour ouvrir se rendre à la salle à manger", 4);
	private final Key  keyC3CH3 = new Key("Clé pour ouvrir toutes les portes de la chambre 3", 5);
	private final Key  keyC3SJ = new Key("Clé pour ouvrir la salle de jeux", 6);

	/****************************** 	EXITS	*********************************/
	//Jardin à Vestibule
	private final Exit jv = new Exit();
	//Vestibule à C2
	private final Exit vc2 = new Exit();
	//Escalier à Vestibule
	private final LockDoor ev = new LockDoor( this.keyVS );
	//C2 à Salon
	private final Exit c2s = new Exit();
	//C2 à C1
	private final LockDoor c2c1 = new LockDoor( this.keyC2C1 );
	//C2 à C3
	private final LockDoor c2c3 = new LockDoor( this.keyC2C3 );
	//Salon à Cuisine
	private final LockDoor scui = new LockDoor( this.keySpecial1 );
	//C1 à B1
	private final Exit c1b1 = new Exit();
	//C1 à CH1
	private final Exit c1ch1 = new Exit();
	//C1 à SM
	private final LockDoor c1sm = new LockDoor( this.keyC1SM );
	//C1 à Cui
	private final LockDoor c1cui = new LockDoor( this.keySpecial1  );
	//SM à Cui
	private final LockDoor smcui = new LockDoor( this.keySpecial1  );
	//C3 à CH2
	private final Exit c3ch2 = new Exit();
	//C3 à SB
	private final Exit c3sb = new Exit();
	// C3 à CH3
	private final LockDoor c3ch3 = new LockDoor( this.keyC3CH3  );
	//C3 à SJ
	private final LockDoor c3sj = new LockDoor( this.keyC3SJ );
	//CH2 à SB
	private final Exit ch2sb = new Exit(  );
	//CH3 à SJ
	private final Exit ch3sj = new Exit( );


	/******************************	Identity	*********************************/
	private Identity identityWS = new Identity( 10, "Bâton", "Cette arme à failbe dégat permet d'affronter de simple spectre" );
	private Identity identitySD = new Identity( 50, "Dague", "Une arme assez puissante pour affronter des spectres puisssants" );
	private Identity identityColt = new Identity( 75, "Colt", "Ce petit pistolet t'aidera à tuer les spectres" );
	private Identity identityAZB = new Identity( 150,"Lamed'Azrael", "La lame d'Azrael, cette lame si spécial qu'elle tuera n'importe qu'elle Demon" );
	private Identity identitySB = new Identity( 6, "Chargeur", "");
	private Identity identityFlashLight = new Identity( 5, "Lampe", "");
	private Identity identityBattery = new Identity( 5, "Pile", "");
	private Identity identityLighter = new Identity( 10, "Briquet", "");
	private Identity identityCandle = new Identity( 10, "Boujie", "");
	private Identity identityChest = new Identity( 100, "Coffre", "");
	private Identity identityFood = new Identity( 20, "Aliment", "");
	private Identity identityMagicTalblet = new Identity( 10, "TabletteMagique", "");
	private Identity identityMagicTalbletFargment = new Identity( 10, "Pierre", "");
	private Identity identitySedative  = new Identity( 10, "Calmant", "");

	/******************************	Lists Items	*********************************/
	///////////////////////////////// For Player

	private Battery battery = new Battery(identityBattery);
	private Flashlight flashlight = new Flashlight(battery, identityFlashLight);
	private WoodStaff woodStaff = new WoodStaff( 20, Rarity.common, identityWS, false);

	private List<Item> itemsPlayer = new ArrayList<Item>();

	public Flashlight getFlashlight() {
		return flashlight;
	}

	////////////////////////////// For gardener

	private WoodStaff woodStaffGardener = new WoodStaff( 20, Rarity.common, identityWS, false );
	private AzraelBlade azraelBladeGardener = new AzraelBlade( 100, Rarity.epic, identityAZB, false );
	private SilverDagger silverDaggerGardener = new SilverDagger( 50, Rarity.unusual, identitySD,false );
	private ColtSAA45 coltSAA45Gardener = new ColtSAA45( 60, Rarity.unusual, identityColt, new SilverBullet( 6, identitySB ),false );
	private Lighter lighterGardener = new Lighter(identityLighter, identityBattery);
	private MagicTablet magicTablet = new MagicTablet(identityMagicTalblet);

	private List<Item> itemsGardener = new ArrayList<Item>();
	private List<Item> itemsSecret = new ArrayList<Item>();

	private SilverDagger SDGardener = new SilverDagger( 75, Rarity.unusual, identitySD,false );


	///////////////////////////////// For Spectre

	private List<Item> itemsSpectre00 = new ArrayList<Item>();
	private List<Item> itemsSpectre01 = new ArrayList<Item>();
	private List<Item> itemsSpectre02 = new ArrayList<Item>();
	private List<Item> itemsSpectre03 = new ArrayList<Item>();
	private List<Item> itemsSpectre04 = new ArrayList<Item>();
	private List<Item> itemsSpectre05 = new ArrayList<Item>();



	///////////////////////////// For Cheat
	private  MagicTabletFragment magicTabletFragment00 = new MagicTabletFragment(identityMagicTalbletFargment);
	private  MagicTabletFragment magicTabletFragment01 = new MagicTabletFragment(identityMagicTalbletFargment);
	private  MagicTabletFragment magicTabletFragment02 = new MagicTabletFragment(identityMagicTalbletFargment);

	/////////////////////////// For Vestibule
	private Key keyChestVestibule = new Key( "Clé du coffre Vestibule", 7);
	private List<Item> itemsChestVestibule = new ArrayList<Item>();
	private Chest chestVestibule = new Chest( keyChestVestibule, initItemList( itemsChestVestibule, new Food(identityFood), new Food(identityFood), new Food(identityFood) ), identityChest );

	/////////////////////////// For Salon
	private Key keyChestSalon = new Key( "Clé du coffre du Salon", 8);
	private List<Item> itemsChestSalon = new ArrayList<Item>();
	private Chest chestSalon = new Chest( keyChestSalon, initItemList( itemsChestSalon, new Food(identityFood), keyC2C1 ), identityChest );




	/******************************	Units	*********************************/

	private Player myPlayer = new Player( "Arthur",
			initItemList( itemsPlayer, flashlight, woodStaff, new Battery(identityBattery), new Battery(identityBattery) ) ,10, this.vestibule );

	private Gardener gardener = new Gardener( "Edward",
			initItemList( itemsGardener, woodStaffGardener, azraelBladeGardener, silverDaggerGardener, coltSAA45Gardener, lighterGardener ),
			initItemList( itemsSecret, magicTablet, keyVS ), 0, SDGardener);

	/*Units Vestibule*/

	private Spectre spectre00 = new Spectre( "Roger",
			initItemList( itemsSpectre00, new Battery(identityBattery) ), 10, Rarity.common );
	private Spectre spectre01 = new Spectre( "Mirielle",
			initItemList( itemsSpectre01, new Food(identityFood) ), 5, Rarity.common );
	private Spectre spectre02 = new Spectre( "Bob", initItemList( itemsSpectre02, keyChestVestibule ), 5, Rarity.common );


	/*Units Salon*/

	private Spectre spectre03 = new Spectre( "Homme",
			initItemList( itemsSpectre03, new Lighter(identityLighter, identityBattery), new Battery(identityBattery), new Battery(identityBattery) ), 15, Rarity.common );
	private Spectre spectre04 = new Spectre( "Kaido",
			initItemList( itemsSpectre04, new Food(identityFood), new Sedative(identitySedative) ), 10, Rarity.common );
	private Spectre spectre05 = new Spectre( "Dora", initItemList( itemsSpectre05, keyChestSalon ), 20, Rarity.common );

	/*Unit Cave*/
	private Devil devilBoss = new Devil( "Rokfort", null, 5000, Rarity.legendary );

	/******************************	Places	*********************************/
	//////////////////////////Garden
	private List<Unit> unitListGarden = new ArrayList<>();
	private List<Exit> exitsListGarden = new ArrayList<>();
	private List<Item> itemsGarden = new ArrayList<Item>();

	private Place garden = new Place( "Jardin",
			initItemList( itemsGarden, magicTabletFragment00, new Candle(identityCandle), new Candle(identityCandle) ),
			initUnitList( unitListGarden, this.gardener, this.myPlayer ),
			initExitList( exitsListGarden, this.jv ), "", 0);


	////////////////////////////////// Vestibule
	private List<Unit> unitListVestibule = new ArrayList<>();
	private List<Exit> exitsListVestibule = new ArrayList<>();
	private List<Item> itemsListVestibule = new ArrayList<Item>();

	private Place vestibule = new Place( "Vestibule"
			,initItemList( itemsListVestibule, new Candle(identityCandle), new Candle(identityCandle), magicTabletFragment01, chestVestibule )
			,initUnitList( unitListVestibule, spectre00, spectre01, spectre02 )
			,initExitList( exitsListVestibule, jv, vc2, ev ), "", 0
			);

	///////////////////////////////Couloir 2


	private List<Exit> exitsListCouloir2 = new ArrayList<>();
	private List<Item> itemsListCouloir2 = new ArrayList<Item>();

	private Place couloir2 = new Place( "Couloir2"
			,initItemList( itemsListVestibule, new Candle(identityCandle), new Candle(identityCandle) )
			, null
			,initExitList( exitsListCouloir2, c2c1, c2c3, vc2, c2s ), "", 0
	);

	////////////////////////////////Salon
	private List<Unit> unitListSalon = new ArrayList<>();
	private List<Exit> exitsListSalon = new ArrayList<>();
	private List<Item> itemsListSalon = new ArrayList<Item>();

	private Place salon = new Place( "Salon"
			,initItemList( itemsListVestibule, new Candle(identityCandle), new Candle(identityCandle), magicTabletFragment02, chestSalon )
			,initUnitList( unitListVestibule, spectre03, spectre04, spectre05 )
			,initExitList( exitsListSalon, c2s, scui ), "", 0
	);


	///////////////////////////////Couloir 1


	private List<Exit> exitsListCouloir1 = new ArrayList<>();
	private List<Item> itemsListCouloir1 = new ArrayList<Item>();

	private Place Couloir1 = new Place( "Couloir1"
			,initItemList( itemsListCouloir1, new Candle(identityCandle), new Candle(identityCandle) )
			, null
			,initExitList( exitsListCouloir1, c2c1, c1b1, c1ch1, c1cui, c1sm ), "", 0
	);

/************************************************	FIN initialistaion des elements du jeux	*************************************************/




/******************************	Game	*********************************/


	public void synopsis(){
		System.out.println("\n\tArthur Glayman chasseur de fantômes à mi-temps, il découvre de mystérieux meurtres à Montmorency dans le Val d’oise. Piqué de curiosité sur cette histoire, il décide de partir enquêter. \n" +
				"\tEn menant une petite enquête, Arthur déniche le point commun entre les meurtres, c’est le cerveau, les cadavres n’en ont plus, comme s’il avait été aspirer. \n\tArthur se souvenait d’une histoire qu’il avait entendu, il comprit qu’il avait à faire à un Spectre démoniaque . Le Spectre aime manger le cerveau de leur proie et jouer avec elle. \n" +
				"\tEn recherchant les lieux où les cadavres avaient été découverts, Arthur se rendit compte qu’ils étaient tous concentrés autour d’un château à une distance d’environ 1 km. \n\tSa chasse commença quand il arriva au Château de Montmorency\n");
	}



	public void choicePlayer(){

		Scanner scan = new Scanner(System.in);
		String phrase = "?";
		String[] words;

		while (!phrase.equals("")) {
			phrase = scan.nextLine();
			words = phrase.split("\\s+");;

				switch (words[0]){
					case "g":
						myInteraction.go( searchPlace( words[1] ), searchPlaceWherePlayer() );
						break;
					case "l":
						myInteraction.look( this.placeList, searchPlaceWherePlayer() );
						break;
					case "t":
						myInteraction.take( searchItem( words[1] ), searchPlaceWherePlayer() );
						break;
					case "h":
						myInteraction.help();
						break;
					case "gardener":
						myInteraction.gardener( searchPlace( "Gardener" ), searchPlaceWherePlayer() );
						break;
					case "i":
						myInteraction.inventaire( searchPlaceWherePlayer() );
						break;
					case "u":
						if(words.length < 3){

							myInteraction.use( searchItem( words[1] ), null, searchPlaceWherePlayer() );
						}else{
							myInteraction.use( searchItem( words[1] ), searchItem( words[2] ), searchPlaceWherePlayer() );
						}
						break;
					case "a":
						searchPlaceWherePlayer().getPlayer().attackEnemy( searchEnemy( words[1] ), (Weapon) searchItem( words[2] ) );
					default: choicePlayer();

				}

		}
		scan.close();
	}


	public void launchGame(){
		synopsis();

		this.myInteraction.help();
		while(!(this.myPlayer.isDead()) || !(this.devilBoss.isDead()) ){
			/*Toutes les minutes un evenement peut surgir*/
			/*Timer timer;
			timer = new Timer(true);
			timer.scheduleAtFixedRate( new AleaTask( searchPlaceWherePlayer() ), 10000, 10000 );
*/
			choicePlayer();

		}
	}




	/******************************	Méthodes annexe	*********************************/



	/////////////////////METHODE DE RECHERCHE
	public Enemy searchEnemy(String s){
		AtomicReference<Enemy> p = new AtomicReference<Enemy>();
		searchPlaceWherePlayer().getUnitList().forEach( unit -> {
			if(unit instanceof Spectre){
				if(Objects.equals( ((Spectre) unit).getNAME(), s )){
					p.set( (Spectre)unit );
				}
			}else if(unit instanceof Devil){
				if(Objects.equals( ((Devil) unit).getNAME(), s )){
					p.set( (Devil)unit );
				}
			}
		} );

		return p.get();
	}

	public Item searchItem(String s){
		AtomicReference<Item> p = new AtomicReference<Item>();
		searchPlaceWherePlayer().getItemList().forEach( item -> {
			if(Objects.equals( item.getId().getName(), s )){
				p.set( item );
			}
		} );

		return p.get();
	}

	public Place searchPlace(String s){
		AtomicReference<Place> p = new AtomicReference<Place>();

		if(this.placeList != null){
			this.placeList.forEach( place -> {
				if(Objects.equals( s, place.getNAME() )){
					p.set( place );
				}
			} );
		}

		return p.get();
	}

	public Place searchPlaceWherePlayer(){
		AtomicReference<Place> p = new AtomicReference<Place>();
		this.placeList.forEach( place -> {
			if(place.isPlayerHere()){
				p.set( place );
			}
		} );

		return p.get();
	}


	///////////////////METHODE D'INITIALISATION

	public void initPlaceList(List<Place> listPlaces,Place...places){
		Collections.addAll( listPlaces, places );
	}
	public List<Exit> initExitList(List<Exit> listExits,Exit...exits){


		Collections.addAll( listExits, exits );
		return listExits;

	}
	public List<Unit> initUnitList(List<Unit> listUnits,Unit...units){

		Collections.addAll( listUnits, units );
		return listUnits;

	}
	public List<Item> initItemList(List<Item> listItems,Item...items){

		Collections.addAll( listItems, items );
		return listItems;

	}

	public List<Battery> createNBBat(int n){
		List<Battery> b = new ArrayList<Battery>();
		for(int i = 1; i <= n; i++){
			b.add( new Battery(identityBattery) );
		}
		return b;
	}

	/////////////////////////GETER SETER

	public List<Place> getPlaceList() {
		return placeList;
	}

	public void setPlaceList(List<Place> placeList) {
		this.placeList = placeList;
	}

	public Interaction getMyInteraction() {
		return myInteraction;
	}

	public void setMyInteraction(Interaction myInteraction) {
		this.myInteraction = myInteraction;
	}
}