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
public class Wall {
    protected boolean type;
     private Image Wall;
     protected boolean breakable;

    public Wall(boolean type, Image Wall, boolean breakable) {
        this.type = type;
        this.Wall = Wall;
        this.breakable = breakable;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public Image getWall() {
        return Wall;
    }

    public void setWall(Image Wall) {
        this.Wall = Wall;
    }

    public boolean isBreakable() {
        return breakable;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }
     
     
    
}
