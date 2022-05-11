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
public class ClosedDoorIT {
    
    private ClosedDoor closedDoor1;
    
    @Before
    public void setUp(){
        closedDoor1 = new ClosedDoor();
    }
    
    @Test
    public void testOpen(){
        closedDoor1.open();
        assertFalse(closedDoor1.getOpen());
    }
    
    @Test
    public void testClose(){
    closedDoor1.close();
    assertTrue(closedDoor1.getLocked());
    }
}
