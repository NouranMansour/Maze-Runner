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
public class PlayerDecorater extends Player2 {
    protected Player2 player2;

    public PlayerDecorater(Player2 player2) {
        this.player2 = player2;
    }
      public PlayerDecorater() {
     
    }

   

    @Override
    public String getDescription() {
        return "Timmy";
    }
    
    
    
    
}
