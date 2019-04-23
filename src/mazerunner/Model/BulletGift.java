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
public class BulletGift extends Gift {
     Board b=new Board();
     int count;

    public void setCount(int count) {
        this.count = count;
    }
    
    
    public int giftFunction(Player p){
         
        Board.count=Board.count+3;
        return 0;
       // b.increaseCount(3);
        
      //  b.count=b.count+3;
    
 // p.score=p.score+15;
    }

    public void setB(Board b) {
        this.b = b;
    }
    
}
