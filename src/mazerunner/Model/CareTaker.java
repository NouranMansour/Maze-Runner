/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner.Model;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class CareTaker {
    public ArrayList<Memento> savedPlayers= new ArrayList<Memento>();
    
    public void addMemento(Memento m){
    
    savedPlayers.add(m);
    }
    
    public Memento getMemento(int index){
    
    return savedPlayers.get(index);
    
    }
}