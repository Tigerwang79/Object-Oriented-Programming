package Game;

import Place.Place;
import Unity.Enemy.Spectre;
import Unity.NPC.Gardener;
import Unity.Player;

public class Main {
    public static void main(String...args){
        Interaction myInteraction = new Interaction();
        Game myGame = new Game(myInteraction);
        myGame.launchGame();


    }

}
