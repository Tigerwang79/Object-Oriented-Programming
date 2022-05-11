package associations;

import java.awt.Color;
public class CarCompo {

    private final Color color ; 
    private Engine engine ;
    
    public CarCompo(int pow){
        this.color = Color.BLACK ;
        this.engine = new Engine(pow) ;
    }
    
    public void changeEngine(int pow){
        this.engine = new Engine(pow);
    }
    
}
