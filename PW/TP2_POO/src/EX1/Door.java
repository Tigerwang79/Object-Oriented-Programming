/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

import java.util.List;

/**
 *
 * @author Valdrin Salihi
 */
public class Door {
    protected boolean isOpen;
    
    public Door(){
        this.isOpen = false;
    }
    
    public void open(){
        this.isOpen = true;
    }
    
    public void close(){
        this.isOpen = false;
    }
    
    @Override
    public String toString(){
        return "Je suis " + getClass().getSimpleName() + this.isOpen + ".";
    }
    
    public static void printDoorList(List<Door> l){
       l.forEach(D->{
            D.toString();
       });
    }
}
