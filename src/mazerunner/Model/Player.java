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
public class Player {
   
    public PlayerState armoured;
    public PlayerState normal;
    public PlayerState PlayerState;
   
    
    private int tileHoriz,tileVerti;
    private Image player,playerArmor,playerTimmy,player1;
    public int health=100;
    public int score=0;
    public  boolean isarmoured=false;
    public int changed,changedT ;
    
    public Player() {
        
        armoured = new Armoured(this);
        normal= new Normal(this);
        PlayerState=normal;
        
        ImageIcon img= new ImageIcon(this.getClass().getResource("/pics/player.gif"));
        player=img.getImage();
        
        
       
        tileHoriz=1;
        tileVerti=1;
        
        img= new ImageIcon(this.getClass().getResource("/pics/armor.gif"));
        playerArmor=img.getImage();
        
        img= new ImageIcon(this.getClass().getResource("/pics/timmy.gif"));
        playerTimmy =img.getImage();
        
        img= new ImageIcon(this.getClass().getResource("/pics/player.gif"));
        player1=img.getImage();
        
        
        
    }
    
    
    public void setPlayerState(PlayerState newPlayerState )
    {
        PlayerState= newPlayerState;
    }

    
    public PlayerState getArmoured() {
        return armoured;
    }

    public PlayerState getNormal() {
        return normal;
    }

   
    
    
    public void damageHealth(){
        
        PlayerState.damage( );
    
    }
    
    public Image getplayerArmor(){
        return playerArmor;
    }
    public Image changePlayer(){
        changed = 1;
        return player = playerArmor ;
        
    }
     public Image unchangePlayer(){
       return player = player1 ;
        
    }
    public Image changeTimmy(){
        changedT = 1;
        return player = playerTimmy ;
    }
    

    public Image getPlayer() {
        return player;
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
