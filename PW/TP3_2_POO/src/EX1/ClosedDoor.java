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
    
    private boolean locked;
    
    public ClosedDoor(){
        super();
    }
    
    public void lock(){
        this.locked = true;
    }
    
    public boolean getLocked(){
        return locked;
    }
    
    @Override
    public void open(){
        this.isOpen = false;
    }
    
    @Override
    public void close(){
        super.close();
        lock();
    }
}
