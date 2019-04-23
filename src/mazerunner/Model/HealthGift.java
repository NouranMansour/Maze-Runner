/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner.Model;

import mazerunner.Controller.Board;

/**
 *
 * @author Lenovo
 */
public class HealthGift extends Gift {
     Board b=new Board();
    
    
    public int  giftFunction(Player p){
        
        b.newChange(p, 10, 0);
        return 0;
    
 // p.score=p.score+15;
    }
    
    
    
}
