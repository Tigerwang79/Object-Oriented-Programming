/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX2;

import java.awt.Color;

/**
 *
 * @author Valdrin Salihi
 */
public class Cartridge {
    private final Color DEFAULT_COLOR = Color.BLUE;
    private final String DEFAULT_BRAND = "marque";
    private final int  DEFAULT_LEVEL = 3;
    
    private Color color;
    private String brand;
    private int level;
    private boolean full;
    
    public Cartridge(){
        this.color = DEFAULT_COLOR;
        this.brand = DEFAULT_BRAND;
        this.level = DEFAULT_LEVEL;
        this.full = true;
    }
    
}
