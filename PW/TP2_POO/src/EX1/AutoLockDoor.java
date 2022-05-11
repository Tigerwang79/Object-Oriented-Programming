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
public class AutoLockDoor extends Door{
    private boolean locked;
    
    public AutoLockDoor(){
        super();
    }    
    
    public void lock(){
        this.locked = true;
    }
    
    public void unLock(){
        this.locked = false;
    }
    
    @Override
    public void open(){
        if(locked){
            unLock();
            this.isOpen = true;
        }
    }
    
    @Override
    public void close(){
        this.isOpen = false;
        lock();
    }
}
