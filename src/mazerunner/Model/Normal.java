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
public class Normal implements PlayerState {
    
     Player playerstate;

    public Normal(Player playerstate) {
        this.playerstate = playerstate;
    }

    
    

    @Override
    public void damage() {
        
    }
    
}
