package Item;

import Unity.Player;

import java.util.Random;

public class Sedative extends Item{

    private final int MAX_HEALING = 60;
    private final int MIN_HEALING = 10;

    private int healing;


    public Sedative(Identity id){
        super.setId( id );
        init();
    }

    public void init(){
        Random r = new Random();
        setHealing( r.nextInt((MAX_HEALING-MIN_HEALING) + 1) + MIN_HEALING  );
    }


    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }
}
