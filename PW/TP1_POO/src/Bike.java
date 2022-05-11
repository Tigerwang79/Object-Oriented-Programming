/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Valdrin Salihi
 */

import java.awt.Color;

public class Bike {
    private final String DEFAULT_BRAND = "marque";
    private final Color DEFAULT_COLOR = Color.RED;
    private final int DEFAULT_SIZE = 16;
    
    private final String brand;
    private Color color = DEFAULT_COLOR;
    private int speed;
    private final int size;
    private Wheel[] wheel;
    
    public Bike(){
        this.brand = DEFAULT_BRAND;
        this.color = DEFAULT_COLOR;
        this.size = DEFAULT_SIZE;
        this.speed = 0;
    }
    
    public Bike(String brnd, Color c, int s){
        this.brand = brnd;
        this.color = c;
        this.size = s;
        this.speed = 50;
        //this.wheel[0] = new Wheel();
        //this.wheel[1] = new Wheel();
    }
    
    public Bike(Bike bk){
        this.brand = bk.brand;
        this.color = bk.color;
        this.size = bk.size;
        this.speed = bk.speed;
    }
    
    public void print(){
        System.out.println("[" + this.brand + " - " + this.size + "''" + " - " + this.color + " - " + "(" + this.speed + "km/h)]");
    }
    
    public void accelerate(){
        if(this.speed < 60){
            this.speed += 10;
        }
    }
    
    public void brake(){
        if(this.speed > 0){
            this.speed -= 5;
        }
    }
    
    public void repaint(){
        this.color= DEFAULT_COLOR;
    }
    
    public static void main(String[] args){
        Bike b1 = new Bike("Electra", Color.BLUE, 10);
        Bike b2 = new Bike("Electra", Color.GREEN, 20);
        
        b1.print();
        b2.print();
        
        b1.accelerate();
        b2.accelerate();
        
        b1.print();
        b2.print();
        
        b1.brake();
        b2.brake();
        
        b1.print();
        b2.print();
        
        b1.repaint();
        b2.repaint();
        
        b1.print();
        b2.print();
    }
}
