package Game;

import Place.Place;
import Unity.Enemy.Spectre;
import Unity.Player;

import java.util.TimerTask;

public class AleaTask extends TimerTask {

    private final Place place;
    private final int DAM_MH = 10;

    public  AleaTask(Place p){
        this.place = p;
    }


    //Evenemnt qui devait s'effectuer toute les minutes dans le jeu
    @Override
    public void run() {
        if(place.isPlayerHere() && place.getLvlObscurity() <= 0){
            System.out.println("L'obscurité de la pièce vous inflige des dégât de santé mental ! " +"-" +this.DAM_MH);
            place.getPlayer().painMH( DAM_MH );
        }
        place.getUnitList().forEach( unit -> {
            if(unit instanceof Spectre){
                ((Spectre) unit).aleaTalk(place.getPlayer(), DAM_MH);
                ((Spectre) unit).aleaAttak(place.getPlayer());
            }
        } );
        try {
            Thread.sleep( 5000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
