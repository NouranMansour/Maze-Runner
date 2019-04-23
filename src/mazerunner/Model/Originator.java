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
public class Originator {
    private Player player;
    
    public void set(Player newPlayer){
        player=newPlayer;
    
    }
    
    public Memento storeInMemento(){
        return new Memento(player);
    
    
    
    }
    
    public Player restoreFromMemento(Memento memento){
        
        player=memento.getSavedPlayer();
        return player;
    
    }
    
}