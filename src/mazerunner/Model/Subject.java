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
public interface Subject {
    void AddObserver(Observer o);
    void RemoveObserver(Observer o);
    void NotifyObsevers(Player p,int x,int y);
    
}
