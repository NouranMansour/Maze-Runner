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
public class Memento {
    private Player player;
    public Memento(Player playerSave){
        
        player=playerSave;
       
    }
    public Player getSavedPlayer(){
        
        return player;
    
    }
}
