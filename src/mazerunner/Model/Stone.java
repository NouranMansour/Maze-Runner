/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner.Model;

import java.awt.Image;

/**
 *
 * @author Lenovo
 */
public class Stone extends Wall {

    public Stone(boolean type, Image Wall, boolean breakable) {
        super(type, Wall, breakable);
    }

    public void setType(boolean type) {
        this.type = false;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = false;
    }

    
    
}
