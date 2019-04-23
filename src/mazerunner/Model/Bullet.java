/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner.Model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Lenovo
 */
public class Bullet {
    private int tileHoriz,tileVerti;
    private Image bullet;
    private Player player=new Player();

    public Image getBullet() {
        return bullet;
    }
  
    
     public Bullet() {
    
        ImageIcon img= new ImageIcon(this.getClass().getResource("/pics/Bullet.jpg"));
        bullet=img.getImage();
        
        tileHoriz=player.getTileHoriz();
        tileVerti=player.getTileVerti();
        
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
     
    public int getTileHoriz() {
        return tileHoriz;
    }

    public int getTileVerti() {
        return tileVerti;
    }
    
    
    
    public void move(int dx,int dy){
      
        
        tileHoriz +=dx;
        tileVerti +=dy;
        
    
    }

    public void setTileHoriz(int tileHoriz) {
        this.tileHoriz = tileHoriz;
    }

    public void setTileVerti(int tileVerti) {
        this.tileVerti = tileVerti;
    }
    
}
