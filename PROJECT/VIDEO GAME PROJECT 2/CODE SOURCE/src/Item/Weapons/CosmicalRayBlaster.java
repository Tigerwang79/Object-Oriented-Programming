package Item.Weapons;

import Item.Identity;
import t_enum.Rarity;

public class CosmicalRayBlaster extends Weapon {

    public CosmicalRayBlaster(int d, Rarity r, Identity id, boolean b){
        super.setDamage( d );
        super.setMyRarity( r );
        super.setId( id );


    }

}