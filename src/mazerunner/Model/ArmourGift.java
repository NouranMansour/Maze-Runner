/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner.Model;

/**
 *
 * @author Lenovo
 */
public class ArmourGift extends Gift {
    
    public  int giftFunction(Player p){
    
    p.changePlayer();
    
     p.isarmoured=true;
                   
      p.setPlayerState(p.armoured);
     
      return 0;
    
    }
    
}
