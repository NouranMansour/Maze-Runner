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
public class ScoreBomb extends Bomb {
      Board b=new Board();
     public void damage(Player p){
         
          if(p.isarmoured==false){
          
      // p.score=p.score-20;
       b.newChange(p, 0, -20);
       
      
      }
   
      else 
          p.isarmoured=false;
   }
         
    }
     
    
    

