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
public class SecretCodeDoorIT {
    
    
    private SecretCodeDoor secretCodeDoor1;

    
    
    @Test
    public void testSecretCodeDoor(){
        int x = 666;
        secretCodeDoor1 = new SecretCodeDoor(x);
        assertEquals(secretCodeDoor1.getCode() , x);
    }       
    
}
