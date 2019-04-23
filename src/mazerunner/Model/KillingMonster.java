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
public class KillingMonster extends Monster{
    
   public Player player=new Player();

    public void setPlayer(Player player) {
        this.player = player;
    }
            

    public KillingMonster() {
        
        
          ImageIcon img= new ImageIcon(this.getClass().getResource("/pics/dead_pacman_monster.gif"));
        monster=img.getImage();
        
         tileHoriz=4;
        tileVerti=8;
        
   
    }

    public int getTileHoriz() {
        return tileHoriz;
    }

    public int getTileVerti() {
        return tileVerti;
    }

    public void setTileHoriz(int tileHoriz) {
        this.tileHoriz = tileHoriz;
    }

    public void setTileVerti(int tileVerti) {
        this.tileVerti = tileVerti;
    }
    
    
     public void move(){
         
         java.util.Random y = new java.util.Random();
         int x= 1 + y.nextInt(4);
      
         
         if(x==1){
        tileHoriz +=1;
         if(tileHoriz>18)
             tileHoriz=18;
             
         }
         
         
         if(x==2){
        tileHoriz -=1;
         
         if(tileHoriz<1)
             tileHoriz=1;
         
         }
         
         if(x==3){
         tileVerti +=1;
         if(tileVerti>18)
             tileVerti=18;
         
         }
         
          if(x==4){
         tileVerti -=1;
        if(tileVerti<1)
             tileVerti=1;
          }
          
      if(player.getTileHoriz()==tileHoriz && player.getTileVerti()==tileVerti)
          player.health=0;

    
    }

    public Image getMonster() {
        return monster;
    }
     
}
