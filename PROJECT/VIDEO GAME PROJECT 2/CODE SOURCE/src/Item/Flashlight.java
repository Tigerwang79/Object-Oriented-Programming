package Item;

import Item.Battery;
import Item.Item;

public class Flashlight extends Item {

    private Battery battery;
    private boolean activate;

    public Flashlight(Battery b, Identity id) {
        this.battery = b;
        super.setId( id );
    }

    public void freeBattery() {
        if (this.battery != null) {
            this.battery = null;
        }
    }

    public void changeBattery(Battery b) {
        this.freeBattery();
        this.battery = b;

    }

    public void turnOn(){
        if ((this.battery != null) && !(this.battery.isEmpty())) {
            this.activate = true;
        }
    }
    public void turnOff(){
        this.activate = false;
    }

    Battery getBattery() {
        return battery;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }
}