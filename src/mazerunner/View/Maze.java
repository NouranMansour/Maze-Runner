
package mazerunner.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import mazerunner.Controller.Board;
/**
 *
 * @author Lenovo
 */
public class Maze {
    private JPanel sidePanel;
	private JLabel score;
        private JLabel health;
        private JLabel timer;
        private JLabel Bullet;
        public static JLabel scorevalue = new JLabel();
        public static JLabel healthvalue = new JLabel();
        public static JLabel timervalue = new JLabel();
        public static JLabel bullet = new JLabel();
        public static int timeF = 0;
        public static int Tindex ;
        
        
        GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
                  0, 0, 0, 0), 0, 0);
     
    
   static  Thread thread = new Thread();
     public static void main(String[] args) throws InterruptedException {
      //  new Maze();
        
      
        //for(Tindex =60;Tindex>=0;Tindex--){
         //   thread.sleep(1000);
           // timervalue.setText(":"+String.valueOf(Tindex));
       // }
       // timeF = 1 ;
    }
public void Timer() throws InterruptedException{
    
    for(Tindex =180;Tindex>=0;Tindex--){
            thread.sleep(1000);
            timervalue.setText(":"+String.valueOf(Tindex));
        }
        timeF = 1 ;
}
    public Maze() throws InterruptedException {
        
       
       
        JFrame f = new JFrame();
        sidePanel = new JPanel(new GridBagLayout());
        sidePanel.setPreferredSize(new Dimension(185, 690));
	sidePanel.setBackground(new Color(240, 240, 240));
	sidePanel.setLayout(new GridBagLayout());
	sidePanel.setBorder(new LineBorder(Color.BLACK, 2));
        sidePanel.add(new JLabel("Score"), gbc);
        sidePanel.setBackground(Color.WHITE);
        
       gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.anchor = GridBagConstraints.CENTER;

        sidePanel.add(scorevalue, gbc);
        
        gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.anchor = GridBagConstraints.CENTER;

        sidePanel.add(new JLabel("Health"), gbc);
         gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.anchor = GridBagConstraints.CENTER;

        sidePanel.add(healthvalue, gbc);
        
         gbc.gridx = 1;
      gbc.gridy = 2;
      gbc.anchor = GridBagConstraints.CENTER;

        sidePanel.add(timervalue, gbc);
        
         gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.anchor = GridBagConstraints.CENTER;

        sidePanel.add(new JLabel("Timer"), gbc);
        
        
          gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.anchor = GridBagConstraints.FIRST_LINE_END;

        sidePanel.add(bullet, gbc);
        
         gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.anchor = GridBagConstraints.FIRST_LINE_START;

        sidePanel.add(new JLabel("Bullets"), gbc);
        
        f.setTitle("Maze Runner");
        f.add(new Board());
        f.setSize(850, 690);
        f.setLocationRelativeTo(null);
        // f.add(sidePanel, BorderLayout.SOUTH);
        f.getContentPane().add(sidePanel,BorderLayout.EAST);
        //f.add(sidePanel,BorderLayout.NORTH);
        f.setVisible(true);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Timer();
        
    }
     
}
