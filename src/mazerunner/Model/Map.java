/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner.Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Lenovo
 */
public class Map {

    private Scanner sc;
    public String Map[] = new String[20];
    private Image grass, tree, door, bounty,bounty2, bombH, sword1,sword2,bombS,GiftS,GiftH,Wall,CheckPoint;
     private static Map mp;
     
     private Map(String s){
     
     }
     
     public static Map getmp(){
     if(mp==null)
         mp=new Map();
     return mp;
     
     }

    public Map() {

        // ImageIcon img =new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\MazeRunner\\src\\grass.gif");
        ImageIcon img = new ImageIcon(this.getClass().getResource("/pics/grass.gif"));
        grass = img.getImage();

        //img =new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\MazeRunner\\src\\tree.gif");
        img = new ImageIcon(this.getClass().getResource("/pics/tree.jpg"));
        tree = img.getImage();
        
        img = new ImageIcon(this.getClass().getResource("/pics/coin.gif"));
        GiftS = img.getImage();
        

        //img =new ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\MazeRunner\\src\\door.gif");
        img = new ImageIcon(this.getClass().getResource("/pics/door.gif"));
        door = img.getImage();

        img = new ImageIcon(this.getClass().getResource("/pics/Gift.gif"));
        bounty = img.getImage();
        
        img = new ImageIcon(this.getClass().getResource("/pics/Gift2.gif"));
        bounty2 = img.getImage();

        img = new ImageIcon(this.getClass().getResource("/pics/bomb3.gif"));
        bombH = img.getImage();
        
        img = new ImageIcon(this.getClass().getResource("/pics/ScoreBomb.gif"));
        bombS = img.getImage();

        img = new ImageIcon(this.getClass().getResource("/pics/sword1.gif"));
        sword1 = img.getImage();
        img = new ImageIcon(this.getClass().getResource("/pics/sword2.gif"));
        sword2 = img.getImage();
        
         img = new ImageIcon(this.getClass().getResource("/pics/Heart.gif"));
        GiftH = img.getImage();
        
        img = new ImageIcon(this.getClass().getResource("/pics/stone.jpg"));
        Wall = img.getImage();
        
        img = new ImageIcon(this.getClass().getResource("/pics/checkpoint.gif"));
        CheckPoint = img.getImage();

        loadFile();
        readfromFile();
        exitFile();
    }

    public Image getCheckPoint() {
        return CheckPoint;
    }
    
public Image swapTree(){
   return tree = grass ;
    
}

    public Image getWall() {
        return Wall;
    }


    public Image getGiftH() {
        return GiftH;
    }

    public Image getGrass() {
        return grass;
    }

    public Image getDoor() {
        return door;
    }

    public Image getBombS() {
        return bombS;
    }

    public Image getTree() {
        return tree;
    }

    public Image getBounty() {
        return bounty;
    }
    public Image getBounty2() {
        return bounty2;
    }

    public Image getGiftS() {
        return GiftS;
    }

    public void clearBounty() {
        bounty = grass;
    }
    public void clearBounty2() {
        bounty2 = grass;
    }

    public Image getBombH() {
        return bombH;
    }

    public void clearBombH() {
        bombH = grass;
    }

    public Image getSword1() {
        return sword1;
    }

    public void clearSword1() {
        sword1 = grass;
    }
    public Image getSword2() {
        return sword2;
    }

    public void clearSword2() {
        sword2 = grass;
    }

    
    
    
    
    
    
    public String getMap(int x, int y) {
        String position = Map[y].substring(x, x + 1);
        return position;
    }
    

    public void loadFile() {

        try {
            InputStream f = Map.class.getResourceAsStream("MazeMap.txt");
            // File file=new File("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\MazeRunner\\src\\mazerunner\\MazeMap.txt");

            sc = new Scanner(f);

        } catch (Exception ex) {
            System.out.println("error loading map");
        }

    }

    public void readfromFile() {
        while (sc.hasNext()) {

            for (int i = 0; i < 20; i++) {
                Map[i] = sc.next();

            }

        }

    }

    public void exitFile() {
        sc.close();
    }

}
