package Item;

import java.util.Random;

public class Food extends Item{
    private final int MAX_HEALTH = 75;
    private final int MIN_HEALTH = 25;
    private int health;



    public Food(Identity id){
        super.setId( id );
        init();
    }

    public void init(){
        Random r = new Random();
        setHealth( r.nextInt((MAX_HEALTH-MIN_HEALTH) + 1) + MIN_HEALTH );

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
