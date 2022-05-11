/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Valdrin Salihi
 */
public class AutoLockDoorIT {
    
    private AutoLockDoor autoLockDoor1;
    
    @Before
    public void setUp(){
        autoLockDoor1 = new AutoLockDoor();
    }
    
    @Test
    public void testLock(){
        autoLockDoor1.lock();
        assertTrue(autoLockDoor1.getLocked());
    }
    
    @Test
    public void testUnLock(){
        autoLockDoor1.unLock();
        assertFalse(autoLockDoor1.getLocked());
    }
    
    @Test
    public void testOpen(){
        autoLockDoor1.close();
        autoLockDoor1.open();
        assertTrue(autoLockDoor1.getOpen());
    }
    
    @Test
    public void testClose(){
        autoLockDoor1.close();
        assertTrue(autoLockDoor1.getLocked());
    }
}
