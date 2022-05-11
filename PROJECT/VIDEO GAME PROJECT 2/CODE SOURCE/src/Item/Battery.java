package Item;

public class Battery extends Item {

    public final static int DEFAULT_LEVEL = 4;
    private int level;
    private Flashlight flashlight = null;
    private Lighter lighter = null;


    public Battery(Identity id) {
        super.setId( id );
        this.level = DEFAULT_LEVEL;
    }

    public boolean isEmpty() {
        return this.level == 0;
    }

    Flashlight getFlashlight() {
        return this.flashlight;
    }

    Lighter getLighter() {
        return this.lighter;
    }

    public int getLevel() {
        return this.level;
    }

    public void use() {
        if (!this.isEmpty()) {
            this.level--;
        }
    }

    /*public void freeFlashlight() {
        Flashlight oldFlashlight = this.flashlight;
        this.flashlight = null;
        if (oldFlashlight != null) {
            oldFlashlight.freeBattery();
        }
    }

    public void setFlashlight(Flashlight f) {
        if (f == null) {
            this.freeFlashlight();
        }
        else {
            if (f.getBattery() == this) {
                this.flashlight = f;
            }
            else {
                f.changeBattery(this);
            }
        }
    }*/
}