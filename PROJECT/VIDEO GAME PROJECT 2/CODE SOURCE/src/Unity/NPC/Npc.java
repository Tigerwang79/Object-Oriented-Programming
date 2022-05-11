package Unity.NPC;

import Unity.Unit;
import Unity.Player;
import t_enum.Rarity;
import Item.Weapons.Weapon;
import java.util.Random;

public abstract class Npc extends Unit {

    private Rarity myRarity;
    private Weapon weapon;
    private final int MIN_DAMMAGE = 25;
    private final int MAX_DAMMAGE = 60;
    private final int MAX_ALEAATTAK = 4;
    private final int MIN_ALEAATTAK = 1;

    private int cc_attack;

    @Override
    public void attackPlayer(Player p) {
        Random r = new Random();
        int n = r.nextInt((4-1) +1 ) + 1;
        int d = r.nextInt((MAX_DAMMAGE - MIN_DAMMAGE) +1 ) + MIN_DAMMAGE;
        if(n == 1){
            if(p.getHealth()-this.cc_attack <= 0){
                p.setDead( true );
                System.out.println("L'ennemi vous a tué !");
            }else{
                p.setHealth( p.getHealth()-this.cc_attack );
                System.out.println("Dégâts reçu: " + this.cc_attack+"\nVie restante: " + p.getHealth());
            }
        }else {
            if(p.getHealth()- d <= 0){
                p.setDead( true );
                System.out.println("Vous êtes mort, l'ennemi vous a tué !");
            }else{
                p.setHealth( p.getHealth()-d );
                System.out.println("Dégâts reçu: " + d+"\nVie restante: " + p.getHealth());
            }
        }
    }

    public int myCC(Rarity r){
        if(this.getMyRarity() == Rarity.common){
            this.setCc_attack( 65 );
        }else if(this.getMyRarity() == Rarity.unusual){
            this.setCc_attack( 75 );
        }else if(this.getMyRarity() == Rarity.epic){
            this.setCc_attack( 85 );
        }else{
            this.setCc_attack( 100 );
        }
        return this.cc_attack;
    }

    public abstract void dead(Player p);

    public Rarity getMyRarity() {
        return myRarity;
    }

    public void setMyRarity(Rarity myRarity) {
        this.myRarity = myRarity;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getMIN_DAMMAGE() {
        return MIN_DAMMAGE;
    }

    public int getMAX_DAMMAGE() {
        return MAX_DAMMAGE;
    }

    public int getCc_attack() {
        return cc_attack;
    }

    public void setCc_attack(int cc_attack) {
        this.cc_attack = cc_attack;
    }

    @Override
    public void aleaAttak(Player p) {
        Random r = new Random();
        int alea = r.nextInt((this.MAX_ALEAATTAK - this.MIN_ALEAATTAK) + 1) + this.MIN_ALEAATTAK;
        if(alea == 1){
            attackPlayer( p );
        }
    }

}
