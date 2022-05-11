package Item.Weapons;

import Item.Identity;
import Item.SilverBullet;
import t_enum.Rarity;

public class ColtSAA45 extends Weapon {

    private SilverBullet gunMagazine;

    public ColtSAA45(int d, Rarity r, Identity id, int nbAmmo, Identity idAmmo, boolean b){
        this.gunMagazine = new SilverBullet( nbAmmo, idAmmo );
        super.setDamage( d );
        super.setMyRarity( r );
        super.setId( id );

    }

    public ColtSAA45(int d, Rarity unusual, Identity identityColt, Object o, boolean b) {
        super();
    }

    public SilverBullet getGunMagazine() {
        return gunMagazine;
    }

    public void setGunMagazine(SilverBullet gunMagazine) {
        this.gunMagazine = gunMagazine;
    }

    public void reload(SilverBullet gunMagazine) {

        if(this.gunMagazine.getNbAmmo() == 0){
            setGunMagazine( gunMagazine );
        }else{
            this.gunMagazine.setNbAmmo( this.gunMagazine.getMAX_NB_BULLET() );
        }
    }
}