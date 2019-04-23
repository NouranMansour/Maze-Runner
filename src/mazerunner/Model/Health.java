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
public class Health implements Observer{

    @Override
    public void Update(Player p,int x,int y) {
        
        p.health=p.health+x;
        
        if(p.health<0)
            p.health=0;
        
    }
  
}
