/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner.Controller;

import mazerunner.View.Maze;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;
import mazerunner.Model.ArmourGift;
import mazerunner.Model.Armoured;
import mazerunner.Model.Bomb;
import mazerunner.Model.Bullet;
import mazerunner.Model.BulletGift;
import mazerunner.Model.Bulletmonster;
import mazerunner.Model.CareTaker;
import mazerunner.Model.Gift;
import mazerunner.Model.Health;
import mazerunner.Model.HealthBomb;
import mazerunner.Model.HealthGift;
import mazerunner.Model.KillingMonster;
import mazerunner.Model.Map;
import mazerunner.Model.Observer;
import mazerunner.Model.Originator;
import mazerunner.Model.Player;
import mazerunner.Model.Player2;
import mazerunner.Model.PlayerState;
import mazerunner.Model.Score;
import mazerunner.Model.ScoreBomb;
import mazerunner.Model.ScoreGift;
import mazerunner.Model.Subject;
import mazerunner.Model.Timmy;
import static mazerunner.View.Maze.timeF;
import static mazerunner.View.Maze.timervalue;

/**
 *
 * @author Lenovo
 */
public class Board extends JPanel implements ActionListener, Subject {
    
    private Timer timer;
    private Maze maze;
    private Map m;
    private Player p;
    private Bomb bomb;
    private Gift gift;
    private KillingMonster monster ;
    private Bulletmonster monster2;
    public Armoured a = new Armoured(p);
    public Score score = new Score();
    public Health health = new Health();
    public Image shoot, shot;
    public static int count = 6;
    public Bullet bullet = new Bullet();
    public boolean bulletflag = false;
    public boolean wallflag = false;
    public Player2 player2 = new Timmy();
    public String Description = null;
    long starttime;
    long currenttime;
    Calendar cal;
    CareTaker caretaker= new CareTaker();
    Originator originator=new Originator();
    int savedScore=0;
    boolean checkpoint=false;
    Player memento = new Player();
    boolean repeat=false;
    int retry=0;
    boolean pause=false;
    public int paintcounter=0;
    // public BulletGift bulletgift=new Bullet();

    // public Normal normal=new Normal(p);
    public PlayerState state;
    
    private ArrayList<Observer> observers;
    
    private String Message = " ";
    private boolean win = false;
    private Font font = new Font("Serif", Font.BOLD, 48);
    public Graphics g2;
   
    
    public Board() {
        m = Map.getmp();
        p = new Player();
        monster=new KillingMonster();
        monster.setPlayer(p);
        monster2=new Bulletmonster();
        monster2.setPlayer(p);
       
        Maze.healthvalue.setText(String.valueOf(p.health));
        Maze.scorevalue.setText(String.valueOf(p.score));
        Maze.bullet.setText(String.valueOf(count));
        observers = new ArrayList<>();
        AddObserver(score);
        AddObserver(health);
        addKeyListener(new keyboard());
        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
       
       
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("d")) {
            Message = "WINNER";
            
            if (p.health <= 0) {
                
                
                Message = "GAME OVER";
                timervalue.setText("0");
            }
            
            win = true;
        }
        if (p.health <= 0) {
            maze.Tindex=180;
            if(checkpoint==true&& retry<2){
                
                   // checkpoint=false;
                   retry++;
                    repeat=true;
                   // memento=originator.restoreFromMemento(caretaker.getMemento(savedScore-1));
                   p.setTileHoriz(originator.restoreFromMemento(caretaker.getMemento(savedScore-1)).getTileHoriz());
                    p.setTileVerti(originator.restoreFromMemento(caretaker.getMemento(savedScore-1)).getTileVerti());
                    p.score=originator.restoreFromMemento(caretaker.getMemento(savedScore-1)).score;
                   
                    JOptionPane.showMessageDialog(null, "another chance");
                   //maze.resetTime();
                    
                    
                   //  System.out.println(originator.restoreFromMemento(caretaker.getMemento(savedScore-1)).getTileHoriz()+"\n");
                  //  System.out.println(originator.restoreFromMemento(caretaker.getMemento(savedScore-1)).getTileVerti()+"\n");
                  //  System.out.println(p.getTileHoriz()+"\n");
                  //  System.out.println(p.getTileVerti()+"\n");
                    
                    p.health=100;
                     Maze.healthvalue.setText(String.valueOf(p.health));
                      Maze.scorevalue.setText(String.valueOf(p.score));
                    
                
                }
            else{
            Message = "GAME OVER";
            timervalue.setText("0");
            win = true;}
        }
        if(timeF==1){
            Message = "Time Out!";
            win = true ;
        }
        
        
        repaint();
        
    }
    
    public void paint(Graphics g) {
        
        super.paint(g);
        
        paintcounter++;
        if (!win) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    
                    if (m.getMap(j, i).equals("g")) {
                        g.drawImage(m.getGrass(), j * 32, i * 32, null);
                        
                    }
                    if (m.getMap(j, i).equals("t")) {
                        g.drawImage(m.getTree(), j * 32, i * 32, null);
                        
                    }
                    if (m.getMap(j, i).equals("d")) {
                        g.drawImage(m.getDoor(), j * 32, i * 32, null);
                        
                    }
                    if (m.getMap(j, i).equals("c")) {
                        g.drawImage(m.getBounty(), j * 32, i * 32, null);
                        
                    }
                    if (m.getMap(j, i).equals("A")) {
                        g.drawImage(m.getBounty2(), j * 32, i * 32, null);
                        
                    }
                    
                    if (m.getMap(j, i).equals("k")) {
                        g.drawImage(m.getBombS(), j * 32, i * 32, null);
                        
                    }
                    if (m.getMap(j, i).equals("b")) {
                        g.drawImage(m.getBombH(), j * 32, i * 32, null);
                        
                    }
                    
                    if (m.getMap(j, i).equals("s")) {
                        g.drawImage(m.getSword2(), j * 32, i * 32, null);
                        
                    }
                    if (m.getMap(j, i).equals("n")) {
                        g.drawImage(m.getGiftS(), j * 32, i * 32, null);
                        
                    }
                    if (m.getMap(j, i).equals("h")) {
                        g.drawImage(m.getGiftH(), j * 32, i * 32, null);
                        
                    }
                    if (m.getMap(j, i).equals("w")) {
                        g.drawImage(m.getWall(), j * 32, i * 32, null);
                        
                    }
                    
                     if (m.getMap(j, i).equals("z")) {
                        g.drawImage(m.getCheckPoint(), j * 32, i * 32, null);
                        
                    }
                    
                }
                
            }
            
          //  if(repeat==true){
            
            //    repeat=false;
             //    p.setTileHoriz(originator.restoreFromMemento(caretaker.getMemento(savedScore-1)).getTileHoriz());
             //       p.setTileVerti(originator.restoreFromMemento(caretaker.getMemento(savedScore-1)).getTileVerti());
           //     g.drawImage(p.getPlayer(), p.getTileHoriz() * 32, p.getTileVerti() * 32, null);
            //}
            //else 
            g.drawImage(p.getPlayer(), p.getTileHoriz() * 32, p.getTileVerti() * 32, null);
            g.drawImage(monster.getMonster(), monster.getTileHoriz() * 32, monster.getTileVerti() * 32, null);
             //while(currenttime<starttime+120000){
             
         
             g.drawImage(monster2.getMonster(), monster2.getTileHoriz() * 32, monster2.getTileVerti() * 32, null);
             
             
             if(pause==false)
                 
             { 
                if(paintcounter%10==0) {
                 monster2.move();
           monster.move();}}
          Maze.bullet.setText(String.valueOf(count));


      //  currenttime=cal.getTimeInMillis();
      //  break;
        
      //  }
            
            if (bulletflag == true) {
                
                g.drawImage(bullet.getBullet(), bullet.getTileHoriz() * 32, bullet.getTileVerti() * 32, null);
                bullet.setTileHoriz(bullet.getTileHoriz() + 1);
            }
            
            
            //  g.drawImage(bullet.getBullet(), p.getTileHoriz()  * 5, p.getTileVerti() * 5, null);
        }
        if (win) {
            g.setColor(Color.RED);
            g.setFont(font);
            
            g.drawString(Message, 150, 300);
            
        }
        
    }
    
    public class keyboard extends KeyAdapter {
        
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            
            if (keycode == KeyEvent.VK_P) {
                
                pause=true;
               
               JOptionPane.showOptionDialog(null, 
        "Game Paused!", 
        "Feedback", 
        JOptionPane.OK_CANCEL_OPTION, 
        JOptionPane.INFORMATION_MESSAGE, 
        null, 
        new String[]{"UnPause"}, 
        "default");
               pause=false;
               
            }
            
            if (keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP) {
                if (!m.getMap(p.getTileHoriz(), p.getTileVerti() - 1).equals("t") && !m.getMap(p.getTileHoriz(), p.getTileVerti() - 1).equals("w")) {
                    p.move(0, -1);
                    
                   // monster.move();
                    //  newChange(p, 0, 10);
                    //p.score=p.score+10;
                    Maze.scorevalue.setText(String.valueOf(p.score));
                   // Maze.scorevalue.setText(String.valueOf(p.health));

                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("b")) {
                    factorybomb("b");
                    
                    bomb.damage(p);
                    p.damageHealth();
                    p.setPlayerState(p.normal);
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    //what happens for bomb
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("k")) {
                    factorybomb("k");
                    
                    bomb.damage(p);
                    //State dp to remove Armour
                    p.damageHealth();
                    p.setPlayerState(p.normal);
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    //what happens for bomb
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("c")) {
                    factorygift("c");
                    if (p.changed != 1) {
                        gift.giftFunction(p);
                    }
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));

                    //  ArmourGift.giftFunction(p);
                    //  m.clearBounty();
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("A")) {
                    factorygift("c");
                    if (p.changed != 1) {
                        gift.giftFunction(p);
                    }
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    //  m.clearBounty2();
                }
                
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("n")) {
                    
                    factorygift("n");
                    gift.giftFunction(p);
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("h")) {
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    
                    if (p.health < 100) {
                        factorygift("h");
                        gift.giftFunction(p);
                    }
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    
                }
                
                 if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("z")) {
                     
                      checkpoint=true;
                    memento.setTileHoriz(p.getTileHoriz());
                    memento.setTileVerti(p.getTileVerti());
                    memento.score=p.score;
                     originator.set(memento);
                     caretaker.addMemento(originator.storeInMemento());
                     savedScore++;
                          
                   
                }
                
            }
            if (keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN) {
                if (!m.getMap(p.getTileHoriz(), p.getTileVerti() + 1).equals("t") && !m.getMap(p.getTileHoriz(), p.getTileVerti() + 1).equals("w")) {
                    p.move(0, 1);
                    
                  //  monster.move();
                    //  newChange(p, 0, 10);
                    //p.score=p.score+10;
                    Maze.scorevalue.setText(String.valueOf(p.score));
                                       // Maze.scorevalue.setText(String.valueOf(p.health));

                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("b")) {
                    factorybomb("b");
                    bomb.damage(p);
                    p.damageHealth();
                    p.setPlayerState(p.normal);
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("k")) {
                    factorybomb("k");
                    
                    bomb.damage(p);
                    //State dp to remove Armour
                    p.damageHealth();
                    p.setPlayerState(p.normal);
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    //what happens for bomb
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("c")) {
                    factorygift("c");
                    if (p.changed != 1) {
                        gift.giftFunction(p);
                    }
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);

                    //  m.clearBounty();
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("A")) {
                    factorygift("c");
                    if (p.changed != 1) {
                        gift.giftFunction(p);
                    }
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);

                    //   m.clearBounty2();
                }
                
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("n")) {
                    
                    factorygift("n");
                    gift.giftFunction(p);
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("h")) {
                    
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    
                    if (p.health < 100) {
                        factorygift("h");
                        gift.giftFunction(p);
                    }
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("z")) {
                     
                    checkpoint=true;
                    memento.setTileHoriz(p.getTileHoriz());
                    memento.setTileVerti(p.getTileVerti());
                    memento.score=p.score;
                     originator.set(memento);
                     caretaker.addMemento(originator.storeInMemento());
                     savedScore++;
                     
                   
                     
                     
                     
                   
                }
            }
            if (keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT) {
                if (!m.getMap(p.getTileHoriz() - 1, p.getTileVerti()).equals("t") && !m.getMap(p.getTileHoriz() - 1, p.getTileVerti()).equals("w")) {
                    p.move(-1, 0);
                     
                   // monster.move();
                    //  newChange(p, 0, 10);
                    //p.score=p.score+10;
                    Maze.scorevalue.setText(String.valueOf(p.score));
                                     //   Maze.scorevalue.setText(String.valueOf(p.health));

                }
                
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("b")) {
                    factorybomb("b");
                    bomb.damage(p);
                    p.damageHealth();
                    p.setPlayerState(p.normal);
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("k")) {
                    factorybomb("k");
                    
                    bomb.damage(p);
                    //State dp to remove Armour
                    p.damageHealth();
                    p.setPlayerState(p.normal);
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    //what happens for bomb
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("c")) {
                    factorygift("c");
                    if (p.changed != 1) {
                        gift.giftFunction(p);
                    }
                    
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);

                    // m.clearBounty();
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("A")) {
                    factorygift("c");
                    if (p.changed != 1) {
                        gift.giftFunction(p);
                    }
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);

                    // m.clearBounty2();
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("n")) {
                    
                    factorygift("n");
                    gift.giftFunction(p);
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("h")) {
                    
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    
                    if (p.health < 100) {
                        factorygift("h");
                        gift.giftFunction(p);
                    }
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("z")) {
                     
                    checkpoint=true;
                    memento.setTileHoriz(p.getTileHoriz());
                    memento.setTileVerti(p.getTileVerti());
                    memento.score=p.score;
                     originator.set(memento);
                     caretaker.addMemento(originator.storeInMemento());
                     savedScore++;
                     
                    
                   
                }
            }
            if (keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT) {
                if (!m.getMap(p.getTileHoriz() + 1, p.getTileVerti()).equals("t") && !m.getMap(p.getTileHoriz() + 1, p.getTileVerti()).equals("w")) {
                    p.move(1, 0);
                    
                   // monster.move();
                    // newChange(p, 0, 10);
                    //p.score=p.score+10;
                    Maze.scorevalue.setText(String.valueOf(p.score));
                   // Maze.scorevalue.setText(String.valueOf(p.health));
                }
                
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("b")) {
                    factorybomb("b");
                    bomb.damage(p);
                    p.damageHealth();
                    p.setPlayerState(p.normal);
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("k")) {
                    factorybomb("k");
                    
                    bomb.damage(p);
                    //State dp to remove Armour
                    p.damageHealth();
                    p.setPlayerState(p.normal);
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    //what happens for bomb
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("c")) {
                    factorygift("c");
                    if (p.changed != 1) {
                        gift.giftFunction(p);
                    }
                    // m.clearBounty();
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    
                }
                //giftDuplicate
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("A")) {
                    factorygift("c");
                    if (p.changed != 1) {
                        gift.giftFunction(p);
                    }
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);

                    // m.clearBounty2();
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("n")) {
                    
                    factorygift("n");
                    
                    gift.giftFunction(p);
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("h")) {
                    
                    m.Map[p.getTileVerti()] = m.Map[p.getTileVerti()].substring(0, p.getTileHoriz()) + "g" + m.Map[p.getTileVerti()].substring(p.getTileHoriz() + 1);
                    
                    if (p.health < 100) {
                        factorygift("h");
                        gift.giftFunction(p);
                    }
                    Maze.healthvalue.setText(String.valueOf(p.health));
                    Maze.scorevalue.setText(String.valueOf(p.score));
                    
                }
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("z")) {
                     
                     checkpoint=true;
                    memento.setTileHoriz(p.getTileHoriz());
                    memento.setTileVerti(p.getTileVerti());
                    memento.score=p.score;
                     originator.set(memento);
                     caretaker.addMemento(originator.storeInMemento());
                     savedScore++;
                     
                    
                }
            }

            //sword
            if (keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP) {
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("s")) {
                    factorygift("s");
                    if (p.changedT != 1) {
                        Description = player2.getDescription();
                        if (Description.equals("Timmy")) {
                            p.changeTimmy();
                            gift.giftFunction(p);
                            //count=count+3;
                        }
                    }
                    Maze.bullet.setText(String.valueOf(count));
                    m.clearSword2();
                }
                
            }
            
            if (keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN) {
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("s")) {
                    factorygift("s");
                    if (p.changedT != 1) {
                        Description = player2.getDescription();
                        if (Description.equals("Timmy")) {
                            p.changeTimmy();
                            gift.giftFunction(p);
                            //count=count+3;
                        }
                    }
                    Maze.bullet.setText(String.valueOf(count));
                    m.clearSword2();
                }
                
            }
            if (keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT) {
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("s")) {
                    factorygift("s");
                    if (p.changedT != 1) {
                        Description = player2.getDescription();
                        if (Description.equals("Timmy")) {
                            p.changeTimmy();
                            gift.giftFunction(p);
                            //count=count+3;
                        }
                    }
                    Maze.bullet.setText(String.valueOf(count));
                    m.clearSword2();
                }
                
            }
            if (keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT) {
                if (m.getMap(p.getTileHoriz(), p.getTileVerti()).equals("s")) {
                    factorygift("s");
                    
                    if (p.changedT != 1) {
                        Description = player2.getDescription();
                        if (Description.equals("Timmy")) {
                            p.changeTimmy();
                            gift.giftFunction(p);
                            //count=count+3;
                        }
                    }
                    Maze.bullet.setText(String.valueOf(count));
                    m.clearSword2();
                    
                }
            }
            if (keycode == KeyEvent.VK_SPACE) {
                if (count > 0) {
                    bulletflag = true;
                    bullet.setTileHoriz(p.getTileHoriz());
                    bullet.setTileVerti(p.getTileVerti());

                    // bullet.setPlayer(p);
                    while (!(m.getMap(bullet.getTileHoriz() + 1, bullet.getTileVerti()).equals("t")) && !(m.getMap(bullet.getTileHoriz() + 1, bullet.getTileVerti()).equals("n")) && !(m.getMap(bullet.getTileHoriz() + 1, bullet.getTileVerti()).equals("c")) && !(m.getMap(bullet.getTileHoriz() + 1, bullet.getTileVerti()).equals("k")) && !(m.getMap(bullet.getTileHoriz() + 1, bullet.getTileVerti()).equals("s")) && !(m.getMap(bullet.getTileHoriz() + 1, bullet.getTileVerti()).equals("A")) && !(m.getMap(bullet.getTileHoriz() + 1, bullet.getTileVerti()).equals("h"))) {
                        bulletflag = true;
                        // if(m.getMap(p.getTileHoriz()+1, p.getTileVerti()).equals("t"))
                        if (!(m.getMap(bullet.getTileHoriz() + 1, bullet.getTileVerti()).equals("w"))) {
                            wallflag = false;
                            
                            bullet.move(1, 0);
                        } else {
                            wallflag = true;
                            break;
                        }

                        //   paint(g2);
                        // hori=hori+1;
                        // }
                    }
                    
                    count = count - 1;
                    Maze.bullet.setText(String.valueOf(count));
                    
                    if (wallflag == false) {
                        m.Map[bullet.getTileVerti()] = m.Map[bullet.getTileVerti()].substring(0, bullet.getTileHoriz() + 1) + "g" + m.Map[bullet.getTileVerti()].substring(bullet.getTileHoriz() + 2);
                        bullet.move(1, 0);
                        
                    }
                    if (wallflag == true) {
                        wallflag = false;
                    }
                    //   bulletflag=false;
                    
                }
                
            }
        }
        
        public void keyRelased(KeyEvent e) {
        }
        
        public void keyTyped(KeyEvent e) {
        }
        
    }
    
    public class BackgroundImage extends JFrame {
        
        JLabel l1;
        
        public BackgroundImage() {
            setSize(665, 690);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
            setLayout(new BorderLayout());
            JLabel background = new JLabel(new ImageIcon(this.getClass().getResource("win.jpg")));
            add(background);
            background.setLayout(new FlowLayout());
            
        }
        
    }

    public void factorybomb(String s) {
        
        if (s.equals("b")) {
            bomb = new HealthBomb();
        }
        if (s.equals("k")) {
            bomb = new ScoreBomb();
        }
        
    }
    
    public void factorygift(String s) {
        
        if (s.equals("c")) {
            gift = new ArmourGift();
        }
        if (s.equals("n")) {
            gift = new ScoreGift();
        }
        if (s.equals("s")) {
            gift = new BulletGift();
        }
        if (s.equals("h")) {
            gift = new HealthGift();
        }
        
    }
    
    @Override
    public void AddObserver(Observer o) {
        observers.add(o);
    }
    
    @Override
    public void RemoveObserver(Observer o) {
        observers.remove(o);
    }
    
    @Override
    public void NotifyObsevers(Player p, int x, int y) {
        
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).Update(p, x, y);
        }
    }
    
    public void newChange(Player p, int x, int y) {
        NotifyObsevers(p, x, y);
        
    }
}
