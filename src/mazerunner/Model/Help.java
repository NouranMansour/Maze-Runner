/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner.Model;

import java.util.logging.Level;
import java.util.logging.Logger;
import static mazerunner.Model.MainClass.flag;
import mazerunner.View.Maze;

/**
 *
 * @author Lenovo
 */
public class Help implements Runnable {

    @Override
    public void run() {
if(flag){
    MainClass.s.setVisible(false);
    try{
    
    Maze m=new Maze();
    }
catch(InterruptedException ex){

    Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE,null,ex);
}



}
    }
    
}
