package associations;

import java.awt.Color;

public class CarAgreg {

    private final Color color ; 
    private Engine engine ;
    
    public CarAgreg(Engine en){
        this.color = Color.BLACK ;
        this.engine = en ;
    }
    
    public void changeEngine(Engine en){
        this.engine = en ;
    }
    
    public Engine getEngine(){
        return this.engine;
}

}
