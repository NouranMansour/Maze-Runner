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
public class ScoreGift extends Gift {
    
    Board b=new Board();
    
    
    public int  giftFunction(Player p){
       // p.score=p.score+15; 
        b.newChange(p, 0, 15);
        return 0;
    
 
    }
    
}
