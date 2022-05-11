/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Valdrin Salihi
 */
public class DoorIT {
    
    private Door door1;
    
    @Before
    public void setUp(){
        door1 = new Door();
    }
    
    @Test
    public void testDoor(){
        door1.close();
        assertFalse(door1.isOpen);
    }
    
    @Test
    public void testOpen(){
        door1.open();
        assertTrue(door1.isOpen);
    }
    
    @Test
    public void testClose(){
        door1.close();
        assertFalse(door1.isOpen);
    }
}
