/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Valdrin Salihi
 */
public class Wheel {
    private final String DEFAULT_BRAND = "marque";
    private final int DEFAULT_SIZE = 24;
    private final float DEFAULT_PRESSURE = 3f;
    
    private final String brand;
    private final int size;
    private float pressure;
    
    public Wheel(){
        this.brand = DEFAULT_BRAND;
        this.size = DEFAULT_SIZE;
        this.pressure = DEFAULT_PRESSURE;
    }
    
    public Wheel(String brnd, int s, float p){
        this.brand = brnd;
        this.size = 24;
        this.pressure = 3f;
    }
    
    public Wheel(Wheel wh){
        this.brand = wh.brand;
        this.size = wh.size;
        this.pressure = wh.pressure;
    }
    
    public void print(){
        System.out.println("[" + this.brand + " - " + this.size + "''" + " - " + this.pressure + " bar]");
    }
    
    public void inflate(){
        if(this.pressure < 15f){
            this.pressure += 0.1f;
        }
    }
    
    public void deflate(){
        if(this.pressure > 0f){
            this.pressure -= 0.1f;
        }
    }
    
    public static void main(String[] args){
        Wheel w1 = new Wheel("Schalbe", 24, 3f);
        Wheel w2 = new Wheel("Schalbe", 24, 3f);
        
        w1.print();
        w2.print();
        
        w1.inflate();
        w2.inflate();
        
        w1.print();
        w2.print();
        
        w1.deflate();
        w2.deflate();
        
        w1.print();
        w2.print();
    }
}
