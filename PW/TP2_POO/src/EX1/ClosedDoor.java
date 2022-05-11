/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

/**
 *
 * @author Valdrin Salihi
 */
public class ClosedDoor extends Door{
    
    public ClosedDoor(){
        super();
    }
    
    @Override
    public void open(){
        this.isOpen = false;
    }
    
    @Override
    public void close(){
        this.isOpen = false;
    }
}
