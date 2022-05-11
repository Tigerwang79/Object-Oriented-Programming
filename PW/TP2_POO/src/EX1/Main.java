/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

import java.util.ArrayList;

/**
 *
 * @author Valdrin Salihi
 */
public class Main {
    
    private ArrayList <Door> doors;
    
    public void room(){
        this.doors = new ArrayList<>();
        doors.add(new Door());
        doors.add(new SecretCodeDoor());
        doors.add(new AutoLockDoor());
        doors.add(new ClosedDoor());
    }
    
    public static void main(String[] args){
        Door d1 = new Door();
        AutoLockDoor d2 = new AutoLockDoor();
        SecretCodeDoor d3 = new SecretCodeDoor();
        ClosedDoor d4 = new ClosedDoor();
        
        d1.open();
        d1.toString();
        d1.close();
        d1.toString();
        
        d2.lock();
        d2.open();
        d2.toString();
        d2.unLock();
        d2.toString();
        
        d3.close();
        d3.unlock();
        d3.toString();
        
        d4.open();
        d4.toString();
        d4.close();
        d4.toString();
    }
}
