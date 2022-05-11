package Place.Exit;

import Item.Identity;
import Item.MagicTablet;

public class MagicDoor extends Exit {
    private final MagicTablet myTablet;


    public MagicDoor(MagicTablet t) {
        super();
        this.myTablet = t;
    }


    public void open(MagicTablet t) {
        if(this.myTablet == t) {
            super.open();
        }
    }

    public MagicTablet getMyTablet() {
        return myTablet;
    }
}