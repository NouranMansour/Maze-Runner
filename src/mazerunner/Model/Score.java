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
public class Score  implements Observer{

    @Override
    public void Update(Player p, int x,int y) {
        
        p.score=p.score+y;
    }
  
}
