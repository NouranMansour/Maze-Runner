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
public class Armoured implements PlayerState {
    
   Player player;

    public Armoured(Player player) {
        this.player = player;
    }
           
    

    @Override
    public void damage() {
        player.unchangePlayer();
    }
    
}
