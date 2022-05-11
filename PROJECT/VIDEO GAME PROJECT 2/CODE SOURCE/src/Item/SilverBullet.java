package Item;

public class SilverBullet extends Item {
    private final int MAX_NB_BULLET = 6;
    private int nbAmmo;


    public SilverBullet(int nbAmmo, Identity id) {

        if(nbAmmo > MAX_NB_BULLET){
            this.nbAmmo = MAX_NB_BULLET;
        }else{
            this.nbAmmo = nbAmmo;
        }
        super.setId( id );
    }

    public int getMAX_NB_BULLET() {
        return MAX_NB_BULLET;
    }

    public int getNbAmmo() {
        return nbAmmo;
    }

    public void setNbAmmo(int nbAmmo) {
        this.nbAmmo = nbAmmo;
    }
}